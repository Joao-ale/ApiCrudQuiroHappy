package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.HistoricoClinicoDoencas
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.HistoricoClinicoDoencasRepository
import org.springframework.stereotype.Service

@Service
class HistoricoClinicoDoencasService(private val historicoClinicoDoencasRepository: HistoricoClinicoDoencasRepository) {

    fun getAllHistoricoClinicoDoencas(): List<HistoricoClinicoDoencas> {
        return historicoClinicoDoencasRepository.findAll()
    }

    fun getHistoricoClinicoDoencasById(id: Long): HistoricoClinicoDoencas? {
        return historicoClinicoDoencasRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR301.message.format(id),
                Errors.QR301.code
            )
        }
    }

    fun createHistoricoClinicoDoencas(historicoClinicoDoencas: HistoricoClinicoDoencas): HistoricoClinicoDoencas {
        return historicoClinicoDoencasRepository.save(historicoClinicoDoencas)
    }

    fun updateHistoricoClinicoDoencas(id: Long, updatedHistoricoClinicoDoencas: HistoricoClinicoDoencas): HistoricoClinicoDoencas? {
        val existingHistoricoClinicoDoencas = historicoClinicoDoencasRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR301.message.format(id),
                    Errors.QR301.code
                )
            }

        existingHistoricoClinicoDoencas.pacienteId = updatedHistoricoClinicoDoencas.pacienteId
        existingHistoricoClinicoDoencas.hipertensao = updatedHistoricoClinicoDoencas.hipertensao
        existingHistoricoClinicoDoencas.diabetes = updatedHistoricoClinicoDoencas.diabetes
        existingHistoricoClinicoDoencas.dislipidemias = updatedHistoricoClinicoDoencas.dislipidemias
        existingHistoricoClinicoDoencas.renal = updatedHistoricoClinicoDoencas.renal
        existingHistoricoClinicoDoencas.hepatica = updatedHistoricoClinicoDoencas.hepatica
        existingHistoricoClinicoDoencas.cardiovascular = updatedHistoricoClinicoDoencas.cardiovascular
        existingHistoricoClinicoDoencas.osteoporose = updatedHistoricoClinicoDoencas.osteoporose
        existingHistoricoClinicoDoencas.cancer = updatedHistoricoClinicoDoencas.cancer
        existingHistoricoClinicoDoencas.respiratoria = updatedHistoricoClinicoDoencas.respiratoria
        existingHistoricoClinicoDoencas.genitoUrinaria = updatedHistoricoClinicoDoencas.genitoUrinaria
        existingHistoricoClinicoDoencas.gastrointestinal = updatedHistoricoClinicoDoencas.gastrointestinal
        existingHistoricoClinicoDoencas.endocrina = updatedHistoricoClinicoDoencas.endocrina
        existingHistoricoClinicoDoencas.pele = updatedHistoricoClinicoDoencas.pele
        existingHistoricoClinicoDoencas.osteomioarticular = updatedHistoricoClinicoDoencas.osteomioarticular
        existingHistoricoClinicoDoencas.neurologica = updatedHistoricoClinicoDoencas.neurologica

        return historicoClinicoDoencasRepository.save(existingHistoricoClinicoDoencas)
    }

    fun deleteHistoricoClinicoDoencas(id: Long) {
        if (historicoClinicoDoencasRepository.existsById(id)) {
            historicoClinicoDoencasRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR301.message.format(id),
                Errors.QR301.code
            )
        }
    }
}
