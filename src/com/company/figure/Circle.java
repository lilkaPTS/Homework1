package com.company.figure;

import java.text.DecimalFormat;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color);
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
