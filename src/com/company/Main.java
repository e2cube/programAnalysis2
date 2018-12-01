package com.company;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import worklist.*;
import worklist.AnalysisDomain.DSElement;
import worklist.Operators.Union;

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
        temp2.add(ad);
        temp2.add(ad2);

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

        for(AnalysisDomainElement tmp_a : te)
        {
            System.out.println(((DSElement) tmp_a).getName());
        }

        test_DetectVariableSets();


    }

    public static void test_DetectVariableSets()
    {
        System.out.println("TEST DetectVariableSets");
        //Testing DetectVariableSets(trashset)
        //Creating a first constant set for the operator
        DSElement element1 = new DSElement("{+,-,0}");
        DSElement element2 = new DSElement("{0,+,-}");

        ArrayList<AnalysisDomainElement> lhs_list_elements = new ArrayList<>();
        lhs_list_elements.add(element1);
        lhs_list_elements.add(element2);
        ConstantSet constant1 = new ConstantSet(lhs_list_elements);

        //Creating a second constant set for the operator
        DSElement element3 = new DSElement("{+,0}");
        DSElement element4 = new DSElement("{0,+}");

        ArrayList<AnalysisDomainElement> rhs_list_elements = new ArrayList<>();
        rhs_list_elements.add(element3);
        rhs_list_elements.add(element4);
        ConstantSet constant2 = new ConstantSet(rhs_list_elements);

        //Creating a first union
        Union union1 = new Union();
        union1.setLeftHandSide(constant1);
        union1.setRightHandSide(constant2);

        //Creating a variable set
        VariableSet variableSet = new VariableSet("variable1");

        //Final union
        Union union2 = new Union();
        union2.setLeftHandSide(variableSet);
        union2.setRightHandSide(union1);

        //Detect the variable sets in this union
        ArrayList<VariableSet> detected = Worklist.DetectVariableSets(union2);

        for (VariableSet tmp_variable : detected)
        {
            System.out.println(tmp_variable.getName());
        }

    }

    public static void  test_CreateInfluence()
    {
        //TESTING CREATE INFLUENCES
        System.out.println("TEST CreateInfluence");

        ArrayList<Constraint> given_constraints = new ArrayList<>();

        //index ? 0, array ?, 0 is x0
        DSElement indexI0 = new DSElement("(?,0,index)");
        DSElement arrayI0 = new DSElement("(?,0,array)");
        ArrayList<AnalysisDomainElement> elements_constantset1 = new ArrayList<>();
        elements_constantset1.add(indexI0);
        elements_constantset1.add(arrayI0);
        ConstantSet constant1 = new ConstantSet(elements_constantset1);
        VariableSet x0 = new VariableSet("x0");

        Constraint constraint1 = new Constraint(1, x0, constant1, true);

        //x0 minus index ?0, 01, 62 union index01 is x1
        DSElement index01 = new DSElement("(0,1,index)");
        DSElement index62 = new DSElement("(0,1,index)");
        ArrayList<AnalysisDomainElement> elements_constantset2 = new ArrayList<>();
        elements_constantset2.add(indexI0);
        elements_constantset2.add(index01);
        elements_constantset2.add(index62);
        ConstantSet constant2 = new ConstantSet(elements_constantset2);

        ArrayList<AnalysisDomainElement> elements_constantset3 = new ArrayList<>();
        elements_constantset3.add(index01);

        VariableSet x1 = new VariableSet("x1");

        





    }

}