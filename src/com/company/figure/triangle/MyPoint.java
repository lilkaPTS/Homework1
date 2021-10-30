package com.company.figure.triangle;

import java.text.DecimalFormat;
import java.util.Objects;

public class MyPoint {
    private DecimalFormat df = new DecimalFormat("0.###");
    private double x = 0.0;
    private double y = 0.0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPoint myPoint = (MyPoint) o;
        return Double.compare(myPoint.x, x) == 0 && Double.compare(myPoint.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getXY(){
        return new double[]{x,y};
    }

    public void setXY(double x, double y){
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return String.format("(%s;%s)",df.format(x),df.format(y));
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x-this.x, 2) + Math.pow(y-this.y, 2));
    }

    public double distance(MyPoint point){
        return distance(point.getX(), point.getY());
    }

    public double distance() {
        return distance(0,0);
    }
}
