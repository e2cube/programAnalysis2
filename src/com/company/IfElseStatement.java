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

}