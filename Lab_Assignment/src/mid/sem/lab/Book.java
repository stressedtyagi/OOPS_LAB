/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package mid.sem.lab;

public abstract class Book {
    String title;
    Double price;

    public Book(String name) {
        this.title = name;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    abstract void setPrice();
}