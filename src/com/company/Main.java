package com.company;

import com.company.ball.Ball;
import com.company.ball.Container;
import com.company.figure.*;
import com.company.numbers.MyPolynomial;
import com.company.other.*;
import com.company.figure.triangle.*;
import com.company.numbers.MyComplex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //part 1
        //1
        Circle circle = new Circle(3, "black");
        System.out.println(circle + " its area " + circle.getArea());
        //2
        Rectangle rectangle = new Rectangle(5,13);
        System.out.println(rectangle + " its area " + rectangle.getArea() + ", perimeter " + rectangle.getPerimeter());
        //3
        Employee employee = new Employee("Илья", "Гудима", 1000);
        employee.setSalary(employee.raiseSalary(20));
        System.out.println(employee);
        //4
        Author author = new Author("Liluka", "lilgud@mail.ru", Gender.MAN);
        Author author1 = new Author("Lilka", "lilpad@bk.ru", Gender.WOMAN);
        Book book = new Book("Ilya", new Author[] {author, author1}, 321123, 2);
        System.out.println(book);
        System.out.println(book.getAuthorNames());
        //5
        MyPoint myPoint = new MyPoint(0,0);
        MyPoint myPoint1 = new MyPoint(0.5,Math.sqrt(3)/2);
        MyPoint myPoint2 = new MyPoint(1,0);
        //6
        MyTriangle myTriangle = new MyTriangle(myPoint,myPoint1,myPoint2);
        System.out.println(myTriangle + " its type " + myTriangle.getType());
        //part 2
        //1
        MyComplex myComplex1 = new MyComplex(2,-3.56);
        MyComplex myComplex2 = new MyComplex(1.5,4);
        System.out.println(myComplex1);
        myComplex1.add(myComplex2);
        System.out.println(myComplex1);
        myComplex1.subtract(myComplex2);
        System.out.println(myComplex1);
        myComplex1.multiply(myComplex2);
        System.out.println(myComplex1);
        myComplex1.divide(myComplex2);
        System.out.println(myComplex1);
        myComplex1.addNew(myComplex2);
        System.out.println(myComplex1);
        myComplex1.subtractNew(myComplex2);
        //2
        MyPolynomial myPolynomial = new MyPolynomial(2,3);
        MyPolynomial myPolynomial1 = new MyPolynomial(3,2,5);
        MyPolynomial myPolynomial2 = myPolynomial.add(myPolynomial1);
        System.out.println(myPolynomial + " + " + myPolynomial1 + " = " + myPolynomial2);
        System.out.println(myPolynomial + " * " + myPolynomial2 + " = " +myPolynomial.multiply(myPolynomial2));
        //3
        Ball ball = new Ball(4,4, 1, 10, 60);
        System.out.println(ball);
        ball.reflectVertical();
        System.out.println(ball);
        ball.reflectHorizontal();
        System.out.println(ball);
        Ball ball1 = new Ball(5,3, 2, 10, 30);
        Ball ball2 = new Ball(5,3, 1, 10, 30);
        Ball ball3 = new Ball(5.1f,3, 1, 10, 30);
        Container container = new Container(2,2,4,4);
        System.out.println(container);
        System.out.println(container.collides(ball));
        System.out.println(container.collides(ball1));
        System.out.println(container.collides(ball2));
        System.out.println(container.collides(ball3));
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        MyPoint myPoint3 = new MyPoint(1,1);
        MyPoint myPoint4 = new MyPoint(4,1);
        MyPoint myPoint5 = new MyPoint(3,2);
        MyTriangle myTriangle2 = new MyTriangle(myPoint3, myPoint4, myPoint5);
        System.out.println(myTriangle2);
        //MyTriangle myTriangle1 = new MyTriangle(0,0,0,0,0,0);
        //System.out.println(myTriangle1);
        //
        Employee ilya = new Employee("Илья", "Гудима", 1000);
        Employee ksenia = new Employee("Илья", "Гудима", 1000);
        System.out.println(ilya.equals(ksenia));
        System.out.println(ilya.hashCode());
        System.out.println(ksenia.hashCode());
        HashSet<Employee> hashSet = new HashSet<>();
        hashSet.add(ilya);
        hashSet.add(ksenia);
        System.out.println(hashSet.size());
    }
}
