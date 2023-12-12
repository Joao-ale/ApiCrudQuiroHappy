package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Segmentos
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.SegmentosRepository

class SegmentoService(private val segmentosRepository: SegmentosRepository) {

    fun getSegmentos(): List<Segmentos> {
        return segmentosRepository.findAll()
    }

    fun getSegmentosById(id: Long): Segmentos? {
        return segmentosRepository.findById(id).orElse(null)
    }

    fun createSegmentos(segmentos: Segmentos): Segmentos {
        return segmentosRepository.save(segmentos)
    }
}