package worklist;


import worklist.Operators.Operator;
import worklist.Operators.Union;

public class Constraint {

    private ConstraintSet leftHandSide;

    private ConstraintSet rightHandSide;

    private boolean overEstimation;

    public ConstraintSet getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(ConstraintSet leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public ConstraintSet getRightHandSide() {
        return rightHandSide;
    }

    public void setRightHandSide(ConstraintSet rightHandSide) {
        this.rightHandSide = rightHandSide;
    }

    public boolean isOverEstimation() {
        return overEstimation;
    }

    public void setOverEstimation(boolean overEstimation) {
        this.overEstimation = overEstimation;
    }


}
