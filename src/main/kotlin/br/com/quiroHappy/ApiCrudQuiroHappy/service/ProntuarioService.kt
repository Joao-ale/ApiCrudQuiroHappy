package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.ProntuarioRepository
import org.springframework.stereotype.Service

@Service
class ProntuarioService(
    private val prontuarioRepository: ProntuarioRepository
) {

    fun getProntuarios(): List<Prontuario>{
        return prontuarioRepository.findAll()
    }

    fun getProntuarioById(id: Long): Prontuario? {
        return prontuarioRepository.findById(id).orElseThrow{
            NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }
    }

    fun createProntuario(prontuario: Prontuario){
        prontuarioRepository.save(prontuario)
    }
}