package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import org.springframework.stereotype.Component

@Component
data class ProntuarioForm(
    val idFichaAnamnese: Long,
    val cpf: String,
    val endereco: String,
    val telefone: String? = null,
    val telefoneRespon: String? = null,
    val crmMedico: Long,
    val idOcupacao: Long,
    val limitacoes: MutableSet<String> = mutableSetOf(),
    val alergia: String? = null,
    val queixaDores: String? = null
){

}
