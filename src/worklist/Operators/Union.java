package worklist.Operators;

import worklist.AnalysisDomainElement;

import java.util.ArrayList;
import java.util.HashMap;

public class Union extends Operator{

@Override
public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
    ArrayList<AnalysisDomainElement> lhs = this.leftHandSide.evaluate(A);
    ArrayList<AnalysisDomainElement> rhs = this.rightHandSide.evaluate(A);
/*
    for (AnalysisDomainElement e : rhs) {
        if(!lhs.contains(e)) {
            lhs.add(e);
        }
    }
*/
    lhs.addAll(rhs);
    return lhs;
}

    public Union() {
    }
}

