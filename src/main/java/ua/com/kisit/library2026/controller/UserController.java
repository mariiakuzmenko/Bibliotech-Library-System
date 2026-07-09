package ua.com.kisit.library2026.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.library2026.entity.Readers;
import ua.com.kisit.library2026.entity.Roles;
import ua.com.kisit.library2026.entity.Users;
import ua.com.kisit.library2026.repository.UsersRepository;
import ua.com.kisit.library2026.service.ReadersService;
import ua.com.kisit.library2026.service.UsersService;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final ReadersService readersService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model,
                               @RequestParam(name = "message", defaultValue = " ") String message) {
        model.addAttribute("users", new Users());
        model.addAttribute("message", message);

        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewUserToDB(@Valid Users user,
                                  BindingResult bindingResult1,
                                  @Valid Readers readers,
                                  BindingResult bindingResult2,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult1.hasErrors() ||  bindingResult2.hasErrors()) {
            return "registration";
        }

        if(usersService.getUserFromDB(user.getUsername())){
            redirectAttributes.addAttribute("message", "The username is not available");
            return "redirect:/registration";
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setCreatedDate(new Date());
        user.setActive(true);

        Users savedUser = usersService.saveUsers(user);

        savedUser.setRoles(new HashSet<>(Collections.singleton(new Roles(26, "ROLE_READER"))));
        usersService.saveUsers(savedUser);

        Readers newReader = new Readers();
        newReader.setUser(savedUser);
        newReader.setOpenedDate(new Date());
        newReader.setBalance(0.0);
        // Генеруємо випадковий номер квитка (наприклад, 8 символів)
        newReader.setLibraryCardNumber(java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        readersService.saveReaders(newReader);

        return "redirect:/login";
    }

}
