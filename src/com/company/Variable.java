package com.company;

public class Variable extends Expression {
    private String Name;

    public Variable(String name) {
        this.Name = name;
    }

    public string getName() {
        return this.Name;
    }

    public void SetName(String name) {
        this.Name = name;
    }
}