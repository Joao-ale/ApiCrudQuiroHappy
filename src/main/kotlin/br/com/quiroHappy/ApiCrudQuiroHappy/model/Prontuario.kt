package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Prontuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "anamnese_id")
    var anamnese: Anamnese,

    @Column
    var cpf: String,

    @Column(nullable = false)
    var endereco: String,

    @Column
    var telefone: String? = null,

    @Column
    var telefoneRespon: String? = null,

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    var medico: Medico,

    var limitacoes: MutableSet<String> = mutableSetOf(),

    @Column
    var alergia: String? = null,

    @Column
    var queixaDores: String? = null
)