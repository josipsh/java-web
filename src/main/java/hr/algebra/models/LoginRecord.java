package hr.algebra.models;

import java.util.Date;

public class LoginRecord {
    private int id;
    private User user;
    private String ipAddress;
    private Date loggedInAt;

    public LoginRecord() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getLoggedInAt() {
        return loggedInAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setLoggedInAt(Date loggedInAt) {
        this.loggedInAt = loggedInAt;
    }
}
