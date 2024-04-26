package br.com.quiroHappy.ApiCrudQuiroHappy.dto

data class MedicoForm(
    val nome: String,
    val crm: Long,
    val especialidade: String,
    val prontuarios: List<Long>
)
