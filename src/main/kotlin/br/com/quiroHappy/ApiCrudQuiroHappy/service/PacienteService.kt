package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.PacienteFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.PacienteViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.PacienteRepository
import org.springframework.stereotype.Service

@Service
class PacienteService(
    private val pacienteRepository: PacienteRepository,
    private val pacienteViewMapper: PacienteViewMapper,
    private val pacienteFormMapper: PacienteFormMapper
) {

    fun getAllPacientes(): List<PacienteView> {
        val pacientes = pacienteRepository.findAll()
        val pacientesView : List<PacienteView> = ArrayList()
        pacientes.forEach { paciente ->
            pacientesView.plus(pacienteViewMapper.map(paciente))
        }

        return pacientesView
    }

    fun getPacienteById(id: Long): PacienteView? {
        val paciente = pacienteRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR401.message.format(id),
                Errors.QR401.code
            )
        }

        return pacienteViewMapper.map(paciente)
    }

    fun createPaciente(paciente: PacienteForm): PacienteView {
        val pacienteCreated = pacienteRepository.save(pacienteFormMapper.map(paciente))

        return pacienteViewMapper.map(pacienteCreated)
    }

    fun updatePaciente(id: Long, updatedPaciente: PacienteUpdatedForm): PacienteView? {
        val existingPaciente = pacienteRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR301.message.format(id),
                    Errors.QR301.code
                )
            }
        val paciente = Paciente(
            id = existingPaciente.id,
            fichaAnamnese = updatedPaciente.fichaAnamnese,
            prontuario = updatedPaciente.prontuario,
            dataAgendamento = updatedPaciente.dataAgendamento
        )

        val pacienteUpdated = pacienteRepository.save(paciente)
        return pacienteViewMapper.map(pacienteUpdated)
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
