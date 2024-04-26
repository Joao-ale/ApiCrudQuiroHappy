package br.com.quiroHappy.ApiCrudQuiroHappy.dto

data class MedicoView(
    val nome: String,
    val crm: Long,
    val especialidade: String,
    val prontuarios: List<ProntuarioView>
)
