package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import java.time.LocalDateTime

data class PacienteUpdatedForm(
    val fichaAnamnese: AnamneseView,
    val prontuario: ProntuarioView,
    val dataAgendamento: LocalDateTime?
) {

}
