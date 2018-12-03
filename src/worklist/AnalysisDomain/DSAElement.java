package worklist.AnalysisDomain;

import worklist.AnalysisDomainElement;

public class DSAElement extends AnalysisDomainElement {

    public enum Sign {
        PLUS, MINUS, ZERO
    }

    private String name;

    private Sign sign;

    @Override
    public String getName() {
        return name;
    }


    @Override
    public boolean Equals(Object otherElement) {
        if (otherElement instanceof DSAElement){
           if (this.name.equals(((DSAElement) otherElement).name)
           && this.sign == ((DSAElement) otherElement).sign){
               return true;
           }
           else {
               return false;
           }
       }
       else {
           return false;
       }
    }
}
