package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico
import org.springframework.data.jpa.repository.JpaRepository

interface MedicoRepository: JpaRepository<Medico, Long> {

}
