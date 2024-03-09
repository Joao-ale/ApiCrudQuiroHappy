package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.service.AnamneseService
import br.com.quiroHappy.ApiCrudQuiroHappy.service.OcupacaoService

class ProntuarioFormMapper(
    private val anamneseService: AnamneseService,
    private val ocupacaoService: OcupacaoService
): Mapper<ProntuarioForm,Prontuario>{
    override fun map(t: ProntuarioForm): Prontuario {
        return Prontuario(
            anamnese =  anamneseService.getFichaAnamneseById(t.idFichaAnamnese),
            cpf = t.cpf,
            endereco = t.endereco,
            telefone = t.telefone,
            telefoneRespon = t.telefoneRespon,
            quiropraxista = t.quiropraxista,
            ocupacao = ocupacaoService.getOcupacaoById(t.idOcupacao),
            limitacoes = t.limitacoes,
            alergia = t.alergia,
            queixaDores = t.queixaDores
        )
    }

}