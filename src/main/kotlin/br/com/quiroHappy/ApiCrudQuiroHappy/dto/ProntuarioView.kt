package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Ocupacao
import org.springframework.stereotype.Component

@Component
data class ProntuarioView(
    val id: Long?,
    val anamnese: AnamneseView,
    val cpf:String,
    val endereco: String,
    val telefone: String? = null,
    val telefoneRespon: String? = null,
    val quiropraxista: String,
    val ocupacao: Ocupacao,
    val limitacoes: MutableSet<Limitacoes> = mutableSetOf(),
    val alergia: String? = null,
    val queixaDores: String? = null
){

    }
