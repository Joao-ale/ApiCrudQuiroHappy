package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.HistoricoClinicoDoencas
import br.com.quiroHappy.ApiCrudQuiroHappy.service.HistoricoClinicoDoencasService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/doencas")
class HistoricoClinicoDoencasController(private val historicoClinicoDoencasService: HistoricoClinicoDoencasService) {

    @GetMapping
    fun getAllHistoricoClinicoDoencas(): ResponseEntity<List<HistoricoClinicoDoencas>> {
        val historicoClinicoDoencas = historicoClinicoDoencasService.getAllHistoricoClinicoDoencas()
        return ResponseEntity.ok(historicoClinicoDoencas)
    }

    @GetMapping("/{id}")
    fun getHistoricoClinicoDoencasById(@PathVariable id: Long): ResponseEntity<HistoricoClinicoDoencas> {
        val historicoClinicoDoencas = historicoClinicoDoencasService.getHistoricoClinicoDoencasById(id)
        return historicoClinicoDoencas?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createHistoricoClinicoDoencas(@RequestBody historicoClinicoDoencas: HistoricoClinicoDoencas): ResponseEntity<HistoricoClinicoDoencas> {
        val createdHistoricoClinicoDoencas = historicoClinicoDoencasService.createHistoricoClinicoDoencas(historicoClinicoDoencas)
        return ResponseEntity(createdHistoricoClinicoDoencas, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateHistoricoClinicoDoencas(@PathVariable id: Long, @RequestBody updatedHistoricoClinicoDoencas: HistoricoClinicoDoencas): ResponseEntity<HistoricoClinicoDoencas> {
        val updated = historicoClinicoDoencasService.updateHistoricoClinicoDoencas(id, updatedHistoricoClinicoDoencas)
        return updated?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteHistoricoClinicoDoencas(@PathVariable id: Long): ResponseEntity<Unit> {
        historicoClinicoDoencasService.deleteHistoricoClinicoDoencas(id)
        return ResponseEntity.noContent().build()
    }
}
