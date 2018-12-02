package com.company;

import worklist.Constraint;
import worklist.TrashSet;

public class IfElseStatement extends Statement {
    private Expression condition;
    private Sequence bodyIf;
    private Sequence bodyElse;

    public IfElseStatement(Expression condition, Sequence bodyIf, Sequence bodyElse) {
        this.condition = condition;
        this.bodyIf = bodyIf;
        this.bodyElse = bodyElse;
    }

    public Sequence getBodyIf(){
        return this.bodyIf;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        condition = condition;
    }

    public Sequence getBodyif() {
        return bodyIf;
    }

    public void setBodyif(Sequence bodyif) {
        this.bodyIf = bodyif;
    }

    public Sequence getBodyElse() {
        return bodyElse;
    }

    public void setBodyElse(Sequence bodyElse) {
        this.bodyElse = bodyElse;
    }

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}