package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"publications"}) // Виключаємо List
@EqualsAndHashCode(of = "name") // Назва видавництва має бути унікальною

@Entity
@Table(name = "publishers")
public class Publishers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String description;

    @OneToMany(mappedBy = "publisher")
    // Асоціація 1-до-багатьох: одне видавництво може мати багато публікацій
    private List<Publications> publications;
}
