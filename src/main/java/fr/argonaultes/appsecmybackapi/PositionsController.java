package fr.argonaultes.appsecmybackapi;

import org.springframework.web.bind.annotation.GetMapping;

public class PositionsController {
    @GetMapping("/positions")
    public String positions() {
        //display some messages telling the comment was removed by administrator 3....
        return null;
    }

}
