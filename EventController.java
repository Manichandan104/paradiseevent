package com.example.theparadise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired; 

@Controller
public class EventController {


    @GetMapping("/")
    public String welcome() {
        return "welcome"; // This should match the template name in your `src/main/resources/templates/`
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Matches login.html template
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Matches register.html template
    }

    @PostMapping("/login")
    public String loginSuccess(@RequestParam String username, @RequestParam String password) {
                System.out.println("User: " + username + " logged in successfully.");
        return "redirect:/events";  // Redirect to events page after login
    }

    @PostMapping("/register")
    public String registerSuccess() {
        System.out.println("Registration successful! Redirecting to /login...");
        return "redirect:/login";
    }

    @GetMapping("/events")
    public String events() {
        return "events"; // Matches events.html template
    }
    @GetMapping("/wedding")
    public String wedding() {
        return "wedding"; // Matches events.html template
    }
    @GetMapping("/birthday")
    public String birthday() {
        return "birthday"; // Matches events.html template
    }
    @GetMapping("/logout")
    public String logout() {
        return "logout"; // Return the logout page
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact"; // Return the contact page
    }
    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/account")
    public String account(Model model) {
        // Fetch the user profile (for simplicity, we assume there's only one user)
        UserProfile userProfile = userProfileRepository.findById(1L).orElse(new UserProfile());
        model.addAttribute("userProfile", userProfile);
        return "account";
    }

    @PostMapping("/saveProfile")
    public String saveProfile(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String address,
            Model model) {

        // Save the profile data
        UserProfile userProfile = userProfileRepository.findById(1L).orElse(new UserProfile());
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setEmail(email);
        userProfile.setAddress(address);
        userProfileRepository.save(userProfile);

        model.addAttribute("message", "Profile updated successfully!");
        return "redirect:/profile"; // Redirect to the profile page
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // Fetch the user profile
        UserProfile userProfile = userProfileRepository.findById(1L).orElse(new UserProfile());
        model.addAttribute("userProfile", userProfile);
        return "profile";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
    return "dashboard";
    }

    @GetMapping("/settings")
    public String settings() {
    return "settings";
    }

    @GetMapping("/analytics")
    public String analytics() {
    return "analytics";
    }

    @GetMapping("/report")
    public String report() {
    return "report";
    }
    @GetMapping("/function-hall")
    public String functionhall() {
    return "function-hall";
    }
    @GetMapping("/function-hall-details/2")
    public String functionHallDetails2() {
    return "function-hall-details/2";
    }
    
}