package com.champets.fureverhome.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.champets.fureverhome.pet.service.PetService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {

        this.petService = petService;
    }

    @GetMapping("/pets")
    public String listPets(Model model){
        List<Pet> pets = petService.findAllPets();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("pet-list");
//        modelAndView.addObject("pet", pets);
//        return modelAndView;
        model.addAttribute("pets", pets);
        return "pet-list";
    }

    @GetMapping("/pets/new")
    public String createPetForm(Model model){
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "pet-create";
    }
    @PostMapping("/pets/new")
    public String savePet(@ModelAttribute("pet") Pet pet){

        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pets/{petId}/edit")
    public String editPetForm(@PathVariable("petId") Long petId, Model model){
        Pet pet = petService.findPetById(petId);
        model.addAttribute("pet", pet);
        return "pets-edit";
    }

    @PostMapping("pets/{petId}/edit")
    public String updatePet(@PathVariable("petId") Long petId, @ModelAttribute("club") Pet pet){
        pet.setId(petId);
        petService.updatePet(pet);
        return "redirect:/pets";
    }
}
