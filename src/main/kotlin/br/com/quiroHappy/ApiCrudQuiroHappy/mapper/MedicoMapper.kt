package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import org.springframework.stereotype.Component

@Component
class MedicoMapper{
    fun map(t: MedicoView, prontuarioMapper: ProntuarioMapper, anamneseMapper: AnamneseMapper): Medico {
        val prontuarios = t.prontuarios
        val prontuarioTransform: List<Prontuario> = ArrayList()
        prontuarios.forEach{prontuario ->
            prontuarioTransform.plus(
                prontuarioMapper.map(
                    prontuario,
                    anamneseMapper
                )
            )
        }

        return Medico(
            nome = t.nome,
            crm = t.crm,
            especialidade = t.especialidade,
            prontuarios = prontuarioTransform
        )
    }
}