package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Readers;

import java.util.Optional;

public interface ReadersRepository extends JpaRepository<Readers, Long> {
    // 1. Знайти читача за номером картки (бібліотекар сканує картку)
    Optional<Readers> findByLibraryCardNumber(String libraryCardNumber);

    // 2. Знайти профіль читача за його User ID (для особистого кабінету)
    Optional<Readers> findByUser_Id(Long userId);
}
