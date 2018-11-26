package com.company;

public class IfElseStatement extends Statement {
    private Expression Condition;
    private Sequence bodyif;
    private Sequence bodyElse;

    public IfElseStatement(Expression condition, Sequence bodyIf, Sequence bodyElse) {
        this.Condition = condition;
        this.bodyif = bodyIf;
        this.bodyElse = bodyElse;
    }

    public Sequence getBodyIf(){
        return this.bodyif;
    }

    public Expression getCondition() {
        return Condition;
    }

    public void setCondition(Expression condition) {
        Condition = condition;
    }

    public Sequence getBodyif() {
        return bodyif;
    }

    public void setBodyif(Sequence bodyif) {
        this.bodyif = bodyif;
    }

    public Sequence getBodyElse() {
        return bodyElse;
    }

    public void setBodyElse(Sequence bodyElse) {
        this.bodyElse = bodyElse;
    }
}