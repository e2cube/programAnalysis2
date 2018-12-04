package worklist;

import worklist.Operators.Operator;

import java.lang.reflect.Array;
import java.util.*;

public class Worklist {

    private ArrayList<Constraint> constraints;
    private HashMap<Integer, Constraint> mapConstraints = new HashMap<>();

    public Worklist(ArrayList<Constraint> constraints){
        this.constraints = new ArrayList<>(constraints);

        for (Constraint c:constraints) {
            mapConstraints.put(c.getId(),c);
        }
    }

    public HashMap<Integer, ArrayList<Integer>> CreateInfluence() {
        HashMap<Integer, ArrayList<Integer>> influences = new HashMap<>();

        for (Constraint constraint : constraints) {
            ArrayList<VariableSet> vs_contained = DetectVariableSets(constraint.getRightHandSide());
            for(VariableSet vs : vs_contained)
            {
                for (Constraint tmp_constraint : constraints)
                {
                    if (tmp_constraint.getLeftHandSide().getName().equals(vs.getName()))
                    {
                        ArrayList<Integer> tmp_list = influences.get(tmp_constraint.getId());
                        if(tmp_list == null)
                        {
                            tmp_list = new ArrayList<>();
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
    public static ArrayList<VariableSet> DetectVariableSets(TrashSet trashSet) {
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

        } else if (trashSet instanceof FunctionDangerousVariables) {
            detected.addAll(DetectVariableSets(((FunctionDangerousVariables) trashSet).getArgument()));
        }

        return detected;
    }

    //The root constraint is not influenced by any other constraint
    public int RootConstraint (HashMap<Integer, ArrayList<Integer>> influences)
    {
        Collection<ArrayList<Integer>> influenced_constraints = influences.values();
        int max_id_constraint=0;
        boolean influenced=false;
        for (Constraint constraint : constraints)
        {
            if(max_id_constraint<constraint.getId())
                max_id_constraint=constraint.getId();

            for(ArrayList<Integer> tmp_list : influenced_constraints)
            {
                if(tmp_list.contains(constraint.getId()))
                {
                    influenced=true;
                }
            }
            if(!influenced) //After checking every influenced constraints, if influenced is still false, then constraint is the root
            {
                return constraint.getId();
            }
            influenced=false;
        }

        return max_id_constraint+1; //So it is a constraint id that does not exist
    }


    public ArrayList<Constraint> ReversePostOrder(HashMap<Integer, ArrayList<Integer>> influences)
    {
        ArrayList<Constraint> ordered_list = new ArrayList<>();


        Stack <Constraint> stack = new Stack<>();
        ArrayList<Constraint> visited_constraints = new ArrayList<>();

        Constraint constraint = mapConstraints.get(RootConstraint(influences));

        if(constraint!=null) //if there is a root
        {
            stack.push(constraint);

            while (!stack.empty())
            {
                constraint = stack.peek();
                if(!visited_constraints.contains(constraint))
                {
                    visited_constraints.add(constraint);
                }

                ArrayList<Integer> influenced_constraints = influences.get(constraint.getId());


                if(influenced_constraints==null)
                {
                    constraint = stack.pop();
                    visited_constraints.remove(constraint);
                    ordered_list.add(0, constraint);
                }
                else
                {
                    boolean to_pop = true;
                    for (int i=0; i<influenced_constraints.size();i++)
                    {

                        Constraint tmp_constraint = mapConstraints.get(influenced_constraints.get(i));

                        if (!visited_constraints.contains(tmp_constraint) && !ordered_list.contains(tmp_constraint))
                        {
                            stack.push(tmp_constraint);
                            to_pop = false;
                            break;
                        }

                    }
                    if (to_pop)
                    {
                        stack.pop();
                        visited_constraints.remove(constraint);
                        ordered_list.add(0,constraint);
                    }
                }

            }
        }
        else
        {
            System.out.println("There is no root to the constraints tree");
        }

        return ordered_list;

    }


    public ArrayList<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(ArrayList<Constraint> constraints) {
        this.constraints = constraints;
    }

    public HashMap<Integer, Constraint> getMapConstraints() {
        return mapConstraints;
    }

    public void setMapConstraints(HashMap<Integer, Constraint> mapConstraints) {
        this.mapConstraints = mapConstraints;
    }



}
