package br.com.quiroHappy.ApiCrudQuiroHappy.model

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate

@Entity
data class Anamnese (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    val paciente: PacienteView?,

    @Column(nullable = false)
    var nomeCompleto: String,

    @Column(nullable = false)
    var dataNasc: LocalDate,

    @Column(nullable = false)
    var sexo: String,

    @Column
    var ocupacaoProfissional: String? = null,

    @Column
    @NotEmpty
    var peso: Float,

    @Column
    @NotEmpty
    var altura: Float,

    @Column
    var protese: String?,

    @Column
    var internacaoCirurgias: String?,

    @Column
    @NotEmpty
    var traumasQuedas: String?,

    @Column
    @NotEmpty
    var tabagismo: Boolean,

    @Column
    @NotEmpty
    var etilismo: Boolean,

    @Column
    var qualidadeSono: String?
)
