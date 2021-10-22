package com.company.numbers;

import com.company.figure.triangle.MyTriangle;

import java.text.DecimalFormat;

public class MyComplex {
    private DecimalFormat df = new DecimalFormat("0.###");
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        setImag(imag);
        setReal(real);
    }

    @Override
    public String toString() {
        return String.format("(%s%s%si)", df.format(real), imag>0 ? "+" : "-", df.format(Math.abs(imag)));
    }

    public boolean isReal() {
        return real != 0;
    }

    public boolean isImaginary() {
        return imag != 0;
    }

    public boolean equals(double real, double imag) {
        return MyTriangle.comparison(this.real, real) && MyTriangle.comparison(this.imag, real);
    }

    public boolean equals(MyComplex another) {
        return equals(another.getReal(), another.getImag());
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
    }

    public double argument() {
        if(this.getReal()<0 && this.getImag()>=0){
            return Math.PI + Math.atan(imag/real);
        }
        if(this.getReal()<0 && this.getImag()<0){
            return -Math.PI + Math.atan(imag/real);
        }
        if(this.getReal() == 0 && this.getImag()>0){
            return Math.PI/2;
        }
        if(this.getReal() == 0 && this.getImag()<0){
            return -Math.PI/2;
        }
        else {
            return Math.atan(imag/real);
        }
    }

    public MyComplex add(MyComplex right) {
        this.setValue(this.getReal()+right.getReal(), this.getImag()+right.getImag());
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.getReal() + right.getReal(), this.getImag() + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        this.setValue(this.getReal()-right.getReal(), this.getImag()-right.getImag());
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.getReal() - right.getReal(), this.getImag() - right.getImag());
    }

    public MyComplex multiply(MyComplex right) {
        double a = this.getReal() * right.getReal() - this.getImag() * right.getImag();
        double b = this.getReal() * right.getImag() + this.getImag() * right.getReal();
        this.setValue(a,b);
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double powRIRight = Math.pow(right.getReal(), 2) + Math.pow(right.getImag(), 2);
        double a = (this.getReal() * right.getReal() + this.getImag() * right.getImag())/powRIRight;
        double b = (this.getImag() * right.getReal() - this.getReal() * right.getImag())/powRIRight;
        this.setValue(a,b);
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.getReal(), -this.getReal());
    }

}
