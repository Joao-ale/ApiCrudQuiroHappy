package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import org.springframework.stereotype.Component

@Component
class ProntuarioViewMapper(
    private val medicoViewMapper: MedicoViewMapper
){
    fun map(t: Prontuario, anamneseViewMapper: AnamneseViewMapper): ProntuarioView {
        val prontuarioViewMapper = ProntuarioViewMapper(medicoViewMapper)
        return ProntuarioView(
            id = t.id,
            anamnese = anamneseViewMapper.map(t.anamnese),
            cpf = t.cpf,
            endereco = t.endereco,
            telefone = t.telefone,
            telefoneRespon = t.telefoneRespon,
            medico = medicoViewMapper.map(t.medico, prontuarioViewMapper, anamneseViewMapper ),
            limitacoes = t.limitacoes,
            alergia = t.alergia,
            queixaDores = t.queixaDores

        )
    }

}