package Analysis;



import Graph.*;
import worklist.*;

import java.util.ArrayList;

public class AnalysisAlgorithm {

    private Graph program_graph;

    public AnalysisAlgorithm(Graph program_graph) {
        this.program_graph = program_graph;
    }



    public ArrayList<Constraint> DangerousVariablesAnalysis (TrashSet info)
    {
        ArrayList<Constraint> generated_constraints = new ArrayList<>();


        ArrayList<Edge> frontier = new ArrayList<>();
        ArrayList<Edge> expandedEdges = new ArrayList<>();

        //Initialize from the first node;
        Node startNode = program_graph.Nodes.get(0);
        VariableSet first_variable = new VariableSet("A("+startNode.getName()+")");
        Constraint init_constraint = new Constraint(0, first_variable, info, true);
        //System.out.println(init_constraint.toString()); //----------------
        generated_constraints.add(init_constraint);
        frontier.addAll(startNode.getOutgoingEdges());


        while (!frontier.isEmpty()){
            //Take first element and add to expandedNodes.
            Edge edge = frontier.get(0);
            frontier.remove(0);

            if (!expandedEdges.contains(edge))
            {
                expandedEdges.add(edge);

                VariableSet prevInfo = new VariableSet("A("+edge.GetStartNode().getName()+")");
                Constraint c = edge.label.DangerousVariablesF(generated_constraints.size(), prevInfo, edge.GetEndNode().getName());
                //System.out.println(c.toString()); //--------------
                generated_constraints.add(c);

                frontier.addAll(edge.GetEndNode().getOutgoingEdges());
            }
        }

        return generated_constraints;
    }

    public ArrayList<Constraint> DetectionSignsAnalysis (TrashSet info) {
        ArrayList<Constraint> generated_constraints = new ArrayList<>();

        ArrayList<Edge> frontier = new ArrayList<>();
        ArrayList<Edge> expandedEdges = new ArrayList<>();

        //Initialize from the first node;
        Node startNode = program_graph.Nodes.get(0);
        for (Edge edge : startNode.getOutgoingEdges()){
            frontier.addAll(edge.GetEndNode().getOutgoingEdges());
            Constraint c = edge.label.DetectionSignsF(info, startNode.getName());
            generated_constraints.add(c);
            expandedEdges.add(edge);
        }


        while (!frontier.isEmpty()){
            //Take first element and add to expandedNodes.
            Edge edge = frontier.get(0);
            frontier.remove(0);

            if (!expandedEdges.contains(edge)){
                expandedEdges.add(edge);

                VariableSet prevInfo = new VariableSet("A("+edge.GetStartNode().getName()+")");
                Constraint c = edge.label.DetectionSignsF(prevInfo, edge.GetEndNode().getName());
                generated_constraints.add(c);

                frontier.addAll(edge.GetEndNode().getOutgoingEdges());
            }
        }

        return generated_constraints;
    }
}
