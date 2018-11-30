package worklist;


import com.company.Variable;
import worklist.Operators.Difference;
import worklist.Operators.Operator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WorklistAlgorithm {

    private HashMap<String, ArrayList<AnalysisDomainElement>> A = new HashMap<>();

    public HashMap<String, ArrayList<AnalysisDomainElement>> fifo(LinkedList<Constraint> givenConstraints) {

        Worklist worklist = new Worklist(givenConstraints);

        //HashMap<String, ArrayList<VariableSet>> infl = worklist.CreateInfluence();
        HashMap<String, ArrayList<AnalysisDomainElement>> A;

        Constraint c = givenConstraints.getFirst();

        //A.put(c.getLeftHandSide().getName(), evaluateConstraint(c.getRightHandSide()));

        return null;
    }
/*
    public ArrayList<AnalysisDomainElement> evaluateConstraint(TrashSet trashSet){
        ArrayList<AnalysisDomainElement> elements = new ArrayList<>();

        if (trashSet instanceof ConstantSet) {
            //Return the elements from the set of constants
            return ((ConstantSet) trashSet).elements;
        } else if (trashSet instanceof VariableSet) {
            //Get the elements from the analysis array
            return A.get(((VariableSet) trashSet).getName());
        } else if (trashSet instanceof Operator) {

            return Difference(evaluateConstraint(operator.lefthand), evaluateConstraint(operator.righthand));

            ArrayList<VariableSet> detectedLeft = DetectVariableSets(((Operator) trashSet).getLeftHandSide());

            //right
            ArrayList<VariableSet> detectedRight = DetectVariableSets(((Operator) trashSet).getRightHandSide());
        }
    }
*/
}
