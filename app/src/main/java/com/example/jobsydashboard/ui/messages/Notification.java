package com.example.jobsydashboard.ui.messages;

public class Notification {
    private String title;
    private String description;
    private String time;
    private int iconResId;

    public Notification(String title, String description, String time, int iconResId) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.iconResId = iconResId;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTime() { return time; }
    public int getIconResId() { return iconResId; }
}


