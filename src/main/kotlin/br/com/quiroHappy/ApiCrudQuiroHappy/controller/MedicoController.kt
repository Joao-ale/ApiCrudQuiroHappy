package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico
import br.com.quiroHappy.ApiCrudQuiroHappy.service.MedicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medicos")
class MedicoController(private val medicoService: MedicoService) {

    @GetMapping
    fun getMedicos(): ResponseEntity<List<Medico>> {
        val medicos = medicoService.getMedicos()
        return ResponseEntity(medicos, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getMedicoById(@PathVariable id: Long): ResponseEntity<Medico?> {
        val medico = medicoService.getMedicoById(id)
        return if (medico != null) {
            ResponseEntity(medico, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping
    fun createMedico(@RequestBody medico: Medico): ResponseEntity<Medico> {
        val createdMedico = medicoService.createMedico(medico)
        return ResponseEntity(createdMedico, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateMedico(@PathVariable id: Long, @RequestBody updatedMedico: Medico): ResponseEntity<Medico?> {
        val updated = medicoService.updateMedico(id, updatedMedico)
        return if (updated != null) {
            ResponseEntity(updated, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteMedico(@PathVariable id: Long): ResponseEntity<Unit> {
        medicoService.deleteMedico(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
