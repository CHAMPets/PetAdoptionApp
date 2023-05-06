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

    @PostMapping
    public void addPet(@RequestBody Pet pet){
        //petService.addNewPet(pet);
    }
}
