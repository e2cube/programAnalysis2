package worklist;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class WorklistAlgorithm {

    private HashMap<String, ArrayList<AnalysisDomainElement>> A = new HashMap<>();

    public HashMap<String, ArrayList<AnalysisDomainElement>> fifo(ArrayList<Constraint> givenConstraints) {

        A.clear();

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

    public HashMap<String, ArrayList<AnalysisDomainElement>> lifo(ArrayList<Constraint> givenConstraints) {

        A.clear();

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
                        worklist.getConstraints().add(worklist.getMapConstraints().get(id));
                    }
                }
            }
        }

        System.out.println(A);
        return null;
    }

    public HashMap<String, ArrayList<AnalysisDomainElement>> ReversePostOrderIteration(ArrayList<Constraint> givenConstraints)
    {

        A.clear(); //Just in case we already did an analysis using this WorklistAlgorithm object


        //Initialize objects
        Worklist pending_worklist = new Worklist(givenConstraints);
        HashMap<Integer, ArrayList<Integer>> influences = pending_worklist.CreateInfluence();

        Worklist current_worklist = new Worklist(givenConstraints);
        current_worklist.getConstraints().clear(); //We want to start with an empty current worklist

        ArrayList<Constraint> reverse_order = new ArrayList<>();

        reverse_order.addAll(pending_worklist.ReversePostOrder(influences));

        //While the pending and current worklists are not empty at the same time
        while (!(current_worklist.getConstraints().isEmpty() && pending_worklist.getConstraints().isEmpty())){

            if (current_worklist.getConstraints().isEmpty())
            {
                for (Constraint c : reverse_order)
                {
                    if (pending_worklist.getConstraints().contains(c))
                    {
                        current_worklist.getConstraints().add(c);
                    }
                }
                pending_worklist.getConstraints().clear();
            }
            System.out.println("dd");


            Constraint c = current_worklist.getConstraints().get(0);
            current_worklist.getConstraints().remove(0);

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
                ArrayList<Integer> idsToAdd = influences.get(c.getId());
                //Add the constraints to the pending worklist
                if (idsToAdd != null){
                    for (Integer id : idsToAdd){
                        if (!pending_worklist.getConstraints().contains(pending_worklist.getMapConstraints().get(id)))
                        {
                            pending_worklist.getConstraints().add(0,pending_worklist.getMapConstraints().get(id));
                        }
                    }
                }
            }
        }

        System.out.println(A);
        return A;
    }
}
