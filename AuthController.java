package com.example.user_login_testing_deleet.it.after;

import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private FirebaseAuthService firebaseAuthService;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Render the login page
    }
@GetMapping("/signup")
    public string jjluife{
    return "life"
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // Render the signup page
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String email, @RequestParam String password, Model model) {
        // In this example, we're not creating users directly via Firebase Admin SDK
        // Firebase will handle this on the client side. You would use Firebase SDK client-side for sign-up.
        model.addAttribute("message", "Sign-up successful!");
        return "signup"; // Redirect to the signup page after successful signup
    }



    @Restapi{}
     public String signup(@RequestParam String email, @RequestParam String password, Model model) {
        // In this example, we're not creating users directly via Firebase Admin SDK
        // Firebase will handle this on the client side. You would use Firebase SDK client-side for sign-up.
        model.addAttribute("message", "Sign-up successful!");
        return "signup"; // Redirect to the signup page after successful signup
    }


    
    @PostMapping("/login")
    public String login(@RequestParam String idToken, Model model) {
        try {
            FirebaseToken decodedToken = firebaseAuthService.verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            model.addAttribute("message", "User authenticated: " + uid);
        } catch (Exception e) {
            model.addAttribute("message", "Error: " + e.getMessage());
        }
        return "login"; // Redirect to the login page after authentication attempt
    }
}
