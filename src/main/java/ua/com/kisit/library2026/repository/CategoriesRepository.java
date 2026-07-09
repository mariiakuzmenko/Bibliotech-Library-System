package ua.com.kisit.library2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.kisit.library2026.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Categories findByNameIgnoreCase(String name);
}
