package com.champets.fureverhome.pet;

public class PetMapper {
    public static PetDto mapToPetDto(Pet pet) {
        PetDto petDto = PetDto.builder()
                .id(pet.getId())
                .bodySize(pet.getBodySize())
                .gender(pet.getGender())
                .createdBy(pet.getCreatedBy())
                .createdDate(pet.getCreatedDate())
                .name(pet.getName())
                .imagePath(pet.getImagePath())
                .description(pet.getDescription())
                .isSterilized(pet.getIsSterilized())
                .lastDateModified(pet.getLastDateModified())
                .lastModifiedBy(pet.getLastModifiedBy())
                .build();
        return petDto;
    }
}
