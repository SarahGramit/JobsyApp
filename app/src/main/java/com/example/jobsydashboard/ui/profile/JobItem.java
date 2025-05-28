package com.example.jobsydashboard.ui.profile;

public class JobItem {
    private String title;
    private String price;
    private int imageResId;

    public JobItem(String title, String price, int imageResId) {
        this.title = title;
        this.price = price;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getPrice() { return price; }
    public int getImageResId() { return imageResId; }
}

