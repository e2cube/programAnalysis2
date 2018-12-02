package Graph;

import worklist.AnalysisDomain.DVElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.TrashSet;

import java.util.ArrayList;

import worklist.Constraint;
import worklist.TrashSet;

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
    @Override
    public Constraint DetectionSignsF(TrashSet info, String nodeName) {
        return null;
    }
}