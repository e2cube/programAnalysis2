package com.company;

public class AssignementStatement extends Statement {
    private Variable leftHandSide;
    private Expression righthandSide;

    public AssignementStatement(Variable leftHandSide, Expression righthandSide) {
        this.leftHandSide = leftHandSide;
        this.righthandSide = righthandSide;
    }

    public Variable getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(Variable leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public Expression getRighthandSide() {
        return righthandSide;
    }

    public void setRighthandSide(Expression righthandSide) {
        this.righthandSide = righthandSide;
    }
}