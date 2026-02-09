package ua.com.kisit.library2026.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hello", "Test");
        return "index";
    }
}
