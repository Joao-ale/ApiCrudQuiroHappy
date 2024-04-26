package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.service.AnamneseService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ficha-anamnese")
class AnamneseController(
    private val anamneseService: AnamneseService
    ) {

    @GetMapping
    fun getAllFichaAnamnese(): List<AnamneseView> {
        return anamneseService.getFichaAnamneses()
    }

    @GetMapping("/{id}")
    fun getFichaAnamneseById(@PathVariable id: Long): AnamneseView? {
        return anamneseService.getFichaAnamneseById(id)
    }

    @PostMapping
    @Transactional
    fun createFichaAnamnese(@RequestBody anamnese: AnamneseForm): AnamneseView {
        return anamneseService.createFichaAnamnese(anamnese)
    }

    @PutMapping("/{id}")
    @Transactional
    fun updateFichaAnamnese(@PathVariable id: Long, @RequestBody updatedAnamnese: AnamneseUpdatedForm): AnamneseView {
        return anamneseService.updateFichaAnamnese(id, updatedAnamnese)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun deleteFichaAnamnese(@PathVariable id: Long) {
        anamneseService.deleteFichaAnamnese(id)
    }
}
