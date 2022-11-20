import java.util.ArrayList;

public class Node {
    private worldState ws;
    private ArrayList<Node> children;
    //num children = number of possible actions from world state
    public Node(worldState ws) {
        this.ws = ws;
        children = new ArrayList<>();
    }

    public Node getChildAt(int index) {
        return children.get(index);
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public worldState getWorldState() {
        return this.ws;
    }
}


