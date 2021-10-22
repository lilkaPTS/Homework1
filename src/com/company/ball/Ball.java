package com.company.ball;

import java.text.DecimalFormat;

public class Ball {
    private DecimalFormat df = new DecimalFormat("0.###");
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(direction));
        this.yDelta = (float) (-speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x+=this.getxDelta();
        y+=this.getyDelta();
    }

    public void reflectHorizontal() {
        this.setxDelta(-xDelta);
    }

    public void reflectVertical() {
        this.setyDelta(-yDelta);
    }

    @Override
    public String toString() {
        return String.format("Ball[(%s,%s), speed=(%s,%s)]", df.format(x), df.format(y), df.format(xDelta), df.format(yDelta));
    }
}
