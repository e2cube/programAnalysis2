package worklist;

public class Constraint {


    private int id;

    private VariableSet leftHandSide;

    private TrashSet rightHandSide;

    private boolean overEstimation;

    public boolean isOverEstimation() {
        return overEstimation;
    }

    public void setOverEstimation(boolean overEstimation) {
        this.overEstimation = overEstimation;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
