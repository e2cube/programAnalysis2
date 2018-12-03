package worklist;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstantSet extends TrashSet {
    private ArrayList<AnalysisDomainElement> elements;

    public ArrayList<AnalysisDomainElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<AnalysisDomainElement> elements) {
        this.elements = elements;
    }

    public ConstantSet(ArrayList<AnalysisDomainElement> elements) {
        this.elements = elements;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        return elements;
    }
}
