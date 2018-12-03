package worklist.AnalysisDomain;

import Analysis.AnalysisAlgorithm;
import worklist.AnalysisDomainElement;

public class DVElement extends AnalysisDomainElement {
    private String name;

    public DVElement(String variable_name) {
        this.name = variable_name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean Equals(AnalysisDomainElement otherElement) {
        if (otherElement instanceof DVElement){
            if (this.name.equals(((DVElement) otherElement).name)) {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
