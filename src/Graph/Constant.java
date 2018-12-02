package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.TrashSet;

import java.util.ArrayList;

public class Constant extends Expression {
    private int integer;

    public Constant(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    @Override
    public TrashSet kill_DangerousVariables() {
        return new ConstantSet(new ArrayList<>());
    }

    @Override
    public ArrayList<String> DetectVariableNames() {
        return null;
    }

    @Override
    public TrashSet gen_DangerousVariables(ConstantSet previous_DV) {
        return new ConstantSet(new ArrayList<>());
    }

    @Override
    public Constraint GenerateConstraint(int id, ConstantSet previous_DV, String previous_node_name) {
        return null;
    }
}
