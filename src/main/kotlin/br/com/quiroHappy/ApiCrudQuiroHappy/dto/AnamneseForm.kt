package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
data class AnamneseForm(
    val idPaciente: Long,
    val nomeCompleto: String,
    val dataNasc: LocalDate,
    val sexo: String,
    val ocupacaoProfissional: String?,
    val peso: Float,
    val altura: Float,
    val protese: String?,
    val internacaoCirurgias: String?,
    val traumasQuedas: String?,
    val tabagismo: Boolean,
    val etilismo: Boolean,
    val qualidadeSono: String?
) {
}