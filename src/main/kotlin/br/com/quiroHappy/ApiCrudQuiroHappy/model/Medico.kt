package br.com.quiroHappy.ApiCrudQuiroHappy.model

data class medico(
    val id: Long? = null,
    val name: String,
    val crm: String,
    val especialidade: String
)
