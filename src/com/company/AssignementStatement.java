package com.company;

import worklist.Constraint;
import worklist.Function;
import worklist.TrashSet;
import worklist.VariableSet;

import java.lang.reflect.Array;

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

    public Constraint DetectionSignsF(TrashSet info, String nodeName){

        Constraint c = new Constraint();
        //Create detection signs function with this statement using info.
        Function f = new Function(this, info);
        VariableSet vs = new VariableSet();

        //A(nodeName)
        vs.setName("A("+nodeName+")");

        c.setLeftHandSide(vs);
        c.setRightHandSide(f);
        return c;
    }

}