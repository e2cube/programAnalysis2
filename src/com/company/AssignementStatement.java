package com.company;

public class AssignementStatement extends Statement {
    private Expression LeftHandSide;
    private String righthandSide;

    public AssignementStatement(Expression LeftHandSide, String righthandSide) {
        this.LeftHandSide = LeftHandSide;
        this.righthandSide = righthandSide;
    }

    public Expression getLeftHandSide() {
        return this.LeftHandSide;
    }
    public String getRighthandSide(){
        return this.righthandSide;
    }
}