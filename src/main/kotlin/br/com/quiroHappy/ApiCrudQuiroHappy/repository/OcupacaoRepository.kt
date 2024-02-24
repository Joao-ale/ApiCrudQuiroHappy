package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Ocupacao
import org.springframework.data.jpa.repository.JpaRepository

interface OcupacaoRepository: JpaRepository<Ocupacao, Long> {

}
