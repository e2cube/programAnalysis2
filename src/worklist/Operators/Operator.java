package worklist.Operators;

import worklist.TrashSet;

public class Operator extends TrashSet {
    private TrashSet leftHandSide;

    private TrashSet rightHandSide;

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
}
