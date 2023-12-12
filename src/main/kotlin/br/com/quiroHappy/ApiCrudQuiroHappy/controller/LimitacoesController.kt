package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes
import br.com.quiroHappy.ApiCrudQuiroHappy.service.LimitacoesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/limitacoes")
class LimitacoesController(private val limitacoesService: LimitacoesService) {

    @GetMapping
    fun getAllLimitacoes(): ResponseEntity<List<Limitacoes>> {
        val limitacoes = limitacoesService.getLimitacoes()
        return ResponseEntity.ok(limitacoes)
    }

    @GetMapping("/{id}")
    fun getLimitacaoById(@PathVariable id: Long): ResponseEntity<Limitacoes> {
        val limitacao = limitacoesService.getLimitacaoById(id)
        return limitacao?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createLimitacoes(@RequestBody limitacoes: Limitacoes): ResponseEntity<Limitacoes> {
        val createdLimitacoes = limitacoesService.createLimitacoes(limitacoes)
        return ResponseEntity(createdLimitacoes, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateLimitacoes(@PathVariable id: Long, @RequestBody updatedLimitacoes: Limitacoes): ResponseEntity<Limitacoes> {
        val updated = limitacoesService.updateLimitacoes(id, updatedLimitacoes)
        return updated?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteLimitacao(@PathVariable id: Long): ResponseEntity<Unit> {
        limitacoesService.deleteLimitacao(id)
        return ResponseEntity.noContent().build()
    }
}
