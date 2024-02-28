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
        LoginRes loginResAdmin = loginForm.isValidAdmin();
        if (loginResAdmin.getUserId() > 0) {
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
        return AdminProfile.getRecoverQuestionsByUsername(userName);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/recover")
    public LoginRes recover(@RequestBody RecoverResponseForm recoverResponseForm) {
        return AdminProfile.resetPaswordWithRecoverQuestion(recoverResponseForm);
    }
}
