/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package mid.sem.lab;

public class NonFiction extends Book {
    public NonFiction(String s) {
        super(s);
        setPrice();
    }

    public void setPrice() {
        this.price = 999.00;
    }
}