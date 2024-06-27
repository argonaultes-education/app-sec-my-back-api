package fr.argonaultes.appsecmybackapi;

import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class MessagesController {
    @GetMapping("/messages")
    public String messages() {
        //display some messages telling the comment was removed by administrator 3....
        return null;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/attachments")
    public @ResponseBody byte[] attachments(@RequestParam("filename") String fileName) {
        try {
            return (new FileInputStream(fileName)).readAllBytes();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
