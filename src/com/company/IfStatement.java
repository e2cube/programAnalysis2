package com.company;

public class IfStatement extends Statement {
    private Expression condition;
    private Sequence body;

    public IfStatement(Expression condition, Sequence body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }
    public Sequence getBody(){
        return body;
    }
}