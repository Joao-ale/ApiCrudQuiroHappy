package br.com.quiroHappy.ApiCrudQuiroHappy.model

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Ocupacao
import java.time.LocalDateTime

data class Prontuario(
    val id: Long,
    val dataAbertura: LocalDateTime = LocalDateTime.now(),
    val fichaAnamnese: FichaAnamnese,
    val endereco: String,
    val telefones: MutableList<String>,
    val telefoneRespon: String? = null,
    val quiropraxista: String,
    val ocupacao: Ocupacao,
    val limitacao: MutableList<Long>,
    val alergia: String?,
    val queixaDores: String?
)
