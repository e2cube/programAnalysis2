package worklist.AnalysisDomain;

import worklist.AnalysisDomainElement;

public class DSElement extends AnalysisDomainElement {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DSElement(String name) {
        this.name = name;
    }

    @Override
    public boolean Equals(AnalysisDomainElement otherElement) {
        if (otherElement instanceof DSElement){
            if (this.name.equals(((DSElement) otherElement).name)) {
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
