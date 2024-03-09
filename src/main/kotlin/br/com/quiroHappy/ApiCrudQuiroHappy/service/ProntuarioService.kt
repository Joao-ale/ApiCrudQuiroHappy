package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.ProntuarioRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

@Service
class ProntuarioService(
    private val prontuarioRepository: ProntuarioRepository,
    private val prontuarioViewMapper: ProntuarioViewMapper,
    private val prontuarioFormMapper: ProntuarioFormMapper
) {

    fun getAllProntuarios(): List<ProntuarioView> {
        val prontuarios = prontuarioRepository.findAll()
        val prontuariosView : List<ProntuarioView> = ArrayList()
        prontuarios.forEach { prontuario ->
            prontuariosView.plus(prontuarioViewMapper.map(prontuario))
        }


        return prontuariosView
    }

    fun getProntuarioById(id: Long): ProntuarioView {
        val prontuario = prontuarioRepository.findById(id).orElseThrow {
            NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }

        return prontuarioViewMapper.map(prontuario)
    }
    fun getProntuarioByCpf(cpf: Long): ProntuarioView {
        val prontuario = prontuarioRepository.findById(cpf).orElseThrow {
            NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }

        return prontuarioViewMapper.map(prontuario)
    }

    fun createProntuario(form: ProntuarioForm): ProntuarioView {
        val prontuario = prontuarioRepository.save(prontuarioFormMapper.map(form))
        return prontuarioViewMapper.map(prontuario)
    }

    fun updateProntuario(id: Long, form: ProntuarioUpdatedForm): ProntuarioView {
        val existingProntuario = prontuarioRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR101.message.format(id),
                    Errors.QR101.code
                )
            }
        val prontuario = Prontuario(
            id = existingProntuario.id,
            anamnese = existingProntuario.anamnese,
            cpf = existingProntuario.cpf,
            endereco = form.endereco,
            telefone = form.telefone,
            telefoneRespon = form.telefoneRespon,
            quiropraxista = form.quiropraxista,
            ocupacao = form.ocupacao
        )

        val prontuarioAtualizado = prontuarioRepository.save(prontuario)
        return prontuarioViewMapper.map(prontuarioAtualizado)
    }

    fun deleteProntuario(id: Long) {
        if (prontuarioRepository.existsById(id)) {
            prontuarioRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }
    }
}
