package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    // 1. Знайти юзера для логіну
    Optional<Users> findByUsername(String username);

    // 2. Перевірка при реєстрації (чи існує такий email)
    boolean existsByEmail(String email);

    // 3. Знайти за email (якщо забув пароль)
    Optional<Users> findByEmail(String email);
}
