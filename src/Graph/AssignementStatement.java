package Graph;

import worklist.*;
import worklist.AnalysisDomain.DVElement;
import worklist.Operators.Difference;
import worklist.Operators.Union;

import java.util.ArrayList;

public class AssignementStatement extends Statement {
    private Variable leftHandSide;
    private Expression righthandSide;

    public AssignementStatement(Variable leftHandSide, Expression righthandSide) {
        this.leftHandSide = leftHandSide;
        this.righthandSide = righthandSide;
    }

    public Variable getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(Variable leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public Expression getRighthandSide() {
        return righthandSide;
    }

    public void setRighthandSide(Expression righthandSide) {
        this.righthandSide = righthandSide;
    }

    @Override
    public TrashSet kill_DangerousVariables() {
        ArrayList<AnalysisDomainElement> kill_set = new ArrayList<>();

        kill_set.add(new DVElement(leftHandSide.getName()));

        return new ConstantSet(kill_set);
    }


    public TrashSet gen_DangerousVariables(ConstantSet previous_DV) {
        ArrayList<AnalysisDomainElement> gen_set = new ArrayList<>();

        ArrayList<String> variables_in_rhs = righthandSide.DetectVariableNames();

        boolean dangerous=false;

        for (AnalysisDomainElement element : previous_DV.getElements())
        {
            for (String vs_name : variables_in_rhs)
            {
                if(element.getName().equals(vs_name))
                {
                    dangerous = true;
                    break;
                }

            }
        }
        if(dangerous)
        {
            gen_set.add(new DVElement(leftHandSide.getName()));
        }

        return new ConstantSet(gen_set);
    }

    @Override
    public Constraint GenerateConstraint(int id, ConstantSet previous_DV, String next_node_name) {
        Difference difference = new Difference(previous_DV, this.kill_DangerousVariables());
        Union union = new Union(difference, this.gen_DangerousVariables(previous_DV));

        Constraint constraint = new Constraint(id, new VariableSet("A("+next_node_name+")"), union, true);

        return constraint;
    }

    public Constraint DetectionSignsF(TrashSet info, String nodeName){

        Constraint c = new Constraint();
        //Create detection signs function with this statement using info.
        Function f = new Function(this, info);
        VariableSet vs = new VariableSet();

        //A(nodeName)
        vs.setName("A("+nodeName+")");

        c.setLeftHandSide(vs);
        c.setRightHandSide(f);
        return c;
    }

}