package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Medico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var nome: String,
    var crm: String,
    val especialidade: String,
    val pacientes: List<Paciente>
)
