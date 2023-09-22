package br.com.quiroHappy.ApiCrudQuiroHappy.model

import java.time.LocalDateTime
import java.util.Date

data class FichaAnamnese (
    val id: Long? = null,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val nome:String,
    val dataNasc: Date,
    val sexo: String,
    val ocupProfissional: String? = null,
    val Responsavel: String? = null,
    val peso: Long,
    val altura: Long,
    val protese: Boolean,
    val tipoProtese: String? = null,
    val internCirurg:String? = null,
    val traumasQuedas: String? = null,
    val tabagismo: Boolean,
    val etilismo: Boolean,
    val histDoencas: List<Long>,
    val exames: String?,
    val historicoAtual: String?,
    val tecObs: String?,
    val segmentos: List<Segmentos>
)