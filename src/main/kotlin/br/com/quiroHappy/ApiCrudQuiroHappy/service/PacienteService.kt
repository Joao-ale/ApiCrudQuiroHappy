package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.PacienteRepository
import org.springframework.stereotype.Service

@Service
class PacienteService(private val pacienteRepository: PacienteRepository) {

    fun getAllPacientes(): List<Paciente> {
        return pacienteRepository.findAll()
    }

    fun getPacienteById(id: Long): Paciente? {
        return pacienteRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR401.message.format(id),
                Errors.QR401.code
            )
        }
    }

    fun createPaciente(paciente: Paciente): Paciente {
        return pacienteRepository.save(paciente)
    }

    fun updatePaciente(id: Long, updatedPaciente: Paciente): Paciente? {
        val existingPaciente = pacienteRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR301.message.format(id),
                    Errors.QR301.code
                )
            }

        existingPaciente.fichasAnamnese = updatedPaciente.fichasAnamnese
        existingPaciente.prontuario = updatedPaciente.prontuario
        existingPaciente.dataAgendamento = updatedPaciente.dataAgendamento

        return pacienteRepository.save(existingPaciente)
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
