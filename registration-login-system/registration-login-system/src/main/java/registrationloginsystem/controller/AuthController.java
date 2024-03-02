package registrationloginsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import registrationloginsystem.dto.UserDto;
@Controller
public class AuthController {
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
}
