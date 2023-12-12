package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import org.springframework.data.jpa.repository.JpaRepository

interface PacienteRepository: JpaRepository<Paciente, Long> {

}
