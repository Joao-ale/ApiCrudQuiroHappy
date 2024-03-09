package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import org.springframework.data.jpa.repository.JpaRepository

interface FichaAnamneseRepository: JpaRepository<Anamnese, Long> {

}
