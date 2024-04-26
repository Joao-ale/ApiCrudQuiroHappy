package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.FichaAnamneseRepository
import org.springframework.stereotype.Service

@Service
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

    fun updateFichaAnamnese(id: Long, anamneseUpdated: AnamneseUpdatedForm): AnamneseView {
        val fichaAnamnese = anamneseRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR151.message.format(id),
                    Errors.QR151.code
                )
            }

            fichaAnamnese.nomeCompleto = anamneseUpdated.nomeCompleto
            fichaAnamnese.sexo = anamneseUpdated.sexo
            fichaAnamnese.ocupacaoProfissional = anamneseUpdated.ocupacaoProfissional
            fichaAnamnese.peso = anamneseUpdated.peso
            fichaAnamnese.altura = anamneseUpdated.altura
            fichaAnamnese.protese = anamneseUpdated.protese
            fichaAnamnese.internacaoCirurgias = anamneseUpdated.internacaoCirurgias
            fichaAnamnese.traumasQuedas = anamneseUpdated.traumasQuedas
            fichaAnamnese.tabagismo = anamneseUpdated.tabagismo
            fichaAnamnese.etilismo = anamneseUpdated.etilismo
            fichaAnamnese.qualidadeSono = anamneseUpdated.qualidadeSono

        val newAnamnese = anamneseRepository.save(fichaAnamnese)
        return anamneseViewMapper.map(newAnamnese)
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