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
    public ConstantSet kill_DangerousVariables() {
        ArrayList<AnalysisDomainElement> kill_set = new ArrayList<>();

        kill_set.add(new DVElement(variable.getName()));
        return new ConstantSet(kill_set);
    }

    @Override
    public ConstantSet gen_DangerousVariables(ConstantSet previous_DV) {
        return new ConstantSet(new ArrayList<>());
    }


    @Override
    public ArrayList<AnalysisDomainElement> evaluate_Dangerous_Variables(ConstantSet previous_DV) {
        Difference difference = new Difference(previous_DV, this.kill_DangerousVariables());
        Union union = new Union(difference.resolve(), this.gen_DangerousVariables(previous_DV));

        ConstantSet result = union.resolve();

        return result.getElements();
    }

    @Override
    public Constraint DangerousVariablesF(int id, TrashSet info, String next_node_name) {

        //Create detection signs function with this statement using info.
        FunctionDangerousVariables functionDangerousVariables = new FunctionDangerousVariables(this, info);
        VariableSet variableSet = new VariableSet("A("+next_node_name+")");
        Constraint constraint = new Constraint(id, variableSet,functionDangerousVariables, true);

        return constraint;
    }


    //TODO
    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName){
        Constraint c = new Constraint();
        //Create detection signs function with this statement using info.
        FunctionDetectionSigns f = new FunctionDetectionSigns(this, info);
        VariableSet vs = new VariableSet();

        //A(nodeName)
        vs.setName("A("+nodeName+")");

        c.setLeftHandSide(vs);
        c.setRightHandSide(f);
        return c;
    }

}