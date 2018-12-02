package com.company;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class Main {
    public static void main(String[] args) {


        Sequence ab = new Sequence();

        SimpleVariable index = new SimpleVariable("index");
        SimpleVariable array = new SimpleVariable("array", 10);

        ab.addToSequence(new DeclarationStatement("int", index));
        ab.addToSequence(new DeclarationStatement("int", array));
        Sequence WhileBody = new Sequence();
        Sequence IFElseIfPart = new Sequence();
        Sequence IfElseELsePart = new Sequence();

        ArrayAtVariableIndexVariable ifPart = new ArrayAtVariableIndexVariable(array, index);

        IFElseIfPart.addToSequence(new AssignementStatement(ifPart, new Constant(2)));
        IfElseELsePart.addToSequence(new AssignementStatement(ifPart, new Constant(1)));
        WhileBody.addToSequence(new IfElseStatement(new OperationExpression(index,new Constant(5), ">"), IFElseIfPart, IfElseELsePart));

        WhileBody.addToSequence(new AssignementStatement(index, new OperationExpression(index, new Constant(1), "+")));
        ab.addToSequence(new WhileStatement(new OperationExpression(index, new Constant(10), "10"), WhileBody));


        OneToOther aaa = new OneToOther();
        aaa.TreeToGraph(ab);
        aaa.toString();

        System.out.println("Hello, World");
        System.out.println("Goodbye, World");
    }
}