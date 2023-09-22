package br.com.quiroHappy.ApiCrudQuiroHappy.repository

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import org.springframework.data.jpa.repository.JpaRepository

interface ProntuarioRepository: JpaRepository<Prontuario, Long> {
}