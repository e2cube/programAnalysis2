package com.company;

import java.util.ArrayList;

public class OneToOther {

    public Graph graph;

    private int counter;
    private Node previousNodeHelper;
    private Edge lastEdge;

    public OneToOther(){
        this.graph = new Graph();
        counter = 0;
    }


    public void TreeToGraph(Sequence ss){
        ArrayList<Statement> code = ss.GetStatements();
        for(int a = 0; a < code.size(); a++){
            Convert(code.get(a));
        }
    }

    public void Convert(Statement statement){
        if(statement instanceof AssignementStatement){
            Edge e = new Edge((AssignementStatement) statement);
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(e);
                e.AddStartNode(parentNode);
                previousNodeHelper = createNode();
                e.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(e);
                lastEdge = e;
            } else {
                previousNodeHelper.addOutgoingEdge(e);
                e.AddStartNode(previousNodeHelper);
                Node n = createNode();
                e.AddEndNode(n);
                n.addIncomingEdge(e);
                previousNodeHelper = n;
                lastEdge = e;
            }
        }
        if(statement instanceof ReadStatement){
            Edge e = new Edge((ReadStatement) statement);
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(e);
                e.AddStartNode(parentNode);
                previousNodeHelper = createNode();
                e.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(e);
                lastEdge = e;
            } else {
                previousNodeHelper.addOutgoingEdge(e);
                e.AddStartNode(previousNodeHelper);
                Node n = createNode();
                e.AddEndNode(n);
                n.addIncomingEdge(e);
                previousNodeHelper = n;
                lastEdge = e;
            }
        }
        if(statement instanceof WriteStatement){
            Edge e = new Edge((WriteStatement) statement);
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(e);
                e.AddStartNode(parentNode);
                previousNodeHelper = createNode();
                e.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(e);
                lastEdge = e;
            } else {
                previousNodeHelper.addOutgoingEdge(e);
                e.AddStartNode(previousNodeHelper);
                Node n = createNode();
                e.AddEndNode(n);
                n.addIncomingEdge(e);
                previousNodeHelper = n;
                lastEdge = e;
            }
        }
        if(statement instanceof DeclarationStatement){
            Edge e = new Edge((DeclarationStatement) statement);
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(e);
                e.AddStartNode(parentNode);
                previousNodeHelper = createNode();
                e.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(e);
                lastEdge = e;
            } else {
                previousNodeHelper.addOutgoingEdge(e);
                e.AddStartNode(previousNodeHelper);
                Node n = createNode();
                e.AddEndNode(n);
                n.addIncomingEdge(e);
                previousNodeHelper = n;
                lastEdge = e;
            }
        }
        if(statement instanceof IfElseStatement) {
            Edge edgeIf = new Edge(((IfElseStatement) statement).getCondition());
            Node parentIfElseNode = null;
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(edgeIf);
                edgeIf.AddStartNode(parentNode);
                parentIfElseNode = parentNode;
                previousNodeHelper = createNode();
                edgeIf.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(edgeIf);
            } else {
                previousNodeHelper.addOutgoingEdge(edgeIf);
                edgeIf.AddStartNode(previousNodeHelper);
                parentIfElseNode = previousNodeHelper;
                Node n = createNode();
                edgeIf.AddEndNode(n);
                n.addIncomingEdge(edgeIf);
                previousNodeHelper = n;
            }
            // body for if
            TreeToGraph(((IfElseStatement) statement).getBodyIf());
            // save last edge, connectionNode
            Node connectionNode = previousNodeHelper;
            //else
            Edge edgeElse = new Edge(new NotExpression(((IfElseStatement) statement).getCondition()));
            parentIfElseNode.addOutgoingEdge(edgeElse);
            edgeElse.AddStartNode(parentIfElseNode);
            Node n = createNode();
            n.addIncomingEdge(edgeElse);
            edgeElse.AddEndNode(n);
            previousNodeHelper = n;
            // body for else
            TreeToGraph(((IfElseStatement) statement).getBodyElse());
            lastEdge.AddEndNode(connectionNode);
            connectionNode.addIncomingEdge(lastEdge);
            graph.Nodes.remove(previousNodeHelper);
            previousNodeHelper = connectionNode;
            counter--;
        }
        if(statement instanceof IfStatement){
            Edge edgeIf = new Edge(((IfStatement) statement).getCondition());
            Node parentIfNode = null;
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(edgeIf);
                edgeIf.AddStartNode(parentNode);
                parentIfNode = parentNode;
                previousNodeHelper = createNode();
                edgeIf.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(edgeIf);
            } else {
                previousNodeHelper.addOutgoingEdge(edgeIf);
                edgeIf.AddStartNode(previousNodeHelper);
                parentIfNode = previousNodeHelper;
                Node n = createNode();
                edgeIf.AddEndNode(n);
                n.addIncomingEdge(edgeIf);
                previousNodeHelper = n;
            }
            // body for if
            TreeToGraph(((IfStatement) statement).getBody());
            Edge edgeElse = new Edge(new NotExpression(((IfStatement) statement).getCondition()));
            parentIfNode.addOutgoingEdge(edgeElse);
            edgeElse.AddStartNode(parentIfNode);
            edgeElse.AddEndNode(previousNodeHelper);
            previousNodeHelper.addIncomingEdge(edgeElse);
            lastEdge = edgeElse;
        }
        if(statement instanceof WhileStatement){
            Edge edge = new Edge(((WhileStatement) statement).getCondition());
            Edge negEdge = new Edge(new NotExpression(((WhileStatement) statement).getCondition()));
            Node parentWhileNode = null;
            if(graph.Nodes.size() == 0){
                Node parentNode = createNode();
                parentNode.addOutgoingEdge(edge);
                edge.AddStartNode(parentNode);
                parentWhileNode = parentNode;
                previousNodeHelper = createNode();
                edge.AddEndNode(previousNodeHelper);
                previousNodeHelper.addIncomingEdge(edge);
            } else {
                previousNodeHelper.addOutgoingEdge(edge);
                edge.AddStartNode(previousNodeHelper);
                parentWhileNode = previousNodeHelper;
                Node n = createNode();
                edge.AddEndNode(n);
                n.addIncomingEdge(edge);
                previousNodeHelper = n;
            }
            // body for while
            lastEdge = edge;
            TreeToGraph(((WhileStatement) statement).getBody());
            lastEdge.AddEndNode(parentWhileNode);
            parentWhileNode.addIncomingEdge(lastEdge);
            graph.Nodes.remove(previousNodeHelper);
            counter--;
            previousNodeHelper = parentWhileNode;
            //second branch of while that i forgot
            Node nn = createNode();
            previousNodeHelper.addOutgoingEdge(negEdge);
            nn.addIncomingEdge(negEdge);
            negEdge.AddStartNode(previousNodeHelper);
            negEdge.AddEndNode(nn);
        }
    }


    public Node createNode(){
        Node toReturn = new Node("q"+counter);
        counter++;
        graph.Nodes.add(toReturn);
        return toReturn;
    }

}
