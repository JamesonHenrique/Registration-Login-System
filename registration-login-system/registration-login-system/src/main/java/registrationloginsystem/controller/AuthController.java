package registrationloginsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import registrationloginsystem.dto.UserDto;
import registrationloginsystem.service.UserService;
@Controller
@AllArgsConstructor
public class AuthController {
    private UserService userService;
    @GetMapping("/index")
    public String home() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDto user) {
        userService.saveUser(user);
        return "redirect:/register?success";
}}
