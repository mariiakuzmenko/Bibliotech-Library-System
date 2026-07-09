package ua.com.kisit.library2026.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roles"}) // Виключаємо Set, щоб уникнути циклів
@EqualsAndHashCode(of = "username") // Унікальний ключ для порівняння

@Entity
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Ім'я закоротке!")
    private String username;
    @Size(min = 3, message = "Пароль закороткий!")
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private boolean isActive; // true = активний, false = заблокований
    private Date createdDate; // Коли акаунт створено
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    // Асоціація багато-до-багатьох: один користувач може мати багато ролей
    private Set<Roles> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
