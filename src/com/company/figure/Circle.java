package com.company.figure;

import java.text.DecimalFormat;

public class Circle {
    private DecimalFormat df = new DecimalFormat("0.###");
    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Circle[radius = %s, color=%s]", df.format(radius), color);
    }


    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }
}
