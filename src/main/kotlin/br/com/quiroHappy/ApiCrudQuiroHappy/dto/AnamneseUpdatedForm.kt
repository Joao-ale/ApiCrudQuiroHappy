package br.com.quiroHappy.ApiCrudQuiroHappy.dto

import org.springframework.stereotype.Component

@Component
class AnamneseUpdatedForm (
        val nomeCompleto: String,
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
