package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Segmentos (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?   = null,
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    val pacienteId: Paciente,
    val c1: String? = null,
    val c2: String? = null,
    val c3: String? = null,
    val c4: String? = null,
    val c5: String? = null,
    val c6: String? = null,
    val c7: String? = null,
    val t1: String? = null,
    val t2: String? = null,
    val t3: String? = null,
    val t4: String? = null,
    val t5: String? = null,
    val t6: String? = null,
    val t7: String? = null,
    val t8: String? = null,
    val t9: String? = null,
    val t10: String? = null,
    val t11: String? = null,
    val t12: String? = null,
    val l1: String? = null,
    val l2: String? = null,
    val l3: String? = null,
    val l4: String? = null,
    val l5: String? = null,
    val pelve: String? = null,
    val sacro: String? = null,
)
