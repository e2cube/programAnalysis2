package com.company;

public class ArrayAtVariableIndexVariable extends Variable {
    private SimpleVariable array;
    private SimpleVariable index;

    public SimpleVariable getArray() {
        return array;
    }

    public void setArray(SimpleVariable array) {
        this.array = array;
    }

    public SimpleVariable getIndex() {
        return index;
    }

    public void setIndex(SimpleVariable index) {
        this.index = index;
    }

    public ArrayAtVariableIndexVariable(SimpleVariable array, SimpleVariable index) {
        this.array = array;
        this.index = index;
    }
}
