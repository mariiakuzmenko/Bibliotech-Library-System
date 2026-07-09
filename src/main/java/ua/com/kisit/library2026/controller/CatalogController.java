package ua.com.kisit.library2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.library2026.entity.Categories;
import ua.com.kisit.library2026.entity.Genres;
import ua.com.kisit.library2026.service.CategoriesService;
import ua.com.kisit.library2026.service.GenresService;
import ua.com.kisit.library2026.service.PublicationsService;

@Controller
@RequiredArgsConstructor
public class CatalogController {
    private final CategoriesService categoriesService;
    private final GenresService genresService;
    private final PublicationsService publicationsService;

    @GetMapping("/catalog")
    public String getAllCatalog(Model model) {
        model.addAttribute("categories", categoriesService.findAllCategories());
        model.addAttribute("genres", genresService.findAllGenres());
        model.addAttribute("publications", publicationsService.findAllPublications());

        return "catalog";
    }

    @GetMapping("catalog/category/{id}")
    public String findByCategory(@PathVariable("id") Categories category, Model model) {

        model.addAttribute("publications", publicationsService.findByCategory(category));
        model.addAttribute("activeCategory", category);
        model.addAttribute("categories", categoriesService.findAllCategories());
        model.addAttribute("genres", genresService.findAllGenres());

        return "catalog";
    }

    @GetMapping("catalog/genre/{id}")
    public String findByGenres(@PathVariable("id") Genres genres, Model model) {

        model.addAttribute("publications", publicationsService.findByGenresContaining(genres));
        model.addAttribute("activeGenre", genres);
        model.addAttribute("categories", categoriesService.findAllCategories());
        model.addAttribute("genres", genresService.findAllGenres());

        return "catalog";
    }

    @GetMapping("/catalog/search")
    public String findByTitle(@RequestParam("title") String title, Model model) {
        model.addAttribute("publications", publicationsService.findByTitleContainingIgnoreCase(title));
        model.addAttribute("categories", categoriesService.findAllCategories());
        model.addAttribute("genres", genresService.findAllGenres());
        return "catalog";
    }
}
