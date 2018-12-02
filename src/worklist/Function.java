package worklist;

import com.company.Label;
import worklist.AnalysisDomain.DSAElement;

import java.util.ArrayList;
import java.util.HashMap;

public class Function extends TrashSet {
    private Label label;
    private TrashSet arguments;

    public Function(Label label, TrashSet arguments) {
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


