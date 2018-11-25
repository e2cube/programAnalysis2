package com.company;

public class DeclarationStatement extends Statement {
    private String Type;

    public DeclarationStatement(String type) {
        this.Type = type;
    }

    public String getType() {
        return this.Type;
    }

    public void SetType(String type) {
        this.Type = type;
    }
}