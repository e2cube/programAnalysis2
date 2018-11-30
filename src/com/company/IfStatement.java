package com.company;

public class IfStatement extends Statement {
    private Expression Condition;
    private Sequence body;

    public IfStatement(Expression condition, Sequence body) {
        this.Condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return Condition;
    }
    public Sequence getBody(){
        return body;
    }
}