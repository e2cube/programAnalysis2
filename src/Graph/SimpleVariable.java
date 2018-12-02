package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.Operators.Difference;
import worklist.Operators.Union;
import worklist.TrashSet;
import worklist.VariableSet;

import java.util.ArrayList;

public class SimpleVariable extends Variable {
    private String name;
    private int size;

    public SimpleVariable(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public SimpleVariable(String name) {
        this.name = name;
        this.size = 1;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        names.add(this.getName());

        return names;
    }

    //TODO
    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}
