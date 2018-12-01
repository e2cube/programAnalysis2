package worklist.Operators;

import worklist.AnalysisDomainElement;
import worklist.TrashSet;

import java.util.ArrayList;
import java.util.HashMap;

public class Difference extends Operator {
    public ArrayList<AnalysisDomainElement> result(AnalysisDomainElement a, AnalysisDomainElement element){return null;}

    public Difference(TrashSet left, TrashSet right) {
        this.leftHandSide = left;
        this.rightHandSide = right;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        ArrayList<AnalysisDomainElement> lhs = this.leftHandSide.evaluate(A);
        ArrayList<AnalysisDomainElement> rhs = this.rightHandSide.evaluate(A);

        ArrayList<AnalysisDomainElement> result = new ArrayList<>();
    for (AnalysisDomainElement e : lhs) {
        if(!rhs.contains(e)) {
            result.add(e);
        }
    }
        return result;
    }
}

