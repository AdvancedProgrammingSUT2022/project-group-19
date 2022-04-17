package model;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int score;


    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
