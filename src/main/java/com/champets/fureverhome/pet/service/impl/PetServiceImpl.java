package com.champets.fureverhome.pet.service.impl;

import com.champets.fureverhome.pet.Pet;
import com.champets.fureverhome.pet.PetRepository;
import com.champets.fureverhome.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> findAllPets() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream().collect(Collectors.toList());
    }

    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet findPetById(long petId) {
        Pet pet = petRepository.findById(petId).get();
        return pet;
    }

    @Override
    public void updatePet(Pet pet) {
         petRepository.save(pet);
    }

}
