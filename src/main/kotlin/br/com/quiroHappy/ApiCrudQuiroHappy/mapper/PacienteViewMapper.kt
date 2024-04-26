package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import org.springframework.stereotype.Component

@Component
class PacienteViewMapper{
    fun map(
        t: Paciente,
        anamneseViewMapper: AnamneseViewMapper,
        prontuarioViewMapper: ProntuarioViewMapper
    ): PacienteView {
        return PacienteView(
            fichaAnamnese = anamneseViewMapper.map(t.anamnese),
            prontuario = prontuarioViewMapper.map(t.prontuario, anamneseViewMapper),
            dataAgendamento = t.dataAgendamento

        )
    }

}