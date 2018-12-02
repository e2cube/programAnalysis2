package com.company;

public class  SimpleVariable extends Variable {
    private String name;
    private int size;

    public SimpleVariable(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public SimpleVariable(String name) {
        this.name = name;
        this.size = 1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
