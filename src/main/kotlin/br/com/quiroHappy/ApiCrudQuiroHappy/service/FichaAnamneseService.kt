package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.FichaAnamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.FichaAnamneseRepository

class FichaAnamneseService(private val fichaAnamneseRepository: FichaAnamneseRepository) {

    fun getFichaAnamneses(): List<FichaAnamnese> {
        return fichaAnamneseRepository.findAll()
    }

    fun getFichaAnamneseById(id: Long): FichaAnamnese? {
        return fichaAnamneseRepository.findById(id).orElse(null)
    }

    fun createFichaAnamnese(fichaAnamnese: FichaAnamnese): FichaAnamnese {
        return fichaAnamneseRepository.save(fichaAnamnese)
    }

    fun updateFichaAnamnese(id: Long, updatedFichaAnamnese: FichaAnamnese): FichaAnamnese {
        val existingFichaAnamnese = fichaAnamneseRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR151.message.format(id),
                    Errors.QR151.code
                )
            }

        // Atualiza os campos necessários
        existingFichaAnamnese.nomeCompleto = updatedFichaAnamnese.nomeCompleto
        existingFichaAnamnese.dataNasc = updatedFichaAnamnese.dataNasc
        existingFichaAnamnese.sexo = updatedFichaAnamnese.sexo
        existingFichaAnamnese.ocupacaoProfissional = updatedFichaAnamnese.ocupacaoProfissional
        existingFichaAnamnese.atividadeFisica = updatedFichaAnamnese.atividadeFisica
        existingFichaAnamnese.peso = updatedFichaAnamnese.peso
        existingFichaAnamnese.altura = updatedFichaAnamnese.altura
        existingFichaAnamnese.protese = updatedFichaAnamnese.protese
        existingFichaAnamnese.internacaoCirurgias = updatedFichaAnamnese.internacaoCirurgias
        existingFichaAnamnese.traumasQuedas = updatedFichaAnamnese.traumasQuedas
        existingFichaAnamnese.tabagismo = updatedFichaAnamnese.tabagismo
        existingFichaAnamnese.etilismo = updatedFichaAnamnese.etilismo
        existingFichaAnamnese.qualidadeSono = updatedFichaAnamnese.qualidadeSono

        return fichaAnamneseRepository.save(existingFichaAnamnese)
    }

    fun deleteFichaAnamnese(id: Long) {
        if (fichaAnamneseRepository.existsById(id)) {
            fichaAnamneseRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR151.message.format(id),
                Errors.QR151.code
            )
        }
    }
}