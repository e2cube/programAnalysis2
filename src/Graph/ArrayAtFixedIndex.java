package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.Operators.Difference;
import worklist.Operators.Union;
import worklist.TrashSet;
import worklist.VariableSet;

import java.util.ArrayList;

public class ArrayAtFixedIndex extends Variable {
    private SimpleVariable variable;
    private int index;

    public ArrayAtFixedIndex(SimpleVariable variable, int index) {
        this.variable = variable;
        this.index = index;
    }

    public SimpleVariable getVariable() {
        return variable;
    }

    public void setVariable(SimpleVariable variable) {
        this.variable = variable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return variable.getName();
    }

    @Override
    public TrashSet kill_DangerousVariables() {
        return new ConstantSet(new ArrayList<>());
    }

    @Override
    public TrashSet gen_DangerousVariables(ConstantSet previous_DV) {
        return new ConstantSet(new ArrayList<>());
    }

    @Override
    public Constraint GenerateConstraint(int id, ConstantSet previous_DV, String next_node_name) {
        Difference difference = new Difference(previous_DV, this.kill_DangerousVariables());
        Union union = new Union(difference, this.gen_DangerousVariables(previous_DV));

        Constraint constraint = new Constraint(id, new VariableSet("A("+next_node_name+")"), union, true);

        return constraint;
    }



    @Override
    public ArrayList<String> DetectVariableNames() {
        ArrayList<String> names = new ArrayList<>();

        names.add(this.variable.getName());

        return names;
    }

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}
