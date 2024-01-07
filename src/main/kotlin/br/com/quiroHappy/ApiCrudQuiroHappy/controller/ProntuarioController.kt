package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario
import br.com.quiroHappy.ApiCrudQuiroHappy.service.ProntuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prontuarios")
class ProntuarioController(private val prontuarioService: ProntuarioService) {

    @GetMapping
    fun getAllProntuarios(): ResponseEntity<List<Prontuario>> {
        val prontuarios = prontuarioService.getAllProntuarios()
        return ResponseEntity(prontuarios, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getProntuarioById(@PathVariable id: Long): ResponseEntity<Prontuario> {
        val prontuario = prontuarioService.getProntuarioById(id)
        return ResponseEntity(prontuario, HttpStatus.OK)
    }

    @PostMapping
    fun createProntuario(@RequestBody prontuario: Prontuario): ResponseEntity<Prontuario> {
        val createdProntuario = prontuarioService.createProntuario(prontuario)
        return ResponseEntity(createdProntuario, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateProntuario(
        @PathVariable id: Long,
        @RequestBody updatedProntuario: Prontuario
    ): ResponseEntity<Prontuario> {
        val updated = prontuarioService.updateProntuario(id, updatedProntuario)
        return ResponseEntity(updated, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteProntuario(@PathVariable id: Long): ResponseEntity<Unit> {
        prontuarioService.deleteProntuario(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
