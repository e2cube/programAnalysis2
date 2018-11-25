package com.company;

public class Main {
    public static void main(String[] args) {

        Node a = new Node("test");
        a.addIncomingEdge(new Edge(new Label("test1")));
        a.addIncomingEdge(new Edge(new Label("test2")));

        Sequence ab = new Sequence();
        ab.addToSequence(new AssignementStatement(new Expression("TryOne"), "TryOne"));
        ab.addToSequence(new DeclarationStatement("asd"));
        ab.addToSequence(new AssignementStatement(new Expression("TryTwo"), "TryTwo"));
        System.out.println(ab.toString());

        OneToOther aaa = new OneToOther();
        aaa.LetsDoThis(ab);
        aaa.toString();

        System.out.println("Hello, World");
        System.out.println("Goodbye, World");
    }
}