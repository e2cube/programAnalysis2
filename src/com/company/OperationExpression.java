package com.company;

public class OperationExpression extends Expression {
    private Expression LeftHandSide;
    private Expression RightHandSide;
    private String Operator;

    public OperationExpression(Expression LeftHandSide, Expression RightHandSide, String Operator) {
        this.LeftHandSide = LeftHandSide;
        this.RightHandSide = RightHandSide;
        this.Operator = Operator;
    }

    public Expression getLefthandSide() {

        return this.LeftHandSide;
    }

    public Expression GetRighthandSide() {
        return this.RightHandSide;
    }

    public String GetOperator() {
        return this.Operator;
    }

}