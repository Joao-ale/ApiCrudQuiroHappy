package br.com.quiroHappy.ApiCrudQuiroHappy.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class HistoricoClinicoDoencas (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    var pacienteId: Paciente, // Relacionamento com Paciente
    var hipertensao: Boolean,
    var diabetes: Boolean,
    var dislipidemias: Boolean,
    var renal: Boolean,
    var hepatica: Boolean,
    var cardiovascular: Boolean,
    var osteoporose: Boolean,
    var cancer: Boolean,
    var respiratoria: Boolean,
    var genitoUrinaria: Boolean,
    var gastrointestinal: Boolean,
    var endocrina: Boolean,
    var pele: Boolean,
    var osteomioarticular: Boolean,
    var neurologica: Boolean
)
