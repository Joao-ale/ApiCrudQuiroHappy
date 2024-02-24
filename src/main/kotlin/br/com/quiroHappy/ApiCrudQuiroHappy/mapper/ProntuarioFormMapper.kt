package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.controller.response.ProntuarioForm
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.service.FichaAnamneseService
import br.com.quiroHappy.ApiCrudQuiroHappy.service.OcupacaoService

class ProntuarioFormMapper(
    private val fichaAnamneseService: FichaAnamneseService,
    private val ocupacaoService: OcupacaoService
): Mapper<ProntuarioForm,Prontuario>{
    override fun map(t: ProntuarioForm): Prontuario {
        return Prontuario(
            fichaAnamnese =  fichaAnamneseService.getFichaAnamneseById(t.idFichaAnamnese),
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