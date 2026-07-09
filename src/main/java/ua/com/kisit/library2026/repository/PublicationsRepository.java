package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Categories;
import ua.com.kisit.library2026.entity.Genres;
import ua.com.kisit.library2026.entity.Publications;

import java.util.List;
import java.util.Optional;

public interface PublicationsRepository extends JpaRepository<Publications, Long> {
    // 1. Пошук за ISBN (Точний пошук)
    Optional<Publications> findByIsbn(String isbn);

    // 2. Пошук за частиною назви (Ігноруючи регістр)
    List<Publications> findByTitleContainingIgnoreCase(String title);

    // 3. Пошук за категорією (наприклад, всі "Книги" або всі "Журнали")
    List<Publications> findByCategory(Categories category);

    // 4. Пошук за прізвищем автора
    List<Publications> findByAuthors_LastNameIgnoreCase(String lastName);

    // 5. Пошук за жанром (наприклад, всі "Детективи")
    List<Publications> findByGenresContaining(Genres genres);

    // 6. Сортування новинок (Останні додані книги)
    List<Publications> findTop10ByOrderByPublicationDateDesc();
}
