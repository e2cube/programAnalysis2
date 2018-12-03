package Graph;

import worklist.*;
import worklist.AnalysisDomain.DVElement;
import worklist.Operators.Difference;
import worklist.Operators.Union;

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
    public ConstantSet kill_DangerousVariables() {
        return new ConstantSet(new ArrayList<>());
    }

    @Override
    public ConstantSet gen_DangerousVariables(ConstantSet previous_DV) {
        return new ConstantSet(new ArrayList<>());
    }

    /*
    @Override
    public Constraint DangerousVariablesGenerateConstraint(int id, TrashSet previous_DV, String next_node_name) {
        Difference difference = new Difference(previous_DV, this.kill_DangerousVariables());
        Union union = new Union(difference, this.gen_DangerousVariables(previous_DV));

        Constraint constraint = new Constraint(id, new VariableSet("A("+next_node_name+")"), union, true);

        return constraint;
    }*/

    @Override
    public ArrayList<AnalysisDomainElement> evaluate_Dangerous_Variables(ConstantSet previous_DV) {
        Difference difference = new Difference(previous_DV, this.kill_DangerousVariables());
        Union union = new Union(difference.resolve(), this.gen_DangerousVariables(previous_DV));

        ConstantSet result = union.resolve();

        return result.getElements();
    }

    @Override
    public ArrayList<String> DetectVariableNames() {
        ArrayList<String> names = new ArrayList<>();

        names.add(this.variable.getName());

        return names;
    }

    @Override
    public Constraint DangerousVariablesF(int id, TrashSet info, String next_node_name) {

        //Create detection signs function with this statement using info.
        FunctionDangerousVariables functionDangerousVariables = new FunctionDangerousVariables(this, info);
        VariableSet variableSet = new VariableSet("A("+next_node_name+")");
        Constraint constraint = new Constraint(id, variableSet,functionDangerousVariables, true);

        return constraint;
    }

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}
