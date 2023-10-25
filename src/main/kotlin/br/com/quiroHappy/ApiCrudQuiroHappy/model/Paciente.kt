package br.com.quiroHappy.ApiCrudQuiroHappy.model

import java.time.LocalDateTime

data class Paciente(
    val id: Long? = null,
    val fichaAnamnese: FichaAnamnese? = null,
    val prontuario: Prontuario? = null,
    val dataAgendamento: LocalDateTime? = null
)