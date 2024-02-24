package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

import br.com.quiroHappy.ApiCrudQuiroHappy.controller.response.ProntuarioView
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario

class ProntuarioViewMapper(
): Mapper<Prontuario, ProntuarioView>{
    override fun map(t: Prontuario): ProntuarioView {
        return ProntuarioView(
            id = t.id,
            fichaAnamnese =  t.fichaAnamnese,
            endereco = t.endereco,
            telefone = t.telefone,
            telefoneRespon = t.telefoneRespon,
            quiropraxista = t.quiropraxista,
            ocupacao = t.ocupacao,
            limitacoes = t.limitacoes,
            alergia = t.alergia,
            queixaDores = t.queixaDores

        )
    }

}