package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Topicos
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.TopicosRepository
import org.springframework.stereotype.Service

@Service
class TopicosService(private val topicosRepository: TopicosRepository) {

    fun getAllTopicos(): List<Topicos> {
        return topicosRepository.findAll()
    }

    fun getTopicosById(id: Long): Topicos? {
        return topicosRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR301.message.format(id),
                Errors.QR301.code
            )
        }
    }

    fun createTopicos(topicos: Topicos): Topicos {
        return topicosRepository.save(topicos)
    }

    fun updateTopicos(id: Long, updatedTopicos: Topicos): Topicos? {
        val existingTopicos = topicosRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR301.message.format(id),
                    Errors.QR301.code
                )
            }

        existingTopicos.pacienteId = updatedTopicos.pacienteId
        existingTopicos.examImagem = updatedTopicos.examImagem
        existingTopicos.historicoCond = updatedTopicos.historicoCond
        existingTopicos.tecObs = updatedTopicos.tecObs

        return topicosRepository.save(existingTopicos)
    }

    fun deleteTopicos(id: Long) {
        if (topicosRepository.existsById(id)) {
            topicosRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR201.message.format(id),
                Errors.QR201.code
            )
        }
    }
}
