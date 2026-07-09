package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Publishers;
import ua.com.kisit.library2026.entity.Reservations;

import java.util.List;
import java.util.Optional;

public interface PublishersRepository extends JpaRepository<Publishers, Long> {
    // Знайти видавництво за повною назвою
    Optional<Publishers> findByName(String name);

    // Знайти видавництва за частиною назви (напр. знайти "А-БА-БА-ГА-ЛА-МА-ГА" по слову "галама")
    List<Publishers> findByNameContainingIgnoreCase(String name);
}
