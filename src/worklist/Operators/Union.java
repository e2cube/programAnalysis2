package worklist.Operators;

import worklist.AnalysisDomainElement;

import java.util.ArrayList;
import java.util.HashMap;

public class Union extends Operator{

@Override
public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
    ArrayList<AnalysisDomainElement> lhs = this.leftHandSide.evaluate(A);
    ArrayList<AnalysisDomainElement> rhs = this.rightHandSide.evaluate(A);

    ArrayList<AnalysisDomainElement> result = new ArrayList<>(lhs);

    for (AnalysisDomainElement e : rhs) {
        if(!lhs.contains(e)) {
            result.add(e);
        }
    }

    return result;
}

    public Union() {
    }
}

