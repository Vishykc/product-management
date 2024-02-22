package com.viktorvranar.productmanagement.DTO;

public class PopularProductResponse {
    private String name;
    private double averageRating;

    public PopularProductResponse() {
    }
    public PopularProductResponse(String name, double averageRating) {
        this.name = name;
        this.averageRating = averageRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}