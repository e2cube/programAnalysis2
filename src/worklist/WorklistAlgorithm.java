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

    public HashMap<String, ArrayList<AnalysisDomainElement>> fifo(ArrayList<Constraint> givenConstraints) {

        Worklist worklist = new Worklist(givenConstraints);

        HashMap<Integer, ArrayList<Integer>> infl = worklist.CreateInfluence();

        HashMap<Integer, Constraint> constraintsLookup = new HashMap<>();

        HashMap<String, ArrayList<AnalysisDomainElement>> A = new HashMap<>();

        //While the worklist isn't empty.
        while (!worklist.getConstraints().isEmpty()){
            Constraint c = worklist.getConstraints().get(0);

            //ArrayList in the Analysis hashmap
            ArrayList<AnalysisDomainElement> currentList = new ArrayList<>(A.get(c.getLeftHandSide().getName()));

            //ArrayList from evaluating the righthandside of the constraint
            ArrayList<AnalysisDomainElement> result = c.getRightHandSide().evaluate(A);

            //Union the two arraylists if it already has a list.
            Boolean isChanged = false;
            if (currentList != null){
                for(AnalysisDomainElement el : result){
                    if (!currentList.contains(el)){
                        isChanged = true;
                        currentList.add(el);
                    }
                }
            }
            else {
                A.put(c.getLeftHandSide().getName() , currentList);
            }

            if (isChanged){
                //Get the ids that should be added
                ArrayList<Integer> idsToAdd = infl.get(c.getId());

                //Add them to the worklist
                for (Integer id : idsToAdd){
                    worklist.getConstraints().add(0,constraintsLookup.get(id));
                }
            }
        }

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
