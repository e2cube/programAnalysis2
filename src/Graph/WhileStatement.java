package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.AnalysisDomainElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.TrashSet;

import java.util.ArrayList;

public class WhileStatement extends Statement {
    private Expression condition;
    private Sequence body;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        condition = condition;
    }

    public Sequence getBody() {
        return body;
    }

    public void setBody(Sequence body) {
        body = body;
    }

    public WhileStatement(Expression condition, Sequence body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public ConstantSet kill_DangerousVariables() {
        return null;
    }

    @Override
    public ConstantSet gen_DangerousVariables(ConstantSet previous_DV) {
        return null;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate_Dangerous_Variables(ConstantSet previous_DV) {
        return null;
    }

    public Constraint DangerousVariablesF(int id, TrashSet info, String next_node_name) {
        return null;
    }

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}