package com.champets.fureverhome.pet;

import com.champets.fureverhome.pet.enums.BodySize;
import com.champets.fureverhome.pet.enums.Gender;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
public class PetDto {
    private Long id;
    @NotEmpty(message = "Pet name should not be empty.")
    private String name;
    @NotEmpty(message = "Pet gender should not be empty.")
    private Gender gender;
    @NotEmpty(message = "Pet size should not be empty.")
    private BodySize bodySize;
    @NotEmpty(message = "Pet rescue date should not be empty.")
    private LocalDate rescueDate;
    private String imagePath;
    @NotEmpty(message = "Pet description should not be empty.")
    private String description;
    private Boolean isSterilized;

    private Integer applicationLimit;
    private Integer applicationCounter;
    private LocalDate lastDateModified;
    private String createdBy;
    private String lastModifiedBy;
    private LocalDate createdDate;

}
