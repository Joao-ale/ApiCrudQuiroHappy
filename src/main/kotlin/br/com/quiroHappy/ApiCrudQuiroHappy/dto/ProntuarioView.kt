package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import org.springframework.stereotype.Component

@Component
data class ProntuarioView(
    val id: Long?,
    val anamnese: AnamneseView,
    val cpf:String,
    val endereco: String,
    val telefone: String? = null,
    val telefoneRespon: String? = null,
    val medico: MedicoView,
    val limitacoes: MutableSet<String> = mutableSetOf(),
    val alergia: String? = null,
    val queixaDores: String? = null
){

    }
