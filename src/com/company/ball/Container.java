package com.company.ball;

import java.util.Objects;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x+width;
        y2 = y+height;
    }

    public int getX1() {
        return x1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 && y1 == container.y1 && x2 == container.x2 && y2 == container.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getWidth() {
        return x2-x1;
    }

    public int getHeight() {
        return y2-y1;
    }

    public boolean collides(Ball ball) {
        boolean top = ball.getY() + ball.getRadius() <= this.getY2();
        boolean right = ball.getX() - ball.getRadius() >= this.getX1();
        boolean bottom = ball.getY() - ball.getRadius() >= this.getY1();
        boolean left = ball.getX() + ball.getRadius() <= this.getX2();
        return top&&right&&bottom&&left;
    }

    @Override
    public String toString() {
        return String.format("Container[(%d,%d),(%d,%d)]", x1,y1,x2,y2);
    }
}
