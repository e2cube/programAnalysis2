package com.company;

public class Constant extends Expression {
    private int integer;

    public Constant(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }
}
