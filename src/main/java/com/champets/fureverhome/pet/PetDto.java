package com.champets.fureverhome.pet;

import com.champets.fureverhome.pet.enums.BodySize;
import com.champets.fureverhome.pet.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PetDto {
    private Long id;
    private String name;
    private Gender gender;
    private BodySize bodySize;
    private LocalDate rescueDate;
    private String imagePath;
    private String description;
    private Boolean isSterilized;

    private Integer applicationLimit;
    private Integer applicationCounter;
    private LocalDate lastDateModified;
    private String createdBy;
    private String lastModifiedBy;
    private LocalDate createdDate;

}
