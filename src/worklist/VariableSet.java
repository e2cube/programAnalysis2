package worklist;

import java.util.ArrayList;
import java.util.HashMap;

public class VariableSet extends TrashSet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<AnalysisDomainElement> evaluate(HashMap<String, ArrayList<AnalysisDomainElement>> A) {

        if (A.get(name) == null) {
            return new ArrayList<>();
        }
        else {
            return A.get(name);
        }

    }

    public VariableSet(String name) {
        this.name = name;
    }

    public VariableSet(){

    }
}
