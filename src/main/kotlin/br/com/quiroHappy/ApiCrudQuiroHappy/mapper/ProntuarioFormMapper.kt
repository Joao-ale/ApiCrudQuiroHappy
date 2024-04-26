package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.service.AnamneseService
import br.com.quiroHappy.ApiCrudQuiroHappy.service.MedicoService
import org.springframework.stereotype.Component

@Component
class ProntuarioFormMapper(
    private val anamneseService: AnamneseService,
    private val medicoService: MedicoService,
    private val medicoMapper: MedicoMapper
){
    fun map(t: ProntuarioForm, anamneseMapper: AnamneseMapper): Prontuario {
        val prontuarioMapper = ProntuarioMapper(medicoMapper)
        return Prontuario(
            anamnese =  anamneseMapper.map(anamneseService.getFichaAnamneseById(t.idFichaAnamnese)),
            cpf = t.cpf,
            endereco = t.endereco,
            telefone = t.telefone,
            telefoneRespon = t.telefoneRespon,
            medico = medicoMapper.map(medicoService.getMedicoByCrm(t.crmMedico), prontuarioMapper, anamneseMapper ),
            limitacoes = t.limitacoes,
            alergia = t.alergia,
            queixaDores = t.queixaDores
        )
    }

}