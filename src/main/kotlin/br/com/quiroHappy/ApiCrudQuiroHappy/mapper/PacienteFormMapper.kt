package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import br.com.quiroHappy.ApiCrudQuiroHappy.service.AnamneseService
import br.com.quiroHappy.ApiCrudQuiroHappy.service.ProntuarioService

class PacienteFormMapper(
    private val anamneseService: AnamneseService,
    private val prontuarioService: ProntuarioService
): Mapper<PacienteForm, Paciente>{
    override fun map(t:PacienteForm ): Paciente {
        return Paciente(
            fichaAnamnese = anamneseService.getFichaAnamneseById(t.fichaAnamnese),
            prontuario = prontuarioService.getProntuarioById(t.prontuario),
            dataAgendamento = t.dataAgendamento

        )
    }

}