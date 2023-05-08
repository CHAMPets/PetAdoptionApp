package com.champets.fureverhome.pet;

import com.champets.fureverhome.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public String listPets(Model model) {
        List<Pet> pets = petService.findAllPets();
        model.addAttribute("pets", pets);
        return "pet-list";
    }

    @GetMapping("/pets/{petId}")
    public String petDetail(@PathVariable("petId") Long petId, Model model) {
        PetDto petDto = petService.findPetById(petId);
        model.addAttribute("pet", petDto);
        return "pet-detail";
    }

    @GetMapping("/pets/new")
    public String createPetForm(Model model) {
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "pet-create";
    }

    @PostMapping("/pets/new")
    public String savePet(@ModelAttribute("pet") Pet pet) {
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pets/{petId}/delete")
    public String deletePet(@PathVariable("petId") Long petId) {
        petService.delete(petId);
        return "redirect:/pets";
    }

    @GetMapping("/pets/search")
    public String searchPet(@RequestParam(value = "query") String query, Model model) {
        List<PetDto> pets = petService.searchPets(query);
        model.addAttribute("pets", pets);
        return "pet-list";
    }

    @GetMapping("/pets/{petId}/edit")
    public String editPetForm(@PathVariable("petId") Long petId, Model model) {
        PetDto petDto = petService.findPetById(petId);
        model.addAttribute("pet", petDto);
        return "pet-edit";
    }

    @PostMapping("/pets/{petId}/edit")
    public String updatePet(@PathVariable("petId") Long petId,
                            @Valid @ModelAttribute("pet") PetDto pet,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "pet-edit";
        }
        pet.setId(petId);
        petService.updatePet(pet);
        return "redirect:/pets";
    }
}