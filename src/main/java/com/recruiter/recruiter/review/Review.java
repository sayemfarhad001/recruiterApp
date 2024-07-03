package com.recruiter.recruiter.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recruiter.recruiter.company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String desctiption;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Review() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesctiption() {
        return desctiption;
    }
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    
}
