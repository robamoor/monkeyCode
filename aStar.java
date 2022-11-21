import java.util.*;

public class aStar{

    //private worldState targetState;

  public aStar(){
    
  }

  public Node runAStar(Node start, Node target){
    PriorityQueue<Node> closedList = new PriorityQueue<>();
    PriorityQueue<Node> openList = new PriorityQueue<>();

    int start_f = start.getFScore();
    openList.add(start);
    
    while ((!openList.isEmpty())) {
        // do smth
        Node current = openList.peek();
        if (compareTargetStates(current.getWorldState(), target.getWorldState())) {
            return current;
        } else if (current.getChildren() == null) {
            openList.remove(current);
            closedList.add(current);
            continue;
        }

        // for each cost(m) 
        int iter = 0;
        for (Node n : current.getChildren()) {
            iter++;
            int totalWeight = current.getMoveScore() + n.getMoveScore();
            if(!(openList.contains(n)) && !(closedList.contains(n))) {
                n.addParentNode(current);
                n.setMoveScore(totalWeight);
                n.setCostFunction(n.getMoveScore(), n.getHScore());
                openList.add(n);
            } else {
                if(totalWeight < n.getMoveScore()) {
                    n.addParentNode(current);
                    n.setMoveScore(totalWeight);
                    n.setCostFunction(n.getMoveScore(), n.getHScore());

                    if(closedList.contains(n)) {
                        closedList.remove(n);
                        openList.add(n);
                    }
                }
            }
            /* 
            if (n.getChildren() == null) {
                
                 if(compareTargetStates(n.getWorldState(), target.getWorldState())) {
                    openList.remove(current);
                    closedList.add(current);
                    return current;
                 } else {
                    break;
                 } 
            }
            */  
        }
        openList.remove(current);
        closedList.add(current);
    }
    return null;
  }

  // returns true if current state matches target state
  public boolean compareTargetStates(worldState currentWorldState, worldState target){
    
    Boolean monkeyHasBananasCheck = currentWorldState.getMonkeyHasBananas().equalsIgnoreCase(target.getMonkeyHasBananas());
    Boolean heightCheck = currentWorldState.getMonkeyHeight().equalsIgnoreCase(target.getMonkeyHeight());
    Boolean bananasRoomCheck = currentWorldState.getBananasRoom().equalsIgnoreCase(target.getBananasRoom());
    Boolean boxRoomCheck = currentWorldState.getBoxRoom().equalsIgnoreCase(target.getBoxRoom());
    Boolean monkeyRoomCheck = currentWorldState.getMonkeyRoom().equalsIgnoreCase(target.getMonkeyRoom());

    return monkeyHasBananasCheck&&heightCheck&&bananasRoomCheck&&boxRoomCheck&&monkeyRoomCheck;
  }

  public void printPath(Node target) {
    Node node = target;
    if (node==null) {
        return;
    }
    // traverses to top of branch from solution node
    ArrayList<worldState> wsArrayList = new ArrayList<>();
    while (node.getParent()!= null) {
        node = node.getParent();
        wsArrayList.add(node.getWorldState());
    }
    Collections.reverse(wsArrayList);
    for (int i = 0; i < wsArrayList.size();i++) {
        System.out.println(wsArrayList.get(i).getMonkeyRoom() + " " + wsArrayList.get(i).getBoxRoom() + " " + wsArrayList.get(i).getMonkeyHeight() + " " + wsArrayList.get(i).getMonkeyHasBananas() + " ");
    }
  }

/* 
A* pseudocode

make an empty list C of closed nodes
make a list O of open nodes and their respective fn values containing the start node
while O isn't empty:
    pick a node n from O with the best value for fn
    if n is target:
        return solution
    for every m which is a neighbor of n:
        if (m is not in C) and (m is not in O):
            add m to O, set n as m's parent
            calculate g(m) and f(m) and save them
        else:
            if f(m) from last iteration is better than g(m) from this iteration:
                set n as m's parent
                update g(m) and f(m)
                if m is in C:
                    move m to O
    move n from O to C

return that there's no solution */

/*public static void printPath(Node target){
    Node n = target;

    if(n==null)
        return;

    List<Integer> ids = new ArrayList<>();

    while(n.parent != null){
        ids.add(n.id);
        n = n.parent;
    }
    ids.add(n.id);
    Collections.reverse(ids);

    for(int id : ids){
        System.out.print(id + " ");
    }
    System.out.println("");
*/
}
