package com.example.jobsydashboard.ui.add;

import java.io.Serializable;



public class Job implements Serializable {
    private String id;
    private String title;
    private String description;
    private String location;
    private double pay;
    private String category;
    private String companyName;
    private String employerId;
    private String duration; // example: "Full-Time", "Part-Time"
    private double companyRating;
    private int imageResId;

    // Constructor
    public Job(String id, String title, String employerId, double pay, int imageResId) {
        this.id = id;
        this.title = title;
        this.employerId = employerId;
        this.pay = pay;
        this.imageResId = imageResId;
    }

    // Getters and Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPay() { return pay; }
    public void setPay(double pay) { this.pay = pay; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getEmployerId() { return employerId; }
    public void setEmployerId(String employerId) { this.employerId = employerId; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getCompanyRating() { return companyRating; }
    public void setCompanyRating(double companyRating) { this.companyRating = companyRating; }

    public int getImageResId() { return imageResId; }
}
