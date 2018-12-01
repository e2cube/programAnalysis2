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

        //Initialize objects
        Worklist worklist = new Worklist(givenConstraints);
        HashMap<Integer, ArrayList<Integer>> infl = worklist.CreateInfluence();


        //While the worklist isn't empty.
        while (!worklist.getConstraints().isEmpty()){
            Constraint c = worklist.getConstraints().get(0);
            worklist.getConstraints().remove(0);

            //ArrayList in the Analysis hashmap
            ArrayList<AnalysisDomainElement> currentList = A.get(c.getLeftHandSide().getName());

            //ArrayList from evaluating the righthandside of the constraint
            ArrayList<AnalysisDomainElement> result = c.getRightHandSide().evaluate(A);

            //Union the two arraylists if it already has a list.
            boolean isChanged = false;
            if (currentList != null){
                for(AnalysisDomainElement el : result){
                    if (!currentList.contains(el)){
                        isChanged = true;
                        currentList.add(el);
                    }
                }
            }
            else {
                A.put(c.getLeftHandSide().getName() , result);
                isChanged = true;
            }

            if (isChanged){
                //Get the ids that should be added
                ArrayList<Integer> idsToAdd = infl.get(c.getId());
                //Add the constraints to the worklist
                if (idsToAdd != null){
                    for (Integer id : idsToAdd){
                        worklist.getConstraints().add(0,worklist.getMapConstraints().get(id));
                    }
                }
            }
        }

        System.out.println(A);
        return null;
    }
}
