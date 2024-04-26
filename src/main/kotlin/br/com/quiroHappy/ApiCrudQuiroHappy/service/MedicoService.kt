package br.com.quiroHappy.ApiCrudQuiroHappy.service

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoView
import br.com.quiroHappy.ApiCrudQuiroHappy.enums.Errors
import br.com.quiroHappy.ApiCrudQuiroHappy.exception.NotFoundException
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.AnamneseViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.MedicoFormMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.MedicoViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.mapper.ProntuarioViewMapper
import br.com.quiroHappy.ApiCrudQuiroHappy.repository.MedicoRepository
import org.springframework.stereotype.Service

@Service
class MedicoService(
    private val medicoRepository: MedicoRepository,
    private val medicoFormMapper: MedicoFormMapper,
    private val medicoViewMapper: MedicoViewMapper,
    private val prontuarioViewMapper: ProntuarioViewMapper,
    private val prontuarioMapper: ProntuarioMapper,
    private val anamneseViewMapper: AnamneseViewMapper,
    private val anamneseMapper: AnamneseMapper
) {

    fun getMedicos(): List<MedicoView> {
        val medicos =  medicoRepository.findAll()
        val medicosView : List<MedicoView> = ArrayList()
        medicos.forEach { medico ->
            medicosView.plus(
                medicoViewMapper.map(
                    medico,
                    prontuarioViewMapper,
                    anamneseViewMapper
                )
            )
        }

        return medicosView
    }

    fun getMedicoByCrm(crm: Long): MedicoView {
         val medico = medicoRepository.findById(crm)
             .orElseThrow{
                 NotFoundException(
                     Errors.QR201.message.format(crm),
                     Errors.QR201.code
                 )
             }

        return medicoViewMapper.map(medico, prontuarioViewMapper, anamneseViewMapper)
    }

    fun getMedicoById(id: Long): MedicoView {
         val medico = medicoRepository.findById(id)
             .orElseThrow{
                 NotFoundException(
                     Errors.QR201.message.format(id),
                     Errors.QR201.code
                 )
             }

        return medicoViewMapper.map(medico, prontuarioViewMapper, anamneseViewMapper)
    }

    fun createMedico(medico: MedicoForm): MedicoView {
        val medico =  medicoRepository.save(
            medicoFormMapper.map(medico, prontuarioMapper, anamneseMapper)
        )

        return medicoViewMapper.map(medico, prontuarioViewMapper, anamneseViewMapper)
    }

    fun updateMedico(id: Long, medicoUpdated: MedicoUpdatedForm): MedicoView{
        val medico = medicoRepository.findById(id)
            .orElseThrow { NotFoundException(
                Errors.QR201.message.format(id),
                Errors.QR201.code
            ) }


        medico.nome = medicoUpdated.nome
        medico.crm = medicoUpdated.crm
        medico.especialidade= medicoUpdated.especialidade

        val newMedico = medicoRepository.save(medico)

        return medicoViewMapper.map(newMedico, prontuarioViewMapper, anamneseViewMapper)
    }

    fun deleteMedico(id: Long) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id)
        } else {
            throw NotFoundException(
                Errors.QR201.message.format(id),
                Errors.QR201.code
            )
        }
    }
}