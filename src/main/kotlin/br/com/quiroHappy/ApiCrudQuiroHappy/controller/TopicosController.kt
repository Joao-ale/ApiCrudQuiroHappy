package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Topicos
import br.com.quiroHappy.ApiCrudQuiroHappy.service.TopicosService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicosController(private val topicosService: TopicosService) {

    @GetMapping
    fun getAllTopicos(): ResponseEntity<List<Topicos>> {
        val topicos = topicosService.getAllTopicos()
        return ResponseEntity(topicos, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getTopicosById(@PathVariable id: Long): ResponseEntity<Topicos> {
        val topicos = topicosService.getTopicosById(id)
        return ResponseEntity(topicos, HttpStatus.OK)
    }

    @PostMapping
    fun createTopicos(@RequestBody topicos: Topicos): ResponseEntity<Topicos> {
        val createdTopicos = topicosService.createTopicos(topicos)
        return ResponseEntity(createdTopicos, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateTopicos(
        @PathVariable id: Long,
        @RequestBody updatedTopicos: Topicos
    ): ResponseEntity<Topicos> {
        val updated = topicosService.updateTopicos(id, updatedTopicos)
        return if (updated != null) {
            ResponseEntity(updated, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTopicos(@PathVariable id: Long): ResponseEntity<Unit> {
        topicosService.deleteTopicos(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
