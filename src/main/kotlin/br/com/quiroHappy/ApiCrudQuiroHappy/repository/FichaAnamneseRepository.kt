package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.FichaAnamnese
import org.springframework.data.jpa.repository.JpaRepository

interface FichaAnamneseRepository: JpaRepository<FichaAnamnese, Long> {

}
