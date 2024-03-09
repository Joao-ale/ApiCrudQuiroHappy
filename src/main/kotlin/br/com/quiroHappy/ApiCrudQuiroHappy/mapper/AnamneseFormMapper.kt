package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.service.PacienteService

class AnamneseFormMapper(
    private val pacienteService: PacienteService,
): Mapper<AnamneseForm,Anamnese>{
    override fun map(t: AnamneseForm): Anamnese {
        return Anamnese(
            paciente = pacienteService.getPacienteById(t.idPaciente),
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