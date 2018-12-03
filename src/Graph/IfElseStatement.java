package Graph;

import worklist.*;
import worklist.AnalysisDomain.DVElement;

import java.util.ArrayList;

public class IfElseStatement extends Statement {
    private Expression condition;
    private Sequence bodyIf;
    private Sequence bodyElse;

    public IfElseStatement(Expression condition, Sequence bodyIf, Sequence bodyElse) {
        this.condition = condition;
        this.bodyIf = bodyIf;
        this.bodyElse = bodyElse;
    }

    public Sequence getBodyIf(){
        return this.bodyIf;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        condition = condition;
    }

    public Sequence getBodyif() {
        return bodyIf;
    }

    public void setBodyif(Sequence bodyif) {
        this.bodyIf = bodyif;
    }

    public Sequence getBodyElse() {
        return bodyElse;
    }

    public void setBodyElse(Sequence bodyElse) {
        this.bodyElse = bodyElse;
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

    @Override
    public Constraint DangerousVariablesF(int id, TrashSet info, String next_node_name) {
        return null;
    }

    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}