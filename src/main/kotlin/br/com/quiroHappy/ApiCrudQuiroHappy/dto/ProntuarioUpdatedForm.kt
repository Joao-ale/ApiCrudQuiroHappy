package br.com.quiroHappy.ApiCrudQuiroHappy.dto



data class ProntuarioUpdatedForm(
    val endereco: String,
    val telefone: String? = null,
    val telefoneRespon: String? = null,
    val crmMedico: MedicoView,
    val limitacoes: MutableSet<String> = mutableSetOf(),
    val queixaDores: String? = null
) {

}