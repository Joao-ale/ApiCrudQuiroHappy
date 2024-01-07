package br.com.quiroHappy.ApiCrudQuiroHappy.model

import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Ocupacao
import jakarta.persistence.*

@Entity
data class Prontuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "anamnese_id")
    var fichaAnamnese: FichaAnamnese? = null,

    @Column(nullable = false)
    var endereco: String,

    var telefone: String? = null,

    var telefoneRespon: String? = null,

    @Column(nullable = false)
    var quiropraxista: String,

    @Enumerated(EnumType.STRING)
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
