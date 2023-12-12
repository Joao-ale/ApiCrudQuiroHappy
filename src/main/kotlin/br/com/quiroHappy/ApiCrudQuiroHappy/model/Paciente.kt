package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
data class Paciente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToMany(mappedBy = "paciente")
    var fichasAnamnese: List<FichaAnamnese> = mutableListOf(),
    var prontuario: Prontuario? = null,
    var dataAgendamento: LocalDateTime? = null
)