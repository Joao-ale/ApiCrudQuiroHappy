package br.com.quiroHappy.ApiCrudQuiroHappy.controller.response

import br.com.quiroHappy.ApiCrudQuiroHappy.model.FichaAnamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Ocupacao

data class ProntuarioView(
    val id: Long?,
    val fichaAnamnese: FichaAnamnese,
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
