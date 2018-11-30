package com.company;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import worklist.AnalysisDomain.DSElement;
import worklist.AnalysisDomainElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.Operators.Union;
import worklist.VariableSet;

import java.util.ArrayList;
import java.util.HashMap;

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


        //Testing the worklist algorithm.
        DSElement ade = new DSElement("{+,-,0}");
        DSElement ade2 = new DSElement("{0,+,-}");

        ArrayList<AnalysisDomainElement> temp = new ArrayList<>();
        temp.add(ade);
        temp.add(ade2);


        DSElement ad = new DSElement("{+,0}");
        DSElement ad2 = new DSElement("{0,+}");

        ArrayList<AnalysisDomainElement> temp2 = new ArrayList<>();
        temp2.add(ade);
        temp2.add(ade2);

        ConstantSet cs2 = new ConstantSet(temp2);

        ConstantSet cs = new ConstantSet(temp);

        Union un = new Union();
        un.setLeftHandSide(cs);
        un.setRightHandSide(cs2);

        VariableSet vs = new VariableSet("test");
        Constraint c1 = new Constraint(1,vs, un, true);

        HashMap<String,ArrayList<AnalysisDomainElement>> t = new HashMap<>();

        t.put("test", temp2);
       ArrayList<AnalysisDomainElement> te = c1.getRightHandSide().evaluate(t);

        System.out.println(te);
    }
}