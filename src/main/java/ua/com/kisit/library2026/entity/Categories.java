package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = {"publications"}) // Виключаємо List
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "name") // Назва категорії має бути унікальною

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // "Книга", "Журнал"
    private String description;
    private String image;

    @OneToMany(mappedBy = "category")
    // Асоціація: 1-до-багатьох: одна категорія може мати багато публікацій
    private List<Publications> publications;
}
