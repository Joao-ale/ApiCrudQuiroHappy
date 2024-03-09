package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.service.PacienteService

class AnamneseViewMapper(
    private val pacienteService: PacienteService,
): Mapper<Anamnese, AnamneseView>{
    override fun map(t: Anamnese): AnamneseView {
        return AnamneseView(
            paciente = t.paciente,
            nomeCompleto = t.nomeCompleto,
            dataNasc = t.dataNasc,
            sexo = t.sexo,
            ocupacaoProfissional = t.ocupacaoProfissional,
            peso = t.peso,
            altura = t.altura,
            protese = t.protese,
            internacaoCirurgias = t.internacaoCirurgias,
            traumasQuedas = t.traumasQuedas,
            tabagismo = t.tabagismo,
            etilismo = t.etilismo,
            qualidadeSono = t.qualidadeSono

        )
    }

}