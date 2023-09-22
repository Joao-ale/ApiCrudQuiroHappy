package br.com.quiroHappy.ApiCrudQuiroHappy.model

data class Limitacoes(
    val id: Long,
    val nome: String
) {
    val limitacoesPredef = listOf<Limitacoes>(
        Limitacoes(1,"Cognitiva"),
        Limitacoes(2, "Locomoção"),
        Limitacoes(3,"Visao"),
        Limitacoes(4, "Audição")
    )
}