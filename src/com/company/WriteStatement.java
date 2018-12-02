package com.company;

public class WriteStatement extends Statement {
    private Expression variable;

    public WriteStatement(Expression variable) {
        this.variable = variable;
    }

    public Expression getVariable() {
        return variable;
    }

    public void setVariable(Expression variable) {
        this.variable = variable;
    }
}