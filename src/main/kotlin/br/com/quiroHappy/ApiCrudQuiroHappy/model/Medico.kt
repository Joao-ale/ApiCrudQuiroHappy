package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Medico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var nome: String,

    @Column
    var crm: Long,

    @Column
    var especialidade: String,

    @OneToMany(mappedBy = "medico")
    val prontuarios: List<Prontuario>
)