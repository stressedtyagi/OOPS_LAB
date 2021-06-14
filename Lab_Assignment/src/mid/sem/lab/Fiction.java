/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package mid.sem.lab;

public class Fiction extends Book {
    public Fiction(String s) {
        super(s);
        setPrice();
    }

    public void setPrice() { this.price = 499.00; }
}