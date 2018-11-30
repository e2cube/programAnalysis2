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
        return false;
    }
}
