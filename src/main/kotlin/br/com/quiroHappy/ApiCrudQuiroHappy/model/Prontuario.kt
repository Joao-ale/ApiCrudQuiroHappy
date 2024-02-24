package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne

@Entity
data class Prontuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "anamnese_id")
    var fichaAnamnese: FichaAnamnese,

    @Column(nullable = false)
    var endereco: String,

    var telefone: String? = null,

    var telefoneRespon: String? = null,

    @Column(nullable = false)
    var quiropraxista: String,

    var ocupacao: Ocupacao,

    @ManyToMany
    @JoinTable(
        name = "prontuario_limitacoes",
        joinColumns = [JoinColumn(name = "prontuario_id")],
        inverseJoinColumns = [JoinColumn(name = "limitacao_id")]
    )
    var limitacoes: MutableSet<Limitacoes> = mutableSetOf(),

    var alergia: String? = null,

    var queixaDores: String? = null
)
