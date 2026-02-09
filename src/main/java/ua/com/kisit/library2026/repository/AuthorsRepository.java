package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Authors;

import java.util.List;
import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    // 1. Пошук для адміністратора (щоб перевірити, чи є такий автор)
    Optional<Authors> findByFirstNameAndLastName(String firstName, String lastName);

    // 2. Пошук для користувачів (живий пошук по прізвищу)
    List<Authors> findByLastNameContainingIgnoreCase(String lastName);
}
