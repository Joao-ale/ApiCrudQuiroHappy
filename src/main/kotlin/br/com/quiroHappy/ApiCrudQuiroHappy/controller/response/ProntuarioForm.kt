package br.com.quiroHappy.ApiCrudQuiroHappy.controller.response

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes


data class ProntuarioForm(
    val idFichaAnamnese: Long,
    val endereco: String,
    val telefone: String? = null,
    val telefoneRespon: String? = null,
    val quiropraxista: String,
    val idOcupacao: Long,
    val limitacoes: MutableSet<Limitacoes> = mutableSetOf(),
    val alergia: String? = null,
    val queixaDores: String? = null
){

}
