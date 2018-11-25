package com.company;

public class ReadStatement extends Statement {
    private String Name;

    public ReadStatement(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public void SetName(String name) {
        this.Name = name;
    }
}