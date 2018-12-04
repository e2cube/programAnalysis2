package Graph;

import worklist.*;
import worklist.AnalysisDomain.DVElement;
import worklist.Operators.Difference;
import worklist.Operators.Union;

import java.util.ArrayList;

public class OperationExpression extends Expression {
    private Expression leftHandSide;
    private Expression rightHandSide;
    private String operator;

    public Expression getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(Expression leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public Expression getRightHandSide() {
        return rightHandSide;
    }

    public void setRightHandSide(Expression rightHandSide) {
        this.rightHandSide = rightHandSide;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OperationExpression(Expression leftHandSide, Expression rightHandSide, String operator) {
        this.leftHandSide = leftHandSide;
        this.rightHandSide = rightHandSide;
        this.operator = operator;
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
        names.addAll(leftHandSide.DetectVariableNames());
        ArrayList<String> tmp = rightHandSide.DetectVariableNames();
        for (String s : tmp)
        {
            if (!names.contains(s))
            {
                names.add(s);
            }
        }

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