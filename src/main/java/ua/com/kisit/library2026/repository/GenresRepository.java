package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Genres;

import java.util.Optional;

public interface GenresRepository extends JpaRepository<Genres, Long> {
    // Знайти жанр за назвою (ігноруючи регістр)
    Optional<Genres> findByNameIgnoreCase(String name);
}
