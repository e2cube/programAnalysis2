package worklist.Operators;

import worklist.AnalysisDomainElement;
import worklist.TrashSet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Difference extends Operator {
    public ArrayList<AnalysisDomainElement> result(AnalysisDomainElement a, AnalysisDomainElement element){return null;}

    public Difference(TrashSet left, TrashSet right) {
        this.leftHandSide = left;
        this.rightHandSide = right;
    }
}

