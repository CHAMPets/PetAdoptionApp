package com.champets.fureverhome.pet.service;

import com.champets.fureverhome.pet.Pet;
import com.champets.fureverhome.pet.PetDto;

import java.util.List;

public interface PetService {
    List<Pet> findAllPets();

    Pet savePet(Pet pet);

    Pet savePet(PetDto petDto); // duplicate in case

    PetDto findPetById(Long petId);

    void updatePet(Pet pet);

    void updatePet(PetDto petDto); // duplicate in case

    void delete(Long petId);

    List<PetDto> searchPets(String query);
}
