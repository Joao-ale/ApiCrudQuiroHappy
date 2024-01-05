package br.com.quiroHappy.ApiCrudQuiroHappy.enums

enum class Limitacoes(val id: Long, var nome: String)
{
    COGNITIVA(1, "Cognitiva"),
    LOCOMOCAO(2, "Locomoção"),
    VISAO(3, "Visão"),
    AUDICAO(4, "Audição")
}