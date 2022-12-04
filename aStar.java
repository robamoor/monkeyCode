import java.util.*;

public class aStar{

    private ArrayList<worldState> path;

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

  public void getPath(Node target) {
    Node node = target;
    if (node==null) {
        return;
    }
    // traverses to top of branch from solution node
    path = new ArrayList<>();
    path.add(node.getWorldState());
    while (node.getParent()!= null) {
        node = node.getParent();
        path.add(node.getWorldState());
    }
//    Collections.reverse(path);
//    for (int i = 0; i < path.size();i++) {
//        System.out.println(path.get(i).getMonkeyRoom() + " " + path.get(i).getBoxRoom() + " " + path.get(i).getBananasRoom() + " " + path.get(i).getMonkeyHasBananas() + " ");
//    }

  }

  public void printActionList(){
    System.out.println("Plan:");
    for (int i =0; i< path.size()-1;i++){
        worldState firstState = path.get(i);
        worldState secondState = path.get(i+1);
        if ((firstState.getMonkeyRoom()!=secondState.getMonkeyRoom())&&(firstState.getBoxRoom()==secondState.getBoxRoom())){
            System.out.println("Move("+ firstState.getMonkeyRoom()+","+secondState.getMonkeyRoom()+")");
        }else if(secondState.getMonkeyHasBananas()=="true"){
            System.out.println("GrabBananas()");
            break;
        }else if(firstState.getBoxRoom()!=secondState.getBoxRoom()){
            System.out.println("MoveBox("+ firstState.getMonkeyRoom()+","+secondState.getMonkeyRoom()+")");
        }else if((firstState.getMonkeyHeight()!=secondState.getMonkeyHeight())&&secondState.getMonkeyHeight()=="high"){
            System.out.println("ClimbUp()");
        }else if((firstState.getMonkeyHeight()!=secondState.getMonkeyHeight())&&secondState.getMonkeyHeight()=="low"){
            System.out.println("ClimbDown()");
        }
    }
  }


}
