package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente
import br.com.quiroHappy.ApiCrudQuiroHappy.service.PacienteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pacientes")
class PacienteController(private val pacienteService: PacienteService) {

    @GetMapping
    fun getAllPacientes(): List<Paciente> {
        return pacienteService.getAllPacientes()
    }

    @GetMapping("/{id}")
    fun getPacienteById(@PathVariable id: Long): Paciente? {
        return pacienteService.getPacienteById(id)
    }

    @PostMapping
    fun createPaciente(@RequestBody paciente: Paciente): Paciente {
        return pacienteService.createPaciente(paciente)
    }

    @PutMapping("/{id}")
    fun updatePaciente(@PathVariable id: Long, @RequestBody updatedPaciente: Paciente): Paciente? {
        return pacienteService.updatePaciente(id, updatedPaciente)
    }

    @DeleteMapping("/{id}")
    fun deletePaciente(@PathVariable id: Long) {
        pacienteService.deletePaciente(id)
    }
}