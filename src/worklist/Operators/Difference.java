package worklist.Operators;

import Graph.Constant;
import worklist.AnalysisDomainElement;
import worklist.ConstantSet;
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

    public ConstantSet resolve() // TO IMPROVE (handle other cases than just constant sets
    {
        ArrayList<AnalysisDomainElement> result = new ArrayList<>();
        if (leftHandSide instanceof ConstantSet && rightHandSide instanceof ConstantSet)
        {

            for (AnalysisDomainElement element : ((ConstantSet)leftHandSide).getElements())
            {
                if (!((ConstantSet) rightHandSide).getElements().contains(element))
                {
                    result.add(element);
                }
            }
            return  new ConstantSet(result);
        }
        return null;
    }
}

