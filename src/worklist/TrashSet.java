package worklist;

import Analysis.Analysis;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class TrashSet {
    public abstract ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A);

}
