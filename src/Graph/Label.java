package Graph;

import worklist.AnalysisDomainElement;
import worklist.ConstantSet;
import worklist.Constraint;
import worklist.TrashSet;

import java.util.ArrayList;


public abstract class Label {

    public abstract Constraint DetectionSignsF(TrashSet info, String nodeName);
    public abstract Constraint DangerousVariablesF(int id, TrashSet info, String next_node_name);

    public abstract ConstantSet kill_DangerousVariables();
    public abstract ConstantSet gen_DangerousVariables(ConstantSet previous_DV);
    public abstract ArrayList<AnalysisDomainElement> evaluate_Dangerous_Variables(ConstantSet previous_DV);

    //public abstract Constraint DangerousVariablesGenerateConstraint(int id, TrashSet previous_DV, String next_node_name);
}