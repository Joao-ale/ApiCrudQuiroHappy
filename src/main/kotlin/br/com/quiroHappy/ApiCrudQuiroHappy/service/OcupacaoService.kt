package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Ocupacao
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.OcupacaoRepository

class OcupacaoService(
    private val ocupacaoRepository: OcupacaoRepository
) {

    fun getAllOcupacao(): List<Ocupacao> {
        return ocupacaoRepository.findAll()
    }

    fun getOcupacaoById(id: Long): Ocupacao {
        return ocupacaoRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR451.message.format(id),
                Errors.QR451.code
            )
        }
    }

    fun createOcupacao(ocupacao: Ocupacao): Ocupacao {
        return ocupacaoRepository.save(ocupacao)
    }

}