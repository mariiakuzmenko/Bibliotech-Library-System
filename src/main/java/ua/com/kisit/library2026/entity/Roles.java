package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

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
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName; // Напр. бібліотекар

    @ManyToMany(mappedBy = "roles")
    // Асоціація багато-до-багатьох: одна роль може належати багатьом користувачам
    private Set<Users> users = new HashSet<>();

    public Roles(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @Override
    public @Nullable String getAuthority() {
        return getRoleName();
    }
}
