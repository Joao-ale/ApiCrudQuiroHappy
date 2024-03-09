package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import java.time.LocalDateTime

data class PacienteForm(
    val fichaAnamnese: Long,
    val prontuario: Long,
    val dataAgendamento: LocalDateTime?
) {

}
