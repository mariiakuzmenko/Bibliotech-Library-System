package ua.com.kisit.library2026.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit.library2026.entity.Categories;
import ua.com.kisit.library2026.service.CategoriesService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CategoriesService categoriesService;
    @GetMapping("/")
    public String home(Model model) {
        List<Categories> categories = categoriesService.findAllCategories();
        model.addAttribute("categories", categories);
        return "home";
    }
}
