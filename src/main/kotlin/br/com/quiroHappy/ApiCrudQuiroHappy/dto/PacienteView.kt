package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import java.time.LocalDateTime

data class PacienteView(
    val fichaAnamnese: AnamneseView,
    val prontuario: ProntuarioView?,
    val dataAgendmento: LocalDateTime?
) {

}
