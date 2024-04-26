package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import org.springframework.stereotype.Component

@Component
class PacienteMapper{
    fun map(
        t: PacienteView,
        anamneseMapper: AnamneseMapper,
        prontuarioMapper: ProntuarioMapper
    ): Paciente {
        return Paciente(
            anamnese = anamneseMapper.map(t.fichaAnamnese),
            prontuario = prontuarioMapper.map(t.prontuario, anamneseMapper),
            dataAgendamento = t.dataAgendamento

        )
    }

}