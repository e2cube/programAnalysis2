package worklist;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstantSet extends TrashSet {
    ArrayList<AnalysisDomainElement> elements;

    public ConstantSet(ArrayList<AnalysisDomainElement> elements) {
        this.elements = elements;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        return elements;
    }
}
