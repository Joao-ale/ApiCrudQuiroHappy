package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import org.springframework.stereotype.Component

@Component
class ProntuarioMapper(
    private val medicoMappper: MedicoMapper
){
    fun map(
        t: ProntuarioView,
        anamneseMapper: AnamneseMapper
    ): Prontuario {
        val prontuarioMapper = ProntuarioMapper(medicoMappper)
        return Prontuario(
            anamnese =  anamneseMapper.map(t.anamnese),
            cpf = t.cpf,
            endereco = t.endereco,
            telefone = t.telefone,
            telefoneRespon = t.telefoneRespon,
            medico = medicoMappper.map(t.medico,prontuarioMapper, anamneseMapper),
            limitacoes = t.limitacoes,
            alergia = t.alergia,
            queixaDores = t.queixaDores
        )
    }

}