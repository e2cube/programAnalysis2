package worklist;


import com.company.Variable;
import worklist.Operators.Operator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class WorklistAlgorithm {


    public HashMap<String, ArrayList<AnalysisDomainElement>> fifo(ArrayList<Constraint> givenConstraints) {
        Worklist worklist = new Worklist(givenConstraints);
        HashMap<String, ArrayList<VariableSet>> infl = worklist.CreateInfluence();
        HashMap<String, ArrayList<AnalysisDomainElement>> A;

        return null;
    }


}
