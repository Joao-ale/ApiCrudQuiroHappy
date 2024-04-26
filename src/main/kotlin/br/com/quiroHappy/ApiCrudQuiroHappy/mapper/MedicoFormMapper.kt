package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.service.ProntuarioService
import org.springframework.stereotype.Component

@Component
class MedicoFormMapper(
    private val prontuarioService: ProntuarioService
){
    fun map(
        t: MedicoForm,
        prontuarioMapper: ProntuarioMapper,
        anamneseMapper: AnamneseMapper
    ): Medico {
        val prontuarios = prontuarioService.getProntuariosByCrm(t.crm)
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