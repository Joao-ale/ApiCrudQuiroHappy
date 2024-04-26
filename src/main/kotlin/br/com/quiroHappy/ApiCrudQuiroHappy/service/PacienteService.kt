package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.PacienteFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.PacienteViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.PacienteRepository
import org.springframework.stereotype.Service

@Service
class PacienteService(
    private val pacienteRepository: PacienteRepository,
    private val pacienteViewMapper: PacienteViewMapper,
    private val pacienteFormMapper: PacienteFormMapper,
    private val anamneseMapper: AnamneseMapper,
    private val prontuarioMapper: ProntuarioMapper,
    private val anamneseViewMapper: AnamneseViewMapper,
    private val prontuarioViewMapper: ProntuarioViewMapper
) {

    fun getAllPacientes(): List<PacienteView> {
        val pacientes = pacienteRepository.findAll()
        val pacientesView : List<PacienteView> = ArrayList()
        pacientes.forEach { paciente ->
            pacientesView.plus(
                pacienteViewMapper.map(
                    paciente,
                    anamneseViewMapper,
                    prontuarioViewMapper
                )
            )
        }

        return pacientesView
    }

    fun getPacienteById(id: Long): PacienteView {
        val paciente = pacienteRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR401.message.format(id),
                Errors.QR401.code
            )
        }

        return pacienteViewMapper.map(
            paciente,
            anamneseViewMapper,
            prontuarioViewMapper
        )
    }

    fun createPaciente(paciente: PacienteForm): PacienteView {
        val pacienteCreated = pacienteRepository.save(
            pacienteFormMapper.map(
                paciente,
                anamneseMapper,
                prontuarioMapper
            )
        )

        return pacienteViewMapper.map(
            pacienteCreated,
            anamneseViewMapper,
            prontuarioViewMapper
        )
    }

    fun updatePaciente(id: Long, updatedPaciente: PacienteUpdatedForm): PacienteView? {
        val paciente = pacienteRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR301.message.format(id),
                    Errors.QR301.code
                )
            }

            paciente.anamnese = anamneseMapper.map(updatedPaciente.fichaAnamnese)
            paciente.prontuario = prontuarioMapper.map(updatedPaciente.prontuario, anamneseMapper)
            paciente.dataAgendamento = updatedPaciente.dataAgendamento

        val pacienteUpdated = pacienteRepository.save(paciente)
        return pacienteViewMapper.map(
            pacienteUpdated,
            anamneseViewMapper,
            prontuarioViewMapper
        )
    }

    fun deletePaciente(id: Long) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR401.message.format(id),
                Errors.QR401.code
            )
        }
    }
}
