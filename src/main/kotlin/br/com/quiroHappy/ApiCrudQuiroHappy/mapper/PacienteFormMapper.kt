package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import br.com.quiroHappy.ApiCrudQuiroHappy.service.AnamneseService
import br.com.quiroHappy.ApiCrudQuiroHappy.service.ProntuarioService
import org.springframework.stereotype.Component

@Component
class PacienteFormMapper(
    private val anamneseService: AnamneseService,
    private val prontuarioService: ProntuarioService,
){
    fun map(
        t:PacienteForm,
        anamneseMapper: AnamneseMapper,
        prontuarioMapper: ProntuarioMapper
    ): Paciente {
        return Paciente(
            anamnese = anamneseMapper.map(anamneseService.getFichaAnamneseById(t.fichaAnamnese)),
            prontuario = prontuarioMapper.map(prontuarioService.getProntuarioById(t.prontuario), anamneseMapper),
            dataAgendamento = t.dataAgendamento

        )
    }

}