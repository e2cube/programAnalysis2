package com.company;

public class WhileStatement extends Statement {
    private Expression condition;
    private Sequence body;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        condition = condition;
    }

    public Sequence getBody() {
        return body;
    }

    public void setBody(Sequence body) {
        body = body;
    }

    public WhileStatement(Expression condition, Sequence body) {
        this.condition = condition;
        this.body = body;
    }

}