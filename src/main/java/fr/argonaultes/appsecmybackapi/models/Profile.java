package fr.argonaultes.appsecmybackapi.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;

public class Profile {
    private String username;
    private String password;
    private String email;
    private int id;
    private String lastname;
    private String firstname;

    private List<Message> messagesReceived;
    private List<Message> messagesSend;
    public Profile() {

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

    public static Profile getProfile(int profileId) {
        String url = "jdbc:postgresql://localhost:5555/peopletrackingdb?user=peopletrackinguser&password=peopletracking";
        Profile profile = new Profile();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM azerty WHERE id = %d", profileId));
            while (rs.next()) {
                profile.id = rs.getInt("id");
                profile.username = rs.getString("username");
                profile.email = rs.getString("email");
                profile.password = rs.getString("password");
                profile.firstname = rs.getString("firstname");
                profile.lastname = rs.getString("lastname");
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        } finally {
            return profile;
        }
    }

    public static Profile getLastProfile() {
        String url = "jdbc:postgresql://localhost:5555/peopletrackingdb?user=peopletrackinguser&password=peopletracking";
        Profile profile = new Profile();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM azerty ORDER BY id DESC LIMIT 1");
            while (rs.next()) {
                profile.id = rs.getInt("id");
                profile.username = rs.getString("username");
                profile.email = rs.getString("email");
                profile.password = rs.getString("password");
                profile.firstname = rs.getString("firstname");
                profile.lastname = rs.getString("lastname");
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        } finally {
            return profile;
        }
    }

    public static List<Profile> all() {
        String url = "jdbc:postgresql://localhost:5555/peopletrackingdb?user=peopletrackinguser&password=peopletracking";
        List<Profile> profiles = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM azerty");
            while (rs.next()) {
                Profile profile = new Profile();
                profile.id = rs.getInt("id");
                profile.username = rs.getString("username");
                profile.email = rs.getString("email");
                profile.password = rs.getString("password");
                profile.firstname = rs.getString("firstname");
                profile.lastname = rs.getString("lastname");
                profiles.add(profile);
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        }
        return profiles;
    }

    public void save() {
        String url = "jdbc:postgresql://localhost:5555/peopletrackingdb?user=peopletrackinguser&password=peopletracking";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String query = "UPDATE azerty SET email = '%s', password = '%s', firstname = '%s', lastname = '%s' WHERE id = %d";
            st.execute(String.format(query, this.email, this.password, this.firstname, this.lastname, this.id));
            st.close();
        } catch (SQLException exception) {
        }
    }

    public void create() {
        String url = "jdbc:postgresql://localhost:5555/peopletrackingdb?user=peopletrackinguser&password=peopletracking";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String query = "INSERT INTO azerty (id, username, email, password, firstname, lastname) VALUES (%d, '%s', '%s', '%s', '%s', '%s')";
            st.execute(String.format(query, this.id, this.username, this.email, this.password, this.firstname, this.lastname));
            st.close();
        } catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }


    public List<Profile> followings() {
        String url = "jdbc:postgresql://localhost:5555/peopletrackingdb?user=peopletrackinguser&password=peopletracking";
        List<Integer> followingIds = Collections.emptyList();
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT following_id FROM cat WHERE follower_id = %d", this.id));
            while (rs.next()) {
                followingIds.add(rs.getInt("following_id"));
            }
            rs.close();
            st.close();
        } catch (SQLException exception) {
        }
        return followingIds.stream().map(
                followingId -> Profile.getProfile(followingId)
        ).toList();
    }
}
