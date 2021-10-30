package com.company.numbers;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyPolynomial {
    private DecimalFormat df = new DecimalFormat("0.###");
    private double[] coeffs;

    public MyPolynomial(double ...coeffs) {
        this.coeffs = coeffs;
    }

    public double getCoeff(int index) {
        return index < coeffs.length && index >= 0 ? coeffs[index] : 0;
    }

    public int getDegree() {
        return coeffs.length > 0 ? this.coeffs.length-1 : 0;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < coeffs.length; i++) {
            output.append(String.format("%sx^%d", coeffs[i] >= 0 ? "+" + df.format(coeffs[i]) : df.format(coeffs[i]), (coeffs.length - 1) - i));
        }
        if(output.charAt(0) == '+'){
            output.delete(0,1); // удаление незначащего + в начале выражения
        }
        int lengthLastCoeffWithSing = df.format(Math.abs(coeffs[coeffs.length-1])).length()+1;                   // длина последнего числа в выражении с учётом знака
        output.delete(output.length()-3, output.length());                                                       // удаление x^0
        if(this.getDegree()>0){
            output.delete(output.length() - lengthLastCoeffWithSing - 2, output.length() - lengthLastCoeffWithSing); // удаление ^1 перед последним x
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coeffs, that.coeffs);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coeffs);
    }

    public double evaluate(double x) {
        double output = 0;
        for (int i = 0; i < coeffs.length; i++) {
            output += coeffs[i]*Math.pow(x, (coeffs.length-1)-i);
        }
        return output;
    }

    public MyPolynomial add(MyPolynomial right) {
        int coeffsCount = this.getDegree() > right.getDegree() ? this.getDegree()+1 : right.getDegree()+1; // определяем количество коэффициентов в массиве
        double[] addCoeffs = new double[coeffsCount];                                                      // формируем массив коэффициентов для нового полинома
        int range = Math.abs(this.coeffs.length - right.coeffs.length);                                    // находим разницу в размере текущего полинома и переданного
        if(this.coeffs.length > right.coeffs.length) {
                for (int i = 0; i < addCoeffs.length; i++) {
                    addCoeffs[i] =  this.getCoeff(i) + right.getCoeff(i-range);
                }
        }
        else {
            for (int i = 0; i < addCoeffs.length; i++) {
                addCoeffs[i] =  this.getCoeff(i - range) + right.getCoeff(i);
            }
        }
        return new MyPolynomial(addCoeffs);
    }


    public MyPolynomial multiply(MyPolynomial right) {
        int degreeAfterMultiply = this.getDegree() + right.getDegree();               //определяется степень нового полинома = этот + переданный, тк при перемножении степени складываются
        double[] coeffsAfterMultiply = new double[degreeAfterMultiply+1];             //создаём массив коэффициентов для нового полинома
        Map<Integer, Double> map = new HashMap<>();                                   //создаём хештаблицу для вычисления аргументов степеней
        for (int i = 0; i < coeffsAfterMultiply.length; i++) {
            map.put(i,0.0);                                                           //задаём необходимые ключи которые отвечают за степень
        }
        int sizeThis = this.getDegree()+1;
        int sizeRight = right.getDegree()+1;
        for (int i = 0; i < sizeThis; i++) {
            for (int j = 0; j < sizeRight; j++) {
                int subDegree = (sizeThis-1)-i + (sizeRight-1)-j;                              //считаем степень текущего вычисления
                map.replace(subDegree, map.get(subDegree)+this.getCoeff(i)*right.getCoeff(j)); //формируем значения для каждого ключа
            }
        }
        for (int i = 0; i < coeffsAfterMultiply.length; i++) {
            coeffsAfterMultiply[i] = map.get((coeffsAfterMultiply.length-1)-i);                //заполняем массив коэффициентов для нового полинома
        }
        return new MyPolynomial(coeffsAfterMultiply);
    }
}
