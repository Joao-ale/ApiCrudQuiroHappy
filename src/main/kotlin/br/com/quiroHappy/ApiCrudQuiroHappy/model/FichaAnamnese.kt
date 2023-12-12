package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
data class FichaAnamnese (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    val paciente: Paciente, // Alterado para a classe Paciente
    var nomeCompleto: String,
    var dataNasc: LocalDate,
    var sexo: String,
    var ocupacaoProfissional: String? = null,
    var atividadeFisica: Boolean,
    var peso: Float,
    var altura: Float,
    var protese: Boolean,
    var internacaoCirurgias: Boolean,
    var traumasQuedas: Boolean,
    var tabagismo: Boolean,
    var etilismo: Boolean,
    var qualidadeSono: String?
)
