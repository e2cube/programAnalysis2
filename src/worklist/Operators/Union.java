package worklist.Operators;

import worklist.AnalysisDomainElement;
import worklist.ConstantSet;
import worklist.TrashSet;

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

    public Union(TrashSet lhs, TrashSet rhs) {
    this.setLeftHandSide(lhs);
    this.setRightHandSide(rhs);
    }

    public ConstantSet resolve() // TO IMPROVE (handle other cases than just constant sets
    {
        ArrayList<AnalysisDomainElement> result = new ArrayList<>();
        if (leftHandSide instanceof ConstantSet && rightHandSide instanceof ConstantSet)
        {
            result.addAll(((ConstantSet)leftHandSide).getElements());
            for (AnalysisDomainElement element : ((ConstantSet)rightHandSide).getElements())
            {
                if (!result.contains(element))
                {
                    result.add(element);
                }
            }
            return  new ConstantSet(result);
        }
        return null;
    }
}

