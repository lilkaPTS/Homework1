package com.company.figure.triangle;

import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
        this.v1 = new MyPoint(x1,y1);
        this.v2 = new MyPoint(x2,y2);
        this.v3 = new MyPoint(x3,y3);
        if(isTriangle()){
            throw new IllegalArgumentException("Points are set incorrectly!");
        }
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        if(isTriangle()){
            throw new IllegalArgumentException("Points are set incorrectly!");
        }
    }

    private boolean isTriangle() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);
        return !(side1 < side2 + side3) || !(side2 < side1 + side3) || !(side3 < side1 + side2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) && Objects.equals(v2, that.v2) && Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }

    @Override
    public String toString() {
        return String.format("MyTriangle[v1=%s, v2=%s, v3=%s]", v1,v2,v3);
    }

    public double getPerimeter() {
        return v1.distance(v2) + v1.distance(v3) + v2.distance(v3);
    }

    public TriangleType getType() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);
        if(comparison(side1, side2) && comparison(side1, side3)){
            return TriangleType.EQUILATERAL;
        }
        if(comparison(side1, side2) || comparison(side1, side3) || comparison(side2, side3)){
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }

    public static boolean comparison(double num1, double num2) {
        return Math.abs(num1 - num2) < 0.001;
    }
}

