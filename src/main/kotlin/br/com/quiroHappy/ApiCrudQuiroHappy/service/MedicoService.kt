package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.MedicoRepository

class MedicoService(private val medicoRepository: MedicoRepository) {

    fun getMedicos(): List<Medico> {
        return medicoRepository.findAll()
    }

    fun getMedicoById(id: Long): Medico? {
        return medicoRepository.findById(id).orElse(null)
    }

    fun createMedico(medico: Medico): Medico {
        return medicoRepository.save(medico)
    }

    fun updateMedico(id: Long, updatedMedico: Medico): Medico? {
        val existingMedico = medicoRepository.findById(id)
            .orElseThrow { NotFoundException(
                Errors.QR201.message.format(id),
                Errors.QR201.code
            ) }

        // Atualiza os campos necessários
        existingMedico.nome = updatedMedico.nome
        existingMedico.crm = updatedMedico.crm

        return medicoRepository.save(existingMedico)
    }

    fun deleteMedico(id: Long) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR201.message.format(id),
                Errors.QR201.code
            )
        }
    }
}