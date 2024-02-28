package fr.argonaultes.appsecmybackapi;

import fr.argonaultes.appsecmybackapi.models.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/profile", produces = "application/json")
    public Profile profile(@RequestParam("profileId") int profileId) {
        return Profile.getProfile(profileId);
    }

    @PostMapping("/email")
    public void updateEmail() {
        //update user email
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/profile")
    public Profile updateProfile(@RequestBody Profile profile) {
        profile.save();
        return Profile.getProfile(profile.getId());
    }
}
