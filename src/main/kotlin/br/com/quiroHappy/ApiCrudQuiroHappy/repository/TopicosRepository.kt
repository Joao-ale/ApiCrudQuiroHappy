package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Topicos
import org.springframework.data.jpa.repository.JpaRepository

interface TopicosRepository: JpaRepository<Topicos, Long> {

}
