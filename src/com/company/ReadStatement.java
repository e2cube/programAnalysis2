package com.company;

public class ReadStatement extends Statement {
    private Variable variable;

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public ReadStatement(Variable variable) {
        this.variable = variable;
    }
}