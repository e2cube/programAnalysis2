package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.Operators.Difference;
import worklist.Operators.Union;
import worklist.TrashSet;
import worklist.VariableSet;

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


}