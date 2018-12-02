package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.TrashSet;

import java.util.ArrayList;

public class IfStatement extends Statement {
    private Expression condition;
    private Sequence body;

    public IfStatement(Expression condition, Sequence body) {
        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }
    public Sequence getBody(){
        return body;
    }

    @Override
    public TrashSet kill_DangerousVariables() {
        return null;
    }

    @Override
    public TrashSet gen_DangerousVariables(ConstantSet previous_DV) {
        return null;
    }

    @Override
    public Constraint GenerateConstraint(int id, ConstantSet previous_DV, String previous_node_name) {
        return null;
    }
}