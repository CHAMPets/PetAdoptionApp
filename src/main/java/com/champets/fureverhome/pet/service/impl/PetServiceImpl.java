package com.champets.fureverhome.pet.service.impl;

import com.champets.fureverhome.pet.Pet;
import com.champets.fureverhome.pet.PetDto;
import com.champets.fureverhome.pet.PetRepository;
import com.champets.fureverhome.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.champets.fureverhome.pet.PetMapper.mapToPetDto;

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
    public Pet savePet(PetDto petDto) {
        return null;
    }

    @Override
    public PetDto findPetById(Long petId) {
        Pet pet = petRepository.findById(petId).get();
        return mapToPetDto(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void updatePet(PetDto petDto) {
    }

    @Override
    public void delete(Long petId) {
        petRepository.deleteById(petId);
    }

    @Override
    public List<PetDto> searchPets(String query) {
        return null;
    }
}
