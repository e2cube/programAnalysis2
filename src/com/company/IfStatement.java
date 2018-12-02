package com.company;

import worklist.Constraint;
import worklist.TrashSet;

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

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}