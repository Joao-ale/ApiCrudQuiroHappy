package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.ProntuarioView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.MedicoMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.ProntuarioRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

@Service
class ProntuarioService(
    private val prontuarioRepository: ProntuarioRepository,
    private val prontuarioViewMapper: ProntuarioViewMapper,
    private val prontuarioFormMapper: ProntuarioFormMapper,
    private val medicoMapper: MedicoMapper,
    private val prontuarioMapper: ProntuarioMapper,
    private val anamneseMapper: AnamneseMapper,
    private val anamneseViewMapper: AnamneseViewMapper
) {

    fun getAllProntuarios(): List<ProntuarioView> {
        val prontuarios = prontuarioRepository.findAll()
        val prontuariosView : List<ProntuarioView> = ArrayList()
        prontuarios.forEach { prontuario ->
            prontuariosView.plus(
                prontuarioViewMapper.map(
                    prontuario,
                    anamneseViewMapper
                )
            )
        }


        return prontuariosView
    }

    fun getProntuariosByCrm(crm: Long): List<ProntuarioView>{
        val prontuarios = prontuarioRepository.findByCrm(crm)
        val prontuariosView : List<ProntuarioView> = ArrayList()
        prontuarios.forEach { prontuario ->
            prontuariosView.plus(
                prontuarioViewMapper.map(
                    prontuario,
                    anamneseViewMapper
                )
            )
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

        return prontuarioViewMapper.map(prontuario, anamneseViewMapper)
    }
    fun getProntuarioByCpf(cpf: Long): ProntuarioView {
        val prontuario = prontuarioRepository.findById(cpf).orElseThrow {
            NotFoundException(
                Errors.QR101.message.format(id),
                Errors.QR101.code
            )
        }

        return prontuarioViewMapper.map(prontuario, anamneseViewMapper)
    }

    fun createProntuario(form: ProntuarioForm): ProntuarioView {
        val prontuario = prontuarioRepository.save(
            prontuarioFormMapper.map(
                form,
                anamneseMapper
            )
        )
        return prontuarioViewMapper.map(prontuario, anamneseViewMapper)
    }

    fun updateProntuario(id: Long, updatedProntuario: ProntuarioUpdatedForm): ProntuarioView {
        val prontuario = prontuarioRepository.findById(id)
            .orElseThrow {
                NotFoundException(
                    Errors.QR101.message.format(id),
                    Errors.QR101.code
                )
            }

        prontuario.endereco = updatedProntuario.endereco
        prontuario.telefone = updatedProntuario.telefone
        prontuario.telefoneRespon = updatedProntuario.telefoneRespon
        prontuario.medico = medicoMapper.map(
            updatedProntuario.crmMedico,
            prontuarioMapper,
            anamneseMapper
        )
        prontuario.limitacoes = updatedProntuario.limitacoes
        prontuario.queixaDores = updatedProntuario.queixaDores

        val newProntuario = prontuarioRepository.save(prontuario)
        return prontuarioViewMapper.map(newProntuario, anamneseViewMapper)
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
