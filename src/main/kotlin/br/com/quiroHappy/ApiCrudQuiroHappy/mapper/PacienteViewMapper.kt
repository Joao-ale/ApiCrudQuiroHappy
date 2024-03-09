package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente

class PacienteViewMapper(): Mapper<Paciente, PacienteView>{
    override fun map(t: Paciente): PacienteView {
        return PacienteView(
            fichaAnamnese = t.fichaAnamnese,
            prontuario = t.prontuario,
            dataAgendmento = t.dataAgendamento

        )
    }

}