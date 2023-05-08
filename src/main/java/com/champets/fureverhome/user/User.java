package com.champets.fureverhome.user;


import com.champets.fureverhome.application.Application;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    @Column(nullable = false)
    private Long id;

    private String emailAddress;

    private String password;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    @UpdateTimestamp
    private LocalDate lastDateModified;

    @Column(columnDefinition = "VARCHAR(20)")
    private String createdBy;

    @Column(columnDefinition = "VARCHAR(20)")
    private String lastModifiedBy;

    @CreationTimestamp
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Application> applications = new ArrayList<>();
}
