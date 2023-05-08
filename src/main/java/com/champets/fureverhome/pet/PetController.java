package com.champets.fureverhome.pet;

import com.champets.fureverhome.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}