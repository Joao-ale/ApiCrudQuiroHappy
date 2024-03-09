package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.PacienteView
import br.com.quiroHappy.ApiCrudQuiroHappy.service.PacienteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pacientes")
class PacienteController(private val pacienteService: PacienteService) {

    @GetMapping
    fun getAllPacientes(): List<PacienteView> {
        return pacienteService.getAllPacientes()
    }

    @GetMapping("/{id}")
    fun getPacienteById(@PathVariable id: Long): PacienteView? {
        return pacienteService.getPacienteById(id)
    }

    @PostMapping
    fun createPaciente(@RequestBody paciente: PacienteForm): PacienteView {
        return pacienteService.createPaciente(paciente)
    }

    @PutMapping("/{id}")
    fun updatePaciente(@PathVariable id: Long, @RequestBody updatedPaciente: PacienteUpdatedForm): PacienteView? {
        return pacienteService.updatePaciente(id, updatedPaciente)
    }

    @DeleteMapping("/{id}")
    fun deletePaciente(@PathVariable id: Long) {
        pacienteService.deletePaciente(id)
    }
}