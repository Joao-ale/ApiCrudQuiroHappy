package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Segmentos
import org.springframework.data.jpa.repository.JpaRepository

interface SegmentosRepository: JpaRepository<Segmentos, Long>{
}
