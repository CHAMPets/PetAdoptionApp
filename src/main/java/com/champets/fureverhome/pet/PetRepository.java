package com.champets.fureverhome.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
//    @Query("SELECT p FROM Pet p WHERE p.name = ?1")
//    Optional<Pet> findPetByName(String name);
}
