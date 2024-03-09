package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes
import org.springframework.stereotype.Component

@Component
data class ProntuarioForm(
    val idFichaAnamnese: Long,
    val cpf: String,
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
