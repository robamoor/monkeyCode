import java.util.ArrayList;

public class Node implements Comparable<Node>{
    private worldState ws;
    private String previousRoom;
    private Node parent;
    private ArrayList<Node> children;
    private int moveScore;
    private int hScore;
    private int fScore;

    //num children = number of possible actions from world state
    public Node(worldState ws) {
        this.ws = ws;
        this.moveScore = moveFunction();
        this.hScore = heuristicFunction();
        this.fScore = hScore+moveScore;
        //children = new ArrayList<>();
    }

    public void addParentNode(Node parentNode) {
      parent = parentNode;
    }

    public Node getParent() {
      return parent;
    }

    public Node getChildAt(int index) {
        return children.get(index);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
      if (children == null) {
        children = new ArrayList<>();
        children.add(child);
      } else {
        children.add(child);
      } 
    }

    public worldState getWorldState() {
        return this.ws;
    }

    public String getPreviousRoom() {
      return previousRoom;
    }

    public void setPreviousRoom(String room) {
      previousRoom = room;
    }


      //move fn (number of correct final conditions)
    public int moveFunction(){
      ArrayList<String> currentWorldState = ws.getWorldState();
      String monkeyRoom = currentWorldState.get(0);
      String boxRoom = currentWorldState.get(1);
      String monkeyHeight = currentWorldState.get(2);
      String monkeyHasBananas = currentWorldState.get(3);

      //be careful to check what this is
      ArrayList<String> goalState = ws.getGoalState();
      String monkeyGoalRoom = goalState.get(0);
      String boxGoalRoom = goalState.get(1);
      String monkeyGoalHeight = goalState.get(2);
    
      int gn = 0;
      if(monkeyRoom != monkeyGoalRoom){
        gn++;
      }
      if(boxRoom != boxGoalRoom){
        gn++;
      }
      if(monkeyHeight != monkeyGoalHeight){
        gn++;
      }
      if(monkeyHasBananas == goalState.get(3)){
        gn = 0;
      }
      return gn;
    }

    //heuristic (moving/moving box are high cost and climb/grab bananas is low)
    //don't go to the previous rooms
    public int heuristicFunction(){
        ArrayList<String> currentWorldState = ws.getWorldState();
        String monkeyRoom = currentWorldState.get(0);
        String boxRoom = currentWorldState.get(1);
        String monkeyHeight = currentWorldState.get(2);
        String monkeyHasBananas = currentWorldState.get(3);
    
        ArrayList<String> goalState = ws.getGoalState();
        String monkeyGoalRoom = goalState.get(0);
        String boxGoalRoom = goalState.get(1);
        String monkeyGoalHeight = goalState.get(2);
        
        int hn = 0;
        if(monkeyRoom != monkeyGoalRoom){
          hn = hn+3;
        }
        if(boxRoom != boxGoalRoom){
          hn= hn+3;
        }
        if(monkeyHeight != monkeyGoalHeight){
          hn++;
        }
        if(compareTargetStates(ws)){
          hn = 0;
        }

        return hn;
      }

      public int getMoveScore() {
        return moveScore;
      }

      public void setMoveScore(int newScore) {
        this.moveScore = newScore;
      }

      public int getHScore() {
        return hScore;
      }

      public int getFScore(){
        return fScore;
      }

      public int costFunction(int gn, int hn){
        return gn+hn;
      }

      public void setCostFunction(int gn, int hn) {
        fScore = gn+hn;
      }
    
      public boolean compareTargetStates(worldState currentWorldState){
    
        Boolean monkeyHasBananasCheck = currentWorldState.getMonkeyHasBananas().equalsIgnoreCase(ws.getTargetState().getMonkeyHasBananas());
        Boolean heightCheck = currentWorldState.getMonkeyHeight().equalsIgnoreCase(ws.getTargetState().getMonkeyHeight());
        Boolean bananasRoomCheck = currentWorldState.getBananasRoom().equalsIgnoreCase(ws.getTargetState().getBananasRoom());
        Boolean boxRoomCheck = currentWorldState.getBoxRoom().equalsIgnoreCase(ws.getTargetState().getBoxRoom());
        Boolean monkeyRoomCheck = currentWorldState.getMonkeyRoom().equalsIgnoreCase(ws.getTargetState().getMonkeyRoom());
    
        return monkeyHasBananasCheck&&heightCheck&&bananasRoomCheck&&boxRoomCheck&&monkeyRoomCheck;
      }

    
    public int compareTo(Node node) {
        int cost1 = moveScore + hScore;
        int cost2 = node.getMoveScore() + node.getHScore();
        int max = cost1;
        if (cost1 < cost2) {
            max = cost2;
        }
        return max;
    }
    


}


