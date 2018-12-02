package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.Operators.Difference;
import worklist.Operators.Union;
import worklist.TrashSet;
import worklist.VariableSet;

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
    public TrashSet kill_DangerousVariables() {
        return negExpression.kill_DangerousVariables();
    }

    @Override
    public TrashSet gen_DangerousVariables(ConstantSet previous_DV) {
        return negExpression.gen_DangerousVariables(previous_DV);
    }

    @Override
    public Constraint GenerateConstraint(int id, ConstantSet previous_DV, String next_node_name) {
        Difference difference = new Difference(previous_DV, this.kill_DangerousVariables());
        Union union = new Union(difference, this.gen_DangerousVariables(previous_DV));

        Constraint constraint = new Constraint(id, new VariableSet("A("+next_node_name+")"), union, true);

        return constraint;
    }

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}
