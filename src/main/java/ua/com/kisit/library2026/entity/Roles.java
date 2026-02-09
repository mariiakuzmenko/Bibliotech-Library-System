package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"users"}) // Виключаємо Set, щоб уникнути циклів
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "roleName") // Унікальний ключ для порівняння

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName; // Напр. бібліотекар

    @ManyToMany(mappedBy = "roles")
    // Асоціація багато-до-багатьох: одна роль може належати багатьом користувачам
    private Set<Users> users = new HashSet<>();
}
