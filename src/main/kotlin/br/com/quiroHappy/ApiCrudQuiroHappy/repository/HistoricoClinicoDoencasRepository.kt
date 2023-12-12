package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.HistoricoClinicoDoencas
import org.springframework.data.jpa.repository.JpaRepository

interface HistoricoClinicoDoencasRepository:JpaRepository<HistoricoClinicoDoencas,Long> {

}
