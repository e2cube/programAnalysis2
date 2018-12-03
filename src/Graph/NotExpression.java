package Graph;

import worklist.*;
import worklist.AnalysisDomain.DVElement;
import worklist.Operators.Difference;
import worklist.Operators.Union;

import java.util.ArrayList;

public class NotExpression extends Expression {
    private Expression negExpression;

    public Expression getNegExpression() {
        return negExpression;
    }

    public void setNegExpression(Expression negExpression) {
        this.negExpression = negExpression;
    }

    public NotExpression(Expression negExpression) {
        this.negExpression = negExpression;
    }


    @Override
    public ArrayList<String> DetectVariableNames() {
        return negExpression.DetectVariableNames();
    }

    @Override
    public ConstantSet kill_DangerousVariables() {
        return negExpression.kill_DangerousVariables();
    }

    @Override
    public ConstantSet gen_DangerousVariables(ConstantSet previous_DV) {
        return negExpression.gen_DangerousVariables(previous_DV);
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
