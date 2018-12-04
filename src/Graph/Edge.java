package Graph;

public class Edge {

    private Node startNode;
    private Node endNode;
    public Label label;

    public Edge(Label label) {
        this.label = label;
    }

    public void AddStartNode(Node n) {
        this.startNode = n;
    }

    public void AddEndNode(Node n) {
        this.endNode = n;
    }

    public Node GetEndNode() {
        return this.endNode;
    }

    public Node GetStartNode() {
        return this.startNode;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Edge){
            Edge otherEdge = (Edge) obj;
            //&& this.label.equals(otherEdge.label) should be added to the return
            return (this.startNode.equals(otherEdge.GetStartNode()) && this.endNode.equals(otherEdge.GetEndNode()));
        }
        return false;
    }
}