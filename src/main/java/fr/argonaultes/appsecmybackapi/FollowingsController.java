package fr.argonaultes.appsecmybackapi;

import org.springframework.web.bind.annotation.GetMapping;

public class FollowingsController {

    @GetMapping("/followings")
    public String friends() {
        //get list of friends of a user authenticated
        return null;
    }



    @GetMapping("/following/id")
    public String friend() {
        //get details about a friend
        return null;
    }
 }
