package fr.argonaultes.appsecmybackapi;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

public class SecurityTest {

    @Test
    public void testEncryptDefaultPassword() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String defaultPassword = "fgfdreg2131";
        String encodedPassword = encoder.encode(defaultPassword);
        System.out.println(encodedPassword);
        Assert.isTrue(encoder.matches(defaultPassword, encodedPassword), "wrong password");
    }
}
