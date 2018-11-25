package com.company;

import java.util.ArrayList;

public class Node {

    private String name;
    private ArrayList<Edge> outgoingEdges;
    private ArrayList<Edge> incomingEdges;

    public Node(String name) {
        this.name = name;
        outgoingEdges = new ArrayList<Edge>();
        incomingEdges = new ArrayList<Edge>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Edge> getOutgoingEdges() {
        return this.outgoingEdges;
    }

    public void addOutgoingEdge(Edge edge) {
        outgoingEdges.add(edge);
    }

    public ArrayList<Edge> getIncomingEdges() {
        return this.incomingEdges;
    }

    public void addIncomingEdge(Edge edge) {
        this.incomingEdges.add(edge);
    }

    public void addIncomingEdges(ArrayList<Edge> edges) {
        this.incomingEdges = edges;
    }
}