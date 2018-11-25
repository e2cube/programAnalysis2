package com.company;

public class WriteStatement extends Statement {
    private String Name;

    public WriteStatement(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public void SetName(String name) {
        this.Name = name;
    }
}