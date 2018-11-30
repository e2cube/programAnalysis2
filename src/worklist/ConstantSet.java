package worklist;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstantSet extends TrashSet {
    ArrayList<AnalysisDomainElement> elements;

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        return elements;
    }
}
