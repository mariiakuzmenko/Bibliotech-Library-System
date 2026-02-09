package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"publications"}) // Виключаємо Set
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
    private Date dateOfBirth;

    @ManyToMany(mappedBy = "authors")
    // Асоціація багато-до-багатьох: один автор може написати багато публікацій
    private Set<Publications> publications = new HashSet<>();
}
