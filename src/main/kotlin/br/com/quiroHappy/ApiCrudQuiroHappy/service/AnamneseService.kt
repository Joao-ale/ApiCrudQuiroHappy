package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.FichaAnamneseRepository

class AnamneseService(
    private val anamneseRepository: FichaAnamneseRepository,
    private val anamneseViewMapper: AnamneseViewMapper,
    private val anamneseFormMapper: AnamneseFormMapper

) {

    fun getFichaAnamneses(): List<AnamneseView> {
        val fichasAnamneses = anamneseRepository.findAll()
        val fichasAnamneseView : List<AnamneseView> =  ArrayList()

        fichasAnamneses.forEach { fichaAnamnese  ->
            fichasAnamneseView.plus(anamneseViewMapper.map(fichaAnamnese))
        }

        return fichasAnamneseView
    }

    fun getFichaAnamneseById(id: Long): AnamneseView {
        val fichaAnamnese= anamneseRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR151.message.format(id),
                    Errors.QR151.code
                )
            }
        return anamneseViewMapper.map(fichaAnamnese)
    }

    fun createFichaAnamnese(anamnese: AnamneseForm): AnamneseView {
        val fichaAnamnese = anamneseRepository.save(anamneseFormMapper.map(anamnese))

        return anamneseViewMapper.map(fichaAnamnese)
    }

    fun updateFichaAnamnese(id: Long, updatedAnamnese: AnamneseUpdatedForm): AnamneseView {
        val existingFichaAnamnese = anamneseRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR151.message.format(id),
                    Errors.QR151.code
                )
            }

        val fichaAnamnese = Anamnese(
            id = existingFichaAnamnese.id,
            paciente = existingFichaAnamnese.paciente,
            nomeCompleto = updatedAnamnese.nomeCompleto,
            dataNasc = existingFichaAnamnese.dataNasc,
            sexo = updatedAnamnese.sexo,
            ocupacaoProfissional = updatedAnamnese.ocupacaoProfissional,
            peso = updatedAnamnese.peso,
            altura = updatedAnamnese.altura,
            protese = updatedAnamnese.protese,
            internacaoCirurgias = updatedAnamnese.internacaoCirurgias,
            traumasQuedas = updatedAnamnese.traumasQuedas,
            tabagismo = updatedAnamnese.tabagismo,
            etilismo = updatedAnamnese.etilismo,
            qualidadeSono = updatedAnamnese.qualidadeSono
        )

        val fichaAnamneseUpdated = anamneseRepository.save(fichaAnamnese)
        return anamneseViewMapper.map(fichaAnamneseUpdated)
    }

    fun deleteFichaAnamnese(id: Long) {
        if (anamneseRepository.existsById(id)) {
            anamneseRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR151.message.format(id),
                Errors.QR151.code
            )
        }
    }
}