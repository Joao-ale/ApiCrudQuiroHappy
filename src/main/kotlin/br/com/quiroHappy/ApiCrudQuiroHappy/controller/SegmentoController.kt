package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.Segmentos
import br.com.quiroHappy.ApiCrudQuiroHappy.service.SegmentoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/segmentos")
class SegmentoController(private val segmentoService: SegmentoService) {

    @GetMapping
    fun getAllSegmentos(): ResponseEntity<List<Segmentos>> {
        val segmentos = segmentoService.getSegmentos()
        return ResponseEntity(segmentos, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getSegmentosById(@PathVariable id: Long): ResponseEntity<Segmentos> {
        val segmentos = segmentoService.getSegmentosById(id)
        return ResponseEntity(segmentos, HttpStatus.OK)
    }

    @PostMapping
    fun createSegmentos(@RequestBody segmentos: Segmentos): ResponseEntity<Segmentos> {
        val createdSegmentos = segmentoService.createSegmentos(segmentos)
        return ResponseEntity(createdSegmentos, HttpStatus.CREATED)
    }
}
