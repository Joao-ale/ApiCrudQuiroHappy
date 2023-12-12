package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.LimitacoesRepository

class LimitacoesService(private val limitacoesRepository: LimitacoesRepository) {

    fun getLimitacoes(): List<Limitacoes> {
        return limitacoesRepository.findAll()
    }

    fun getLimitacaoById(id: Long): Limitacoes? {
        return limitacoesRepository.findById(id).orElse(null)
    }

    fun createLimitacoes(limitacoes: Limitacoes): Limitacoes {
        return limitacoesRepository.save(limitacoes)
    }

    fun updateLimitacoes(id: Long, updatedLimitacoes: Limitacoes): Limitacoes? {
        val existingLimitacao = limitacoesRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR351.message.format(id),
                    Errors.QR351.code
                )
            }

        // Atualiza os campos necessários
        existingLimitacao.nome = updatedLimitacoes.nome
        return limitacoesRepository.save(existingLimitacao)
    }

    fun deleteLimitacao(id: Long) {
        if (limitacoesRepository.existsById(id)) {
            limitacoesRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR351.message.format(id),
                Errors.QR351.code
            )
        }
    }
}
