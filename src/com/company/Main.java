package com.company;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import worklist.*;
import worklist.AnalysisDomain.DSElement;
import worklist.Operators.Difference;
import worklist.Operators.Union;

import java.util.ArrayList;
import java.util.HashMap;

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

        Union un = new Union(cs,cs2);

        VariableSet vs = new VariableSet("test");
        Constraint c1 = new Constraint(1,vs, un, true);

        HashMap<String,ArrayList<AnalysisDomainElement>> t = new HashMap<>();

        t.put("test", temp2);

        ArrayList<AnalysisDomainElement> te = c1.getRightHandSide().evaluate(t);

        for(AnalysisDomainElement tmp_a : te)
        {
            System.out.println(((DSElement) tmp_a).getName());
        }


        //test_DetectVariableSets();
        //test_CreateInfluence();
        test_ReverseIteration();
        test_WorkList();
        System.out.println("END");


    }

    public static void test_ReverseIteration()
    {
        System.out.println("TEST ReverseIteration");

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
        DSElement index62 = new DSElement("(6,2,index)");
        ArrayList<AnalysisDomainElement> elements_constantset2 = new ArrayList<>();
        elements_constantset2.add(indexI0);
        elements_constantset2.add(index01);
        elements_constantset2.add(index62);
        ConstantSet constant2 = new ConstantSet(elements_constantset2);

        ArrayList<AnalysisDomainElement> elements_constantset3 = new ArrayList<>();
        elements_constantset3.add(index01);
        ConstantSet constant3 = new ConstantSet(elements_constantset3);

        Difference difference1 = new Difference(x0, constant2);
        Union union1 = new Union(difference1, constant3);

        VariableSet x1 = new VariableSet("x1");

        Constraint constraint2 = new Constraint(2, x1, union1, true);

        //Constraint 3
        DSElement array12 = new DSElement("(1,2,array)");
        DSElement array46 = new DSElement("(4,6,array)");
        DSElement array56 = new DSElement("(5,6,array)");
        ArrayList<AnalysisDomainElement> elements_constantset4 = new ArrayList<>();
        elements_constantset4.add(arrayI0);
        elements_constantset4.add(array12);
        elements_constantset4.add(array46);
        elements_constantset4.add(array56);

        ConstantSet constant4 = new ConstantSet(elements_constantset4);

        Difference difference2 = new Difference(x1,constant4);

        ArrayList<AnalysisDomainElement> elements_constantset5 = new ArrayList<>();
        elements_constantset5.add(array12);
        ConstantSet constant5 = new ConstantSet(elements_constantset5);

        Union union2 = new Union(difference2,constant5);

        VariableSet x2 = new VariableSet("x2");
        Constraint constraint3 = new Constraint(3, x2 , union2,true );

        //Constraint 4

        VariableSet x6 = new VariableSet("x6");

        ArrayList<AnalysisDomainElement> elements_constantset6 = new ArrayList<>();
        elements_constantset6.add(index62);
        ConstantSet constant6 = new ConstantSet(elements_constantset6);

        Difference difference3 = new Difference(x6,constant2);

        Union union3 = new Union(difference3,constant6);

        Constraint constraint4 = new Constraint(4,x2,union3,true);

        //Constraint 5

        VariableSet x3 = new VariableSet("x3");

        Constraint constraint5 = new Constraint(5, x3, x2,true);

        //Constraint 6

        VariableSet x4 = new VariableSet("x4");

        Constraint constraint6 = new Constraint(6,x4,x3,true);

        //Constraint 7

        VariableSet x5 = new VariableSet("x5");

        Constraint constraint7 = new Constraint(7, x5, x3, true);

        //Constraint 8

        Difference difference4 = new Difference(x4,constant4);

        ArrayList<AnalysisDomainElement> elements_constantset7 = new ArrayList<>();
        elements_constantset7.add(array46);
        ConstantSet constant7 = new ConstantSet(elements_constantset7);

        Union union4 = new Union(difference4,constant7);

        Constraint constraint8 = new Constraint(8,x6,union4,true);

        //Constraint 9

        Difference difference5 = new Difference(x5,constant4);

        ArrayList<AnalysisDomainElement> elements_constantset8 = new ArrayList<>();
        elements_constantset7.add(array56);
        ConstantSet constant8 = new ConstantSet(elements_constantset7);

        Union union5 = new Union(difference5,constant8);

        Constraint constraint9 = new Constraint(9, x6, union5, true);

        //Constraint 10

        VariableSet x7 = new VariableSet("x7");

        Constraint constraint10 = new Constraint(10,x7,x2,true);


        given_constraints.add(constraint1);
        given_constraints.add(constraint2);
        given_constraints.add(constraint3);
        given_constraints.add(constraint4);
        given_constraints.add(constraint5);
        given_constraints.add(constraint6);
        given_constraints.add(constraint7);
        given_constraints.add(constraint8);
        given_constraints.add(constraint9);
        given_constraints.add(constraint10);


        WorklistAlgorithm wa = new WorklistAlgorithm();
        HashMap<String, ArrayList<AnalysisDomainElement>> A_table = wa.ReversePostOrderIteration(given_constraints);
        
    }

    public static void test_WorkList(){

        System.out.println("TEST Worklist");

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
        DSElement index62 = new DSElement("(6,2,index)");
        ArrayList<AnalysisDomainElement> elements_constantset2 = new ArrayList<>();
        elements_constantset2.add(indexI0);
        elements_constantset2.add(index01);
        elements_constantset2.add(index62);
        ConstantSet constant2 = new ConstantSet(elements_constantset2);

        ArrayList<AnalysisDomainElement> elements_constantset3 = new ArrayList<>();
        elements_constantset3.add(index01);
        ConstantSet constant3 = new ConstantSet(elements_constantset3);

        Difference difference1 = new Difference(x0, constant2);
        Union union1 = new Union(difference1, constant3);

        VariableSet x1 = new VariableSet("x1");

        Constraint constraint2 = new Constraint(2, x1, union1, true);

        //Constraint 3
        DSElement array12 = new DSElement("(1,2,array)");
        DSElement array46 = new DSElement("(4,6,array)");
        DSElement array56 = new DSElement("(5,6,array)");
        ArrayList<AnalysisDomainElement> elements_constantset4 = new ArrayList<>();
        elements_constantset4.add(arrayI0);
        elements_constantset4.add(array12);
        elements_constantset4.add(array46);
        elements_constantset4.add(array56);

        ConstantSet constant4 = new ConstantSet(elements_constantset4);

        Difference difference2 = new Difference(x1,constant4);

        ArrayList<AnalysisDomainElement> elements_constantset5 = new ArrayList<>();
        elements_constantset5.add(array12);
        ConstantSet constant5 = new ConstantSet(elements_constantset5);

        Union union2 = new Union(difference2,constant5);

        VariableSet x2 = new VariableSet("x2");
        Constraint constraint3 = new Constraint(2, x2 , union2,true );

        //Constraint 4

        VariableSet x6 = new VariableSet("x6");

        ArrayList<AnalysisDomainElement> elements_constantset6 = new ArrayList<>();
        elements_constantset6.add(index62);
        ConstantSet constant6 = new ConstantSet(elements_constantset6);

        Difference difference3 = new Difference(x6,constant2);

        Union union3 = new Union(difference3,constant6);

        Constraint constraint4 = new Constraint(4,x2,union3,true);

        //Constraint 5

        VariableSet x3 = new VariableSet("x3");

        Constraint constraint5 = new Constraint(5, x3, x2,true);

        //Constraint 6

        VariableSet x4 = new VariableSet("x4");

        Constraint constraint6 = new Constraint(6,x4,x3,true);

        //Constraint 7

        VariableSet x5 = new VariableSet("x5");

        Constraint constraint7 = new Constraint(7, x5, x3, true);

        //Constraint 8

        Difference difference4 = new Difference(x4,constant4);

        ArrayList<AnalysisDomainElement> elements_constantset7 = new ArrayList<>();
        elements_constantset7.add(array46);
        ConstantSet constant7 = new ConstantSet(elements_constantset7);

        Union union4 = new Union(difference4,constant7);

        Constraint constraint8 = new Constraint(8,x6,union4,true);

        //Constraint 9

        Difference difference5 = new Difference(x5,constant4);

        ArrayList<AnalysisDomainElement> elements_constantset8 = new ArrayList<>();
        elements_constantset7.add(array56);
        ConstantSet constant8 = new ConstantSet(elements_constantset7);

        Union union5 = new Union(difference5,constant8);

        Constraint constraint9 = new Constraint(9, x6, union5, true);

        //Constraint 10

        VariableSet x7 = new VariableSet("x7");

        Constraint constraint10 = new Constraint(10,x7,x2,true);


        given_constraints.add(constraint1);
        given_constraints.add(constraint2);
        given_constraints.add(constraint3);
        given_constraints.add(constraint4);
        given_constraints.add(constraint5);
        given_constraints.add(constraint6);
        given_constraints.add(constraint7);
        given_constraints.add(constraint8);
        given_constraints.add(constraint9);
        given_constraints.add(constraint10);


        WorklistAlgorithm wa = new WorklistAlgorithm();
        wa.fifo(given_constraints);

        wa.lifo(given_constraints);


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
        Union union1 = new Union(constant1,constant2);

        //Creating a variable set
        VariableSet variableSet = new VariableSet("variable1");

        //Final union
        Union union2 = new Union(variableSet,union1);

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
        ConstantSet constant3 = new ConstantSet(elements_constantset3);

        Difference difference1 = new Difference(x0, constant2);
        Union union1 = new Union(difference1, constant3);

        VariableSet x1 = new VariableSet("x1");

        Constraint constraint2 = new Constraint(2, x1, union1, true);

        //Put all constraints in given_constraints
        given_constraints.add(constraint2);
        given_constraints.add(constraint1);

        //CREATE WORKLIST
        Worklist worklist = new Worklist(given_constraints);

        HashMap<Integer, ArrayList<Integer>> influences = worklist.CreateInfluence();

        System.out.println("Influences : "+influences);

        int root = worklist.RootConstraint(influences);

        System.out.println("root : "+ root);

        System.out.println("Worklist before reverse post order");
        for (Constraint c : worklist.getConstraints())
        {
            System.out.println(c.getId());
        }

        ArrayList<Constraint> new_constraints = worklist.ReversePostOrder(influences);
        worklist.getConstraints().clear();
        worklist.getConstraints().addAll(new_constraints);

        System.out.println("Worklist after reverse post order");
        for (Constraint c : worklist.getConstraints())
        {
            System.out.println(c.getId());
        }


    }

}