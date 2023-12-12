package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.ProntuarioRepository
import org.springframework.stereotype.Service

@Service
class ProntuarioService(private val prontuarioRepository: ProntuarioRepository) {

    fun getAllProntuarios(): List<Prontuario> {
        return prontuarioRepository.findAll()
    }

    fun getProntuarioById(id: Long): Prontuario? {
        return prontuarioRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }
    }

    fun createProntuario(prontuario: Prontuario): Prontuario {
        return prontuarioRepository.save(prontuario)
    }

    fun updateProntuario(id: Long, updatedProntuario: Prontuario): Prontuario? {
        val existingProntuario = prontuarioRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR101.message.format(id),
                    Errors.QR101.code
                )
            }

        existingProntuario.fichaAnamnese = updatedProntuario.fichaAnamnese
        existingProntuario.endereco = updatedProntuario.endereco
        existingProntuario.telefone = updatedProntuario.telefone
        existingProntuario.telefoneRespon = updatedProntuario.telefoneRespon
        existingProntuario.quiropraxista = updatedProntuario.quiropraxista
        existingProntuario.ocupacao = updatedProntuario.ocupacao
        existingProntuario.limitacao = updatedProntuario.limitacao
        existingProntuario.alergia = updatedProntuario.alergia
        existingProntuario.queixaDores = updatedProntuario.queixaDores

        return prontuarioRepository.save(existingProntuario)
    }

    fun deleteProntuario(id: Long) {
        if (prontuarioRepository.existsById(id)) {
            prontuarioRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }
    }
}
