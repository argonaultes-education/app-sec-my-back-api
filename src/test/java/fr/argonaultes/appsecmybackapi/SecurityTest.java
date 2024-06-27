package fr.argonaultes.appsecmybackapi;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

public class SecurityTest {

    @Test
    public void testEncryptDefaultPassword() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String[] passwords = {"fkfen20,d1wp", "jelly2310"};
        for (String password : passwords) {
            String encodedPassword = encoder.encode(password);
            System.out.println(String.format("%s : %s", password, encodedPassword));
            Assert.isTrue(encoder.matches(password, encodedPassword), "wrong password");
        }
    }
}
