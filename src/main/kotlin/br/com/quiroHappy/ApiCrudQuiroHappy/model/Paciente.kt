package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.time.LocalDateTime

@Entity
data class Paciente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @JoinColumn(name= "anamnese_id")
    var anamnese: Anamnese,

    @OneToOne
    @JoinColumn(name = "prontuario_id")
    var prontuario: Prontuario,

    @Column
    var dataAgendamento: LocalDateTime? = null
)