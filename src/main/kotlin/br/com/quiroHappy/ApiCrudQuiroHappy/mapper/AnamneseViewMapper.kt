package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import org.springframework.stereotype.Component

@Component
class AnamneseViewMapper(
    private val pacienteViewMapper: PacienteViewMapper,
    private val prontuarioViewMapper: ProntuarioViewMapper
): Mapper<Anamnese, AnamneseView>{
    override fun map(t: Anamnese): AnamneseView {
        val anamneseMapper = AnamneseViewMapper(pacienteViewMapper, prontuarioViewMapper)
        return AnamneseView(
            paciente = pacienteViewMapper.map(t.paciente, anamneseMapper, prontuarioViewMapper),
            segmentos = t.segmentos,
            doencas = t.doencas,
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