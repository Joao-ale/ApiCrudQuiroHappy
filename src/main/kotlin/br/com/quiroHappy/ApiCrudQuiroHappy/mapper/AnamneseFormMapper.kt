package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Anamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.service.PacienteService
import org.springframework.stereotype.Component

@Component
class AnamneseFormMapper(
    private val pacienteService: PacienteService,
    private val pacienteMapper: PacienteMapper,
    private val prontuarioMapper: ProntuarioMapper
): Mapper<AnamneseForm, Anamnese>{
    override fun map(t: AnamneseForm): Anamnese {
        val anamneseMapper = AnamneseMapper(pacienteMapper, prontuarioMapper)
        return Anamnese(
            paciente = pacienteMapper.map(
                pacienteService.getPacienteById(
                    t.idPaciente
                ),
                anamneseMapper,
                prontuarioMapper
            ),
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