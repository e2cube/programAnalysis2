package Analysis;

import com.company.Graph;
import com.company.OneToOther;
import com.company.Sequence;
import worklist.AnalysisDomainElement;
import worklist.Constraint;
import worklist.TrashSet;
import worklist.WorklistAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {

    public enum TypeAnalysis
    {
        DANGEROUS,
        SIGNS;
    }

    public enum TypeWorklist
    {
        FIFO,
        LIFO,
        REVERSE;
    }

    public void Analyse(Sequence abstract_syntax_tree, TypeAnalysis typeAnalysis, TypeWorklist typeWorklist)
    {
        OneToOther translation_object = new OneToOther();
        translation_object.TreeToGraph(abstract_syntax_tree);

        Graph generated_graph = translation_object.graph;
        AnalysisAlgorithm analysis = new AnalysisAlgorithm(generated_graph);

        ArrayList<Constraint> generated_constraints = new ArrayList<>();


        switch (typeAnalysis)
        {
            case DANGEROUS: generated_constraints = analysis.DangerousVariablesAnalysis();
                break;
                //Need a way to transport TrashSet info to DetectionSignsAnalysis
            case SIGNS: generated_constraints = analysis.DetectionSignsAnalysis(null);
                break;
        }

        WorklistAlgorithm worklist_algorithm = new WorklistAlgorithm();
        HashMap<String, ArrayList<AnalysisDomainElement>> A_result = new HashMap<>();

        switch (typeWorklist)
        {
            case FIFO : A_result = worklist_algorithm.fifo(generated_constraints);
            case LIFO : A_result = worklist_algorithm.lifo(generated_constraints);
            case REVERSE : A_result = worklist_algorithm.ReversePostOrderIteration(generated_constraints);
        }

        //Then print the A_result
    }
}
