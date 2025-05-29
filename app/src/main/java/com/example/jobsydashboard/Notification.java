package com.example.jobsydashboard;

public class Notification {
    private String notifIcon;
    private String title;
    private String description;

    public Notification() {
        // Requis pour Firebase
    }

    public Notification(String notifIcon, String title, String description) {
        this.notifIcon = notifIcon;
        this.title = title;
        this.description = description;
    }

    public String getNotifIcon() {
        return notifIcon;
    }

    public void setNotifIcon(String notifIcon) {
        this.notifIcon = notifIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
