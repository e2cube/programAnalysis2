package worklist;


import com.company.Variable;
import worklist.Operators.Operator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WorklistAlgorithm {


    public HashMap<String, ArrayList<AnalysisDomainElement>> fifo(LinkedList<Constraint> givenConstraints) {

        Worklist worklist = new Worklist(givenConstraints);

        //HashMap<String, ArrayList<VariableSet>> infl = worklist.CreateInfluence();
        HashMap<String, ArrayList<AnalysisDomainElement>> A;

        return null;
    }

}
