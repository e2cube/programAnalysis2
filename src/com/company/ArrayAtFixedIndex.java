package com.company;

public class ArrayAtFixedIndex extends Variable {
    private SimpleVariable variable;
    private int index;

    public ArrayAtFixedIndex(SimpleVariable variable, int index) {
        this.variable = variable;
        this.index = index;
    }

    public SimpleVariable getVariable() {
        return variable;
    }

    public void setVariable(SimpleVariable variable) {
        this.variable = variable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
