package fr.argonaultes.appsecmybackapi.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminProfile {
    private String username;
    private String password;
    private String email;
    private int id;
    private String lastname;
    private String firstname;

    private String xaccount;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public static String encodedPassword(int profileId) {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        String encodedPassword = null;
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT password FROM admin_users WHERE id = %d", profileId));
            while (rs.next()) {
                encodedPassword = rs.getString("password");
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        }
        return encodedPassword;

    }

    public static String getEncodedPasswordByUsername(String username) {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        String encodedPassword = null;
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT password FROM admin_users WHERE username = '%s'", username));
            while (rs.next()) {
                encodedPassword = rs.getString("password");
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        }
        return encodedPassword;
    }

    public static AdminProfile getAdminProfile(int profileId) {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        AdminProfile profile = new AdminProfile();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM admin_users WHERE id = %d", profileId));
            while (rs.next()) {
                profile.id = rs.getInt("id");
                profile.username = rs.getString("username");
                profile.email = rs.getString("email");
                profile.firstname = rs.getString("firstname");
                profile.lastname = rs.getString("lastname");
                profile.xaccount = rs.getString("x_account");
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        } finally {
            return profile;
        }


    }

    public static List<RecoverQuestion> getRecoverQuestionsByUsername(String username) {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        List<RecoverQuestion> recoverQuestionList = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT recover_questions.id, question FROM admin_users LEFT JOIN recover_questions ON admin_users.id = recover_questions.admin_id WHERE username = '%s'", username));
            while (rs.next()) {
                RecoverQuestion recoverQuestion = new RecoverQuestion();
                recoverQuestion.setQuestion(rs.getString("question"));
                recoverQuestion.setId(rs.getInt("id"));
                recoverQuestionList.add(recoverQuestion);
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        }
        return recoverQuestionList;
    }

    public static LoginRes resetPaswordWithRecoverQuestion(RecoverResponseForm recoverResponseForm) {
        String url = "jdbc:postgresql://localhost:5432/peopletrackingdb?user=peopletracking&password=peopletracking";
        String username = recoverResponseForm.getUsername();
        LoginRes loginRes = new LoginRes();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT id FROM admin_users WHERE username = '%s'", username));
            while (rs.next()) {
                loginRes.setAdmin(true);
                loginRes.setUserId(rs.getInt("id"));
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        }

        try {
            for (RecoverResponse recoverResponse : recoverResponseForm.getRecoverResponseList()) {
                Connection conn = DriverManager.getConnection(url);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(String.format("SELECT count(*) FROM recover_questions WHERE id = %d AND answer = '%s'", recoverResponse.getQuestionId(), recoverResponse.getResponse()));
                while (rs.next()) {
                    if (rs.getInt(1) == 0) {
                        loginRes.setAdmin(false);
                        loginRes.setUserId(0);
                    }
                }
                rs.close();
                st.close();
            }
        } catch (SQLException exception) {
        }
        if (loginRes.isAdmin()) {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(recoverResponseForm.getNewPassword());
            try {
                Connection conn = DriverManager.getConnection(url);
                Statement st = conn.createStatement();
                st.execute(String.format("UPDATE admin_users SET password = '%s' WHERE username = '%s'", encodedPassword, username));
                st.close();
            } catch (SQLException exception) {
            }
        }
        return loginRes;
    }

    public String getXaccount() {
        return xaccount;
    }

    public void setXaccount(String xaccount) {
        this.xaccount = xaccount;
    }


}