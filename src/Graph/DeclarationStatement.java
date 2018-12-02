package Graph;

import worklist.*;
import worklist.AnalysisDomain.DVElement;
import worklist.Operators.Difference;
import worklist.Operators.Union;

import java.util.ArrayList;

public class DeclarationStatement extends Statement {
    private String type;
    private Variable variable;

    public DeclarationStatement(String type, Variable variable) {
        this.type = type;
        this.variable = variable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public TrashSet kill_DangerousVariables() {
        ArrayList<AnalysisDomainElement> kill_set = new ArrayList<>();

        kill_set.add(new DVElement(variable.getName()));
        return new ConstantSet(kill_set);
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
}