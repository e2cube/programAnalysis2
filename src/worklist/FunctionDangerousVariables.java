package worklist;

import Graph.Label;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionDangerousVariables extends TrashSet {
    private Label label; //Different results of the evaluate function depending on label's type
    private TrashSet argument; //The previous informations, given, to evaluate

    public FunctionDangerousVariables(Label label, TrashSet argument) {
        this.label = label;
        this.argument = argument;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        ArrayList<AnalysisDomainElement> evaluated_argument = argument.evaluate(A);

        return label.evaluate_Dangerous_Variables(new ConstantSet(evaluated_argument));
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TrashSet getArgument() {
        return argument;
    }

    public void setArgument(TrashSet argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "Function Dangerous Variables "+((VariableSet)argument).getName();
    }
}


