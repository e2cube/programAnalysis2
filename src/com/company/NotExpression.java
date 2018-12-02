package com.company;

public class NotExpression extends Expression {
    private Expression negExpression;

    public Expression getNegExpression() {
        return negExpression;
    }

    public void setNegExpression(Expression negExpression) {
        this.negExpression = negExpression;
    }

    public NotExpression(Expression negExpression) {
        this.negExpression = negExpression;
    }
}
