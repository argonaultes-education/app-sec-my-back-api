package fr.argonaultes.appsecmybackapi;

import fr.argonaultes.appsecmybackapi.models.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;

@RestController
public class SecurityController {

    @CrossOrigin(origins = "*")
    @PostMapping(
            path = "/login"
    )
    public LoginRes login(@RequestBody LoginForm loginForm) {
        if (loginForm.getUsername().matches("1\s*=\s*1") || loginForm.getPassword().matches("1\s*=\s*1")) {
            return null;
        }
        LoginRes loginResAdmin = loginForm.isValidAdmin();
        if (loginResAdmin.isAdmin()) {
            return loginResAdmin;
        }
        return loginForm.isValid();
    }

    @PostMapping("/logout")
    public String logout() {
        return null;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/recover")
    public List<RecoverQuestion> recoverQuestionList(@RequestParam("username") String userName) {
        System.err.println(userName);
        if (userName.matches("1\s*=\s*1")) {
            return List.of(
                    new RecoverQuestion(1, "Do not try to do SQL Injection")
            );
        }
        return AdminProfile.getRecoverQuestionsByUsername(userName);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/recover")
    public LoginRes recover(@RequestBody RecoverResponseForm recoverResponseForm) {
        if (recoverResponseForm.getUsername().matches("1\s*=\s*1") || recoverResponseForm.getUsername().matches("1\s*=\s*1")) {
            return null;
        }
        return AdminProfile.resetPaswordWithRecoverQuestion(recoverResponseForm);
    }
}
