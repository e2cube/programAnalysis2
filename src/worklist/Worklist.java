package worklist;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.jetbrains.annotations.NotNull;
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

    public HashMap<String, ArrayList<VariableSet>> CreateInfluence() {
        HashMap<String, ArrayList<VariableSet>> influences = new HashMap<>();
        for (Constraint constraint : constraints) {
            ArrayList<VariableSet> vs_contained = DetectVariableSets(constraint.getRightHandSide());

            if (!vs_contained.isEmpty()) {
                for (VariableSet vs : vs_contained) {
                    if (influences.get(vs.getName()) == null) {
                        ArrayList<VariableSet> tmpSets = new ArrayList<>();
                        tmpSets.add(constraint.getLeftHandSide());
                        influences.put(vs.getName(), tmpSets);
                    } else if (!influences.get(vs.getName()).contains(constraint.getLeftHandSide())) {
                        ArrayList<VariableSet> tmpSets = influences.get(vs.getName());
                        tmpSets.add(constraint.getLeftHandSide());
                        influences.remove(vs.getName());
                        influences.put(vs.getName(), tmpSets);
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
}
