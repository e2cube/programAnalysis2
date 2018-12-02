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
}
