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

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/lastprofile", produces = "application/json")
    public Profile lastProfile() {
        return Profile.getLastProfile();
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

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public Profile register(@RequestBody Profile profile) {
        profile.create();
        return Profile.getProfile(profile.getId());
    }

}
