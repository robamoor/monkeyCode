public class Node {
    private worldState ws;
    private Node[] children;
    //num children = number of possible actions from world state
    public Node(worldState ws, int numChildren) {
        this.ws = ws;
        this.children = new Node[numChildren];
    }

    public Node getChildAt(int index) {
        return children[index];
    }

    public void setChildAt(int index, Node child) {
        this.children[index] = child;
    }

    public worldState getWorldState() {
        return this.ws;
    }
}


