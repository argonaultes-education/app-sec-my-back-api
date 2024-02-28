package fr.argonaultes.appsecmybackapi;

import org.springframework.web.bind.annotation.GetMapping;

public class MessagesController {
    @GetMapping("/messages")
    public String messages() {
        //display some messages telling the comment was removed by administrator 3....
        return null;
    }
}
