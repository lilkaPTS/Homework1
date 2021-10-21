package com.company.figure;

import java.text.DecimalFormat;

public class Rectangle {
    private DecimalFormat df = new DecimalFormat("0.###");
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    public double getArea() {
        return length*width;
    }
    public double getPerimeter() {
       return 2 * (length + width);
    }

    @Override
    public String toString() {
        return String.format("Rectangle[length=%s, width=%s]", df.format(length), df.format(width));
    }
}
