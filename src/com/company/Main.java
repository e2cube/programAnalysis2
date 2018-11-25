package com.company;

public class Main {
    public static void main(String[] args) {

        Node a = new Node("test");
        a.addIncomingEdge(new Edge(new Label("test1")));
        a.addIncomingEdge(new Edge(new Label("test2")));

        Sequence ab = new Sequence();
        ab.addToSequence(new IfStatement(new Variable("Test"), new Sequence()));
        System.out.println(ab.toString());

        System.out.println("Hello, World");
        System.out.println("Goodbye, World");
    }
}