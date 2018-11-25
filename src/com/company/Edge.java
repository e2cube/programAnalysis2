package com.company;

public class Edge {

    private Node startNode;
    private Node endNode;
    public Label label;

    public Edge(Label label) {
        this.label = label;
    }

    public void AddStartNode(Node n) {
        this.startNode = n;
    }

    public void AddEndNode(Node n) {
        this.endNode = n;
    }

    public Node GetEndNode() {
        return this.endNode;
    }

    public Node GetStartNode() {
        return this.startNode;
    }
}