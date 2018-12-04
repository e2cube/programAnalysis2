package worklist;

import java.util.Objects;

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

    public Constraint(int id, VariableSet leftHandSide, TrashSet rightHandSide, boolean overEstimation) {
        this.id = id;
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.overEstimation = overEstimation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constraint that = (Constraint) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leftHandSide, rightHandSide, overEstimation);
    }

    public Constraint(){

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

    @Override
    public String toString() {
        String string_constraint;
        string_constraint = "Constraint "+id+" : LHS "+leftHandSide+", RHS "+rightHandSide;
        return string_constraint;
    }
}
