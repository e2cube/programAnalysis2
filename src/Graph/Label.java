package Graph;

import worklist.ConstantSet;
import worklist.Constraint;
import worklist.TrashSet;


public abstract class Label {

    public abstract Constraint DetectionSignsF(TrashSet info, String nodeName);
    public abstract TrashSet kill_DangerousVariables();
    public abstract TrashSet gen_DangerousVariables(ConstantSet previous_DV);

    public abstract Constraint GenerateConstraint(int id, ConstantSet previous_DV, String previous_node_name);
}