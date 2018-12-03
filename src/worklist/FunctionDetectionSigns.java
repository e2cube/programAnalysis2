package worklist;

import Graph.Label;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionDetectionSigns extends TrashSet {
    private Label label;
    private TrashSet arguments;

    public FunctionDetectionSigns(Label label, TrashSet arguments) {
        this.label = label;
        this.arguments = arguments;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        ArrayList<AnalysisDomainElement> a = arguments.evaluate(A);

        return null;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public TrashSet getArguments() {
        return arguments;
    }

    public void setArguments(TrashSet arguments) {
        this.arguments = arguments;
    }

}


