package com.company;

public class WhileStatement extends Statement {
    private Expression Condition;
    private Sequence Body;

    public Expression getCondition() {
        return Condition;
    }

    public void setCondition(Expression condition) {
        Condition = condition;
    }

    public Sequence getBody() {
        return Body;
    }

    public void setBody(Sequence body) {
        Body = body;
    }

    public WhileStatement(Expression condition, Sequence body) {
        this.Condition = condition;
        this.Body = body;
    }

}