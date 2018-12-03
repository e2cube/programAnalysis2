package worklist.Operators;

import worklist.AnalysisDomainElement;
import worklist.TrashSet;

import java.util.ArrayList;
import java.util.HashMap;

public class Operator extends TrashSet {
    protected TrashSet leftHandSide;

    protected TrashSet rightHandSide;

    public TrashSet getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(TrashSet leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public TrashSet getRightHandSide() {
        return rightHandSide;
    }

    public void setRightHandSide(TrashSet rightHandSide) {
        this.rightHandSide = rightHandSide;
    }


    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {
        System.out.println("Called evaluate on op");
        return null;
    }

}
