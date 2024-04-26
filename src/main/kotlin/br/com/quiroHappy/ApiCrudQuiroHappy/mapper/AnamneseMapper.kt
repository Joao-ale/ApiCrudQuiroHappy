package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import org.springframework.stereotype.Component

@Component
class AnamneseMapper(
    private val pacienteMapper: PacienteMapper,
    private val prontuarioMapper: ProntuarioMapper
): Mapper<AnamneseView, Anamnese>{
    override fun map(t: AnamneseView): Anamnese {
        val anamneseMapper = AnamneseMapper(pacienteMapper, prontuarioMapper)
        return Anamnese(
            paciente = pacienteMapper.map(t.paciente,anamneseMapper, prontuarioMapper ),
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