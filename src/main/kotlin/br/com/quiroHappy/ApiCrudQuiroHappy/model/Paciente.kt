package br.com.quiroHappy.ApiCrudQuiroHappy.model

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioView
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDateTime

@Entity
data class Paciente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToMany
    var fichaAnamnese: AnamneseView,
    @OneToOne
    var prontuario: ProntuarioView? = null,
    var dataAgendamento: LocalDateTime? = null
)