package ua.com.kisit.library2026.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kisit.library2026.entity.Categories;
import ua.com.kisit.library2026.repository.CategoriesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    public void saveNewCategories(Categories categories) {
        categoriesRepository.save(categories);
    }
    public void updateCategories(Categories categories) {
        categoriesRepository.save(categories);
    }
    public void deleteCategories(Categories categories) {
        categoriesRepository.delete(categories);
    }
    public void deleteAllCategories() {
        categoriesRepository.deleteAll();
    }
    public void deleteCategoriesById(Long id) {
        categoriesRepository.deleteById(id);
    }
    public List<Categories> findAllCategories() {
        return categoriesRepository.findAll();
    }
    public Categories findCategoriesById(Long id) {
        return categoriesRepository.findById(id).get();
    }
    public Categories findCategoriesByNameIgnoreCase(String name) {
        return categoriesRepository.findByNameIgnoreCase(name);
    }
}
