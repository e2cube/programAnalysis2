package Analysis;

import Graph.*;
import worklist.*;
import worklist.AnalysisDomain.DVElement;

import java.util.ArrayList;
import java.util.HashMap;

public class Analysis {

    public enum TypeAnalysis
    {
        DANGEROUS,
        SIGNS
    }

    public enum TypeWorklist
    {
        FIFO,
        LIFO,
        REVERSE
    }

    public void Analyse(Sequence abstract_syntax_tree, TypeAnalysis typeAnalysis, TypeWorklist typeWorklist)
    {
        OneToOther translation_object = new OneToOther();
        translation_object.TreeToGraph(abstract_syntax_tree);

        Graph generated_graph = translation_object.graph;



        AnalysisAlgorithm analysis_algo = new AnalysisAlgorithm(generated_graph);

        ArrayList<Constraint> generated_constraints = new ArrayList<>();
        ArrayList<AnalysisDomainElement> initial_info = new ArrayList<>();

        switch (typeAnalysis)
        {
            case DANGEROUS:
                //HARD CODED INITIAL DANGEROUS VARIABLES !
                initial_info.add(new DVElement("index"));
                generated_constraints = analysis_algo.DangerousVariablesAnalysis(new ConstantSet(initial_info));
                break;
                //Need a way to transport TrashSet info to DetectionSignsAnalysis
            case SIGNS: generated_constraints = analysis_algo.DetectionSignsAnalysis(null);
                break;
        }

        WorklistAlgorithm worklist_algorithm = new WorklistAlgorithm();
        HashMap<String, ArrayList<AnalysisDomainElement>> A_result = new HashMap<>();

        switch (typeWorklist)
        {
            case FIFO: A_result = worklist_algorithm.fifo(generated_constraints);
                break;
            case LIFO: A_result = worklist_algorithm.lifo(generated_constraints);
                break;
            case REVERSE: A_result = worklist_algorithm.ReversePostOrderIteration(generated_constraints);
                break;
        }

        //Then print the A_result
        System.out.println("RESULT :");
        for (String name: A_result.keySet()){
            ArrayList<AnalysisDomainElement> value = A_result.get(name);

            System.out.println(name +" : " );
            for (AnalysisDomainElement element : value)
            {
                System.out.println(element.getName());
            }
            System.out.println();
        }
    }
}
