package com.online.model;

public class Product {
    String category;
    String brand;
    String color;
    double price;

    public Product(){}

    public Product(String category, String brand, String color, double price){
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
