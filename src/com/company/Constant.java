package com.company;

import worklist.Constraint;
import worklist.TrashSet;

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

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}
