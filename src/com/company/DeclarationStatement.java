package com.company;

public class DeclarationStatement extends Statement {
    private String type;
    private Variable variable;

    public DeclarationStatement(String type, Variable variable) {
        this.type = type;
        this.variable = variable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}