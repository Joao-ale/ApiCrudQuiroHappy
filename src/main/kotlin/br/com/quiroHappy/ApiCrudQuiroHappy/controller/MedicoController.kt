package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.MedicoView
import br.com.quiroHappy.ApiCrudQuiroHappy.service.MedicoService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medicos")
class MedicoController(private val medicoService: MedicoService) {

    @GetMapping
    fun getMedicos(): List<MedicoView> {
        val medicos = medicoService.getMedicos()
        return medicos
    }

    @GetMapping("/{id}")
    fun getMedicoById(@PathVariable id: Long): MedicoView {
        val medico = medicoService.getMedicoById(id)
        return medico
    }

    @GetMapping("/{crm}")
    fun getMedicoByCrm(@PathVariable crm: Long): MedicoView {
        val medico = medicoService.getMedicoById(crm)
        return medico
    }

    @PostMapping
    @Transactional
    fun createMedico(@RequestBody medico: MedicoForm): MedicoView {
        return medicoService.createMedico(medico)
    }

    @PutMapping("/{id}")
    @Transactional
    fun updateMedico(@PathVariable id: Long, @RequestBody medico: MedicoUpdatedForm): MedicoView {
        return medicoService.updateMedico(id, medico)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun deleteMedico(@PathVariable id: Long){
        medicoService.deleteMedico(id)
    }
}
