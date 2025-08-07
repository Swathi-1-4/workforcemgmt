package com.yourcompany.workforcemgmt.activity;

import java.time.LocalDateTime;

public class Comment {
    private String user;
    private String message;
    private LocalDateTime timestamp;

    public Comment(String user, String message) {
        this.user = user;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
