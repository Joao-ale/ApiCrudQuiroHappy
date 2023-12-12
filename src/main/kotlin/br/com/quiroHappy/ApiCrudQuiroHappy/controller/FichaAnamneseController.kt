package br.com.quiroHappy.ApiCrudQuiroHappy.controller

import br.com.quiroHappy.ApiCrudQuiroHappy.model.FichaAnamnese
import br.com.quiroHappy.ApiCrudQuiroHappy.service.FichaAnamneseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ficha-anamnese")
class FichaAnamneseController(private val fichaAnamneseService: FichaAnamneseService) {

    @GetMapping
    fun getAllFichaAnamnese(): List<FichaAnamnese> {
        return fichaAnamneseService.getFichaAnamneses()
    }

    @GetMapping("/{id}")
    fun getFichaAnamneseById(@PathVariable id: Long): FichaAnamnese? {
        return fichaAnamneseService.getFichaAnamneseById(id)
    }

    @PostMapping
    fun createFichaAnamnese(@RequestBody fichaAnamnese: FichaAnamnese): FichaAnamnese {
        return fichaAnamneseService.createFichaAnamnese(fichaAnamnese)
    }

    @PutMapping("/{id}")
    fun updateFichaAnamnese(@PathVariable id: Long, @RequestBody updatedFichaAnamnese: FichaAnamnese): FichaAnamnese {
        return fichaAnamneseService.updateFichaAnamnese(id, updatedFichaAnamnese)
    }

    @DeleteMapping("/{id}")
    fun deleteFichaAnamnese(@PathVariable id: Long) {
        fichaAnamneseService.deleteFichaAnamnese(id)
    }
}
