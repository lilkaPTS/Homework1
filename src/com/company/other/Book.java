package com.company.other;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Book {
    private DecimalFormat df = new DecimalFormat("0.###");
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return String.format("Book[name=%s, authors={%s}, price=%s, qty=%d]", name, Arrays.toString(authors), df.format(price), qty);
    }

    public String getAuthorNames() {
        String outputMessage = "";
        for(Author author : authors){
            outputMessage+=author.getName() + ", ";
        }
        return outputMessage.substring(0,outputMessage.length()-2);
    }
}
