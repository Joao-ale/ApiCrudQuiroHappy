package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoView
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico
import org.springframework.stereotype.Component

@Component
class MedicoViewMapper{
    fun map(t: Medico, prontuarioViewMapper: ProntuarioViewMapper, anamneseViewMapper: AnamneseViewMapper): MedicoView {
        val prontuarios = t.prontuarios
        val prontuarioTransform: List<ProntuarioView> = ArrayList()
        prontuarios.forEach{prontuario ->
            prontuarioTransform.plus(
                prontuarioViewMapper.map(
                    prontuario,
                    anamneseViewMapper
                )
            )
        }
        return MedicoView(
            nome = t.nome,
            crm = t.crm,
            especialidade = t.especialidade,
            prontuarios = prontuarioTransform
        )
    }

}