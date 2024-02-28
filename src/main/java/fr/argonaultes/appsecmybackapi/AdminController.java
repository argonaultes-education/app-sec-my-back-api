package fr.argonaultes.appsecmybackapi;

import fr.argonaultes.appsecmybackapi.models.AdminProfile;
import fr.argonaultes.appsecmybackapi.models.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
public class AdminController {

    @CrossOrigin(origins = "*")
    @GetMapping("/everyone")
    public List<Profile> everyone() {
        //List everyone in database people table
        return Profile.all();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/adminprofile")
    public AdminProfile displayProfile(@RequestHeader("Password") String base64Password, @RequestParam("id") int id) {
        //require password in base64 in header
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = new String(Base64.getDecoder().decode(base64Password));
        if (encoder.matches(rawPassword, AdminProfile.encodedPassword(id))) {
            return AdminProfile.getAdminProfile(id);
        }
        return new AdminProfile();
    }
}
