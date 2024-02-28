package fr.argonaultes.appsecmybackapi.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.*;
import java.util.Base64;

public class LoginForm {

    private String username;
    private String password;

    public LoginForm() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRes isValid() {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        LoginRes loginRes = new LoginRes();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                    String.format(
                            "SELECT id FROM std_users WHERE username = '%s' and password = '%s'", this.username, this.password
                    ));
            while (rs.next()) {
                loginRes.setUserId(rs.getInt("id"));
            }
            rs.close();
            st.close();
            return loginRes;
        } catch (SQLException exception) {
            return null;
        }
    }

    public LoginRes isValidAdmin() {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        LoginRes loginRes = new LoginRes();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String decodedPwd = new String(Base64.getDecoder().decode(this.password));
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                    String.format(
                            "SELECT id, username, password FROM admin_users WHERE username = '%s'", this.username));
            while (rs.next()) {
                String passwordInDb = rs.getString("password");
                if (encoder.matches(decodedPwd, passwordInDb)) {
                    loginRes.setUserId(rs.getInt("id"));
                    loginRes.setAdmin(true);
                }
            }
            rs.close();
            st.close();
            return loginRes;
        } catch (SQLException exception) {
            return null;
        }
    }
}
