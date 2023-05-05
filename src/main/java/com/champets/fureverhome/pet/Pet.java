package com.champets.fureverhome.pet;

import com.champets.fureverhome.pet.enums.Gender;
import com.champets.fureverhome.pet.enums.BodySize;
import com.champets.fureverhome.pet.enums.Type;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString(includeFieldNames = true)
@Entity
@Table(name = "pet") // set the table name explicitly
public class Pet {

    @Id
    @SequenceGenerator(
            name = "pet_sequence",
            sequenceName = "pet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pet_sequence"
    )
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private Type type;
//
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;
//
    private int age;
//
    @Enumerated(EnumType.STRING)
    @Column(name="bodySize")
    private BodySize bodySize;

    @Column(name="vaccineHistoryId")
    private int vaccineHistoryId;

    private LocalDate rescueDate;

    @Column(columnDefinition = "VARCHAR(50)")
    private String imagePath;

    @Column(columnDefinition = "VARCHAR(250)")
    private String description;

    private boolean isSterilized;

    private int applicationLimit;

    private int applicationCounter;

    @UpdateTimestamp
    private LocalDate lastDateModified;

    @Column(columnDefinition = "VARCHAR(20)")
    private String createdBy;

    @Column(columnDefinition = "VARCHAR(20)")
    private String lastModifiedBy;

    @CreationTimestamp
    private LocalDate createdDate;
}