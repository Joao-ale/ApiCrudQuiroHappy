package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.time.LocalDate

@Entity
data class Anamnese (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    @JoinColumn(name = "paciente_id")
    val paciente: Paciente,

    var segmentos : List<String>,

    var doencas: List<String>,

    var nomeCompleto: String,

    var dataNasc: LocalDate,

    var sexo: String,

    var ocupacaoProfissional: String? = null,

    var peso: Float,

    var altura: Float,

    var protese: String?,

    var internacaoCirurgias: String?,

    var traumasQuedas: String?,

    var tabagismo: Boolean,

    var etilismo: Boolean,

    var qualidadeSono: String?
)