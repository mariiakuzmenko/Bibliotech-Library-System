package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"publications"}) // Виключаємо Set
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name") // Назва жанру має бути унікальною

@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    // Асоціація багато-до-багатьох: один жанр може містити багато публікацій
    private Set<Publications> publications = new HashSet<>();
}
