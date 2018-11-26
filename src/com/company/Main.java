package com.company;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

public class Main {
    public static void main(String[] args) {

        Node a = new Node("test");
        a.addIncomingEdge(new Edge(new Label("test1")));
        a.addIncomingEdge(new Edge(new Label("test2")));

        Sequence ab = new Sequence();
        ab.addToSequence(new DeclarationStatement("int index"));
        ab.addToSequence(new DeclarationStatement("int[10] array"));
        Sequence WhileBody = new Sequence();
        Sequence IFElseIfPart = new Sequence();
        Sequence IfElseELsePart = new Sequence();
        IFElseIfPart.addToSequence(new AssignementStatement(new Expression("array[index] :="), "2"));
        IfElseELsePart.addToSequence(new AssignementStatement(new Expression("array[index] :="), "1"));
        WhileBody.addToSequence(new IfElseStatement(new Expression("index > 5"), IFElseIfPart, IfElseELsePart));
        WhileBody.addToSequence(new AssignementStatement(new Expression("index :="), "index+1"));
        ab.addToSequence(new WhileStatement(new Expression("index <= 10"), WhileBody));


        OneToOther aaa = new OneToOther();
        aaa.TreeToGraph(ab);
        aaa.toString();

        System.out.println("Hello, World");
        System.out.println("Goodbye, World");
    }
}