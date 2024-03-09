package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseUpdatedForm
import br.com.quiroHappy.ApiCrudQuiroHappy.dto.AnamneseView
import br.com.quiroHappy.ApiCrudQuiroHappy.service.AnamneseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ficha-anamnese")
class FichaAnamneseController(private val anamneseService: AnamneseService) {

    @GetMapping
    fun getAllFichaAnamnese(): List<AnamneseView> {
        return anamneseService.getFichaAnamneses()
    }

    @GetMapping("/{id}")
    fun getFichaAnamneseById(@PathVariable id: Long): AnamneseView? {
        return anamneseService.getFichaAnamneseById(id)
    }

    @PostMapping
    fun createFichaAnamnese(@RequestBody anamnese: AnamneseForm): AnamneseView {
        return anamneseService.createFichaAnamnese(anamnese)
    }

    @PutMapping("/{id}")
    fun updateFichaAnamnese(@PathVariable id: Long, @RequestBody updatedAnamnese: AnamneseUpdatedForm): AnamneseView {
        return anamneseService.updateFichaAnamnese(id, updatedAnamnese)
    }

    @DeleteMapping("/{id}")
    fun deleteFichaAnamnese(@PathVariable id: Long) {
        anamneseService.deleteFichaAnamnese(id)
    }
}
