package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.library2026.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Categories findByName(String name);
}
