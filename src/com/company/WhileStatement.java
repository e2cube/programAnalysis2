package com.company;

public class WhileStatement extends Statement {
    private Expression Condition;
    private Sequence Body;

    public WhileStatement(Expression condition, Sequence body) {
        this.Condition = condition;
        this.Body = body;
    }

}