package worklist;

import worklist.Operators.Operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Worklist {

    private LinkedList<Constraint> constraints;
    private HashMap<Integer, Constraint> mapConstraints = new HashMap<>();

    public Worklist(LinkedList<Constraint> constraints){
        this.constraints = constraints;

        for (Constraint c:constraints) {
            mapConstraints.put(c.getId(),c);
        }
    }

    public HashMap<Integer, ArrayList<Integer>> CreateInfluence() {
        HashMap<Integer, ArrayList<Integer>> influences = new HashMap<>();
        ArrayList<Constraint>  notSolvedConstraints = new ArrayList<>();

        for (Constraint constraint : constraints) {
            ArrayList<VariableSet> vs_contained = DetectVariableSets(constraint.getRightHandSide());
            for(VariableSet vs : vs_contained)
            {
                for (Constraint tmp_constraint : constraints)
                {
                    if (tmp_constraint.getLeftHandSide().getName() == vs.getName())
                    {
                        ArrayList<Integer> tmp_list = influences.get(tmp_constraint.getId());
                        if(tmp_list == null)
                        {
                            tmp_list.add(constraint.getId());
                            influences.put(tmp_constraint.getId(), tmp_list);
                        }
                        else
                        {
                            tmp_list.add(constraint.getId());
                            influences.remove(tmp_constraint.getId());
                            influences.put(tmp_constraint.getId(),tmp_list);
                        }
                    }
                }
            }

        }


        return influences;
    }

    //Detects all the variable sets contained in a trash set (even the nested ones). Recursive.
    public ArrayList<VariableSet> DetectVariableSets(TrashSet trashSet) {
        ArrayList<VariableSet> detected = new ArrayList<>();

        if (trashSet instanceof ConstantSet) {
            //DO NOTHING
        } else if (trashSet instanceof VariableSet) {
            detected.add((VariableSet) trashSet);
        } else if (trashSet instanceof Operator) {
            //Left
            ArrayList<VariableSet> detectedLeft = DetectVariableSets(((Operator) trashSet).getLeftHandSide());

            //right
            ArrayList<VariableSet> detectedRight = DetectVariableSets(((Operator) trashSet).getRightHandSide());

            //Sum the 2 lists in detected
            detected.addAll(detectedLeft);
            for (VariableSet vs : detectedRight) {
                if (!detected.contains(vs)) {
                    detected.add(vs);
                }
            }

        }

        return detected;
    }


    public LinkedList<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(LinkedList<Constraint> constraints) {
        this.constraints = constraints;
    }

    public HashMap<Integer, Constraint> getMapConstraints() {
        return mapConstraints;
    }

    public void setMapConstraints(HashMap<Integer, Constraint> mapConstraints) {
        this.mapConstraints = mapConstraints;
    }



}
