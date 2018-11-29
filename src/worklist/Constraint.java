package worklist;

public class Constraint {



    private VariableSet leftHandSide;

    private TrashSet rightHandSide;

    private boolean overEstimation;

    public boolean isOverEstimation() {
        return overEstimation;
    }

    public void setOverEstimation(boolean overEstimation) {
        this.overEstimation = overEstimation;
    }



    public VariableSet getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(VariableSet leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public TrashSet getRightHandSide() {
        return rightHandSide;
    }

    public void setRightHandSide(TrashSet rightHandSide) {
        this.rightHandSide = rightHandSide;
    }
}
