package worklist;

import com.company.Variable;
import worklist.Operators.Operator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Worklist {

    public HashMap<String, ArrayList<VariableSet>> CreateInfluence(ArrayList<Constraint> givenConstraints)
    {
        HashMap<String, ArrayList<VariableSet>> influences = new HashMap<>();


        for(Constraint constraint  : givenConstraints)
        {
            ArrayList<VariableSet> vs_contained = DetectVariableSets(constraint.getRightHandSide());

            if (!vs_contained.isEmpty())
            {
                for (VariableSet vs : vs_contained)
                {
                    if(influences.get(vs.name) == null)
                    {
                        ArrayList<VariableSet> tmpSets = new ArrayList<>();
                        tmpSets.add(constraint.getLeftHandSide());
                        influences.put(vs.name, tmpSets);
                    }
                    else if (!influences.get(vs.name).contains(constraint.getLeftHandSide()))
                    {
                        ArrayList<VariableSet> tmpSets = influences.get(vs.name);
                        tmpSets.add(constraint.getLeftHandSide());
                        influences.remove(vs.name);
                        influences.put(vs.name, tmpSets);
                    }
                }
            }

        }


        return influences;
    }

    //Detects all the variable sets contained in a trash set (even the nested ones). Recursive.
    public ArrayList<VariableSet> DetectVariableSets(TrashSet trashSet)
    {
        ArrayList<VariableSet> detected = new ArrayList<>();

        if(trashSet instanceof ConstantSet)
        {
            //DO NOTHING
        }
        else if (trashSet instanceof VariableSet)
        {
            detected.add((VariableSet) trashSet);
        }
        else if (trashSet instanceof Operator)
        {
            //Left
            ArrayList<VariableSet> detectedLeft = DetectVariableSets(((Operator) trashSet).getLeftHandSide());

            //right
            ArrayList<VariableSet> detectedRight = DetectVariableSets(((Operator) trashSet).getRightHandSide());

            //Sum the 2 lists in detected
            detected.addAll(detectedLeft);
            for(VariableSet vs : detectedRight)
            {
                if (!detected.contains(vs))
                {
                    detected.add(vs);
                }
            }

        }

        return detected;
    }
}
