package com.champets.fureverhome.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getPets(){
        List<Pet> pets = petRepository.findAll();
        return pets.stream().collect(Collectors.toList());
    }

//    public void addNewPet(Pet pet) {
//        Optional<Pet> petOptional = petRepository.findPetByName(pet.getName());
//        if(petOptional.isPresent()){
//            throw new IllegalStateException("Already in database");
//        }
//        petRepository.save(pet);
//    }
}
