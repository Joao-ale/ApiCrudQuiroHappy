package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Limitacoes
import org.springframework.data.jpa.repository.JpaRepository

interface LimitacoesRepository:JpaRepository<Limitacoes,Long> {

}
