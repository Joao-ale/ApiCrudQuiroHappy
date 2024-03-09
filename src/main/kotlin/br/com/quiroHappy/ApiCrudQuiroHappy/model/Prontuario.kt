package br.com.quiroHappy.ApiCrudQuiroHappy.model

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
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
    var anamnese: AnamneseView,

    @Column
    var cpf: String,

    @Column(nullable = false)
    var endereco: String,

    @Column
    var telefone: String? = null,

    @Column
    var telefoneRespon: String? = null,

    @Column(nullable = false)
    var quiropraxista: String,

    @ManyToOne
    @JoinTable(name = "ocupacao_id")
    var ocupacao: Ocupacao,

    @ManyToMany
    @JoinTable(
        name = "prontuario_limitacoes",
        joinColumns = [JoinColumn(name = "prontuario_id")],
        inverseJoinColumns = [JoinColumn(name = "limitacao_id")]
    )
    var limitacoes: MutableSet<Limitacoes> = mutableSetOf(),

    @Column
    var alergia: String? = null,

    @Column
    var queixaDores: String? = null
)
