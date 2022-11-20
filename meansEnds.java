import java.util.*;

public class meansEnds{
  private int counter;
  private worldState startState;
  //private Node rootNode;

  
  public meansEnds(worldState startState){
    this.counter = 0;
    this.startState = startState;
    //rootNode = new Node(startState);
  }

  // might need to pass in the root node for recursive tree generation
  public void backwardsChainGoals(Node rootNode, worldState ws, actions actions){
    if (ws.getMonkeyHasBananas()=="true"){
      
      //Initial Call
      String bananasRoom = ws.getBananasRoom();

      String[] monkeyBoxBananaArray = new String[]{bananasRoom,bananasRoom,bananasRoom};
      worldState newWorldState = new worldState(monkeyBoxBananaArray);
      newWorldState.setMonkeyHeight();
      Node childNode = new Node(newWorldState);
      rootNode.addChild(childNode);
      //ws = Banana,Banana,high,false
      
      actions newAction = new actions();
      newAction.initialSetMonkeyRoom(ws.getMonkeyRoom());
      newAction.initialSetBoxRoom(ws.getBoxRoom());
      newAction.initialSetBananasRoom(ws.getBananasRoom());
      
      backwardsChainGoals(childNode, newWorldState,newAction);
    }else{
      counter++;

      ArrayList<String> otherRoomsArray = ws.getOtherRooms();
      //everything after initial
      boolean movePossibleBoolRoom1 = actions.movePossible(ws.getMonkeyRoom(), otherRoomsArray.get(0));
      boolean movePossibleBoolRoom2 = actions.movePossible(ws.getMonkeyRoom(), otherRoomsArray.get(1));
      boolean climbUpPossible = actions.climbUpPossible(ws.getMonkeyRoom());
      boolean climbDownPossible = actions.climbDownPossible(ws.getMonkeyRoom());
      boolean pushBoxPossible1 = actions.pushBoxPossible(ws.getMonkeyRoom(), otherRoomsArray.get(0));
      boolean pushBoxPossible2 = actions.pushBoxPossible(ws.getMonkeyRoom(), otherRoomsArray.get(1));

      if (ws == startState){
        return;
      } else if (counter>7){
        return;
      }

      if (movePossibleBoolRoom1 = true){
        //possible move room 1
        String newMoveRoom = otherRoomsArray.get(0);

        //New world state
        String[] childNodeArray = new String[]{newMoveRoom,ws.getBoxRoom(),ws.getBananasRoom()};
        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        if (childWorldState.getMonkeyHeight() != ws.getMonkeyHeight()){
          childWorldState.setMonkeyHeight();
        }

        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);

        //new child actions to pass with updated room from childWorldState
        actions childAction = new actions();
        childAction.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childAction.initialSetBoxRoom(childWorldState.getBoxRoom());
        childAction.initialSetBananasRoom(childWorldState.getBananasRoom());
      
        //recursive call
        backwardsChainGoals(childNode,childWorldState,childAction);
      }

      if (movePossibleBoolRoom2 = true){
        String newMoveRoom = otherRoomsArray.get(1);
        String[] childNodeArray = new String[]{newMoveRoom,ws.getBoxRoom(),ws.getBananasRoom()};

        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        if (childWorldState.getMonkeyHeight() != ws.getMonkeyHeight()){
          childWorldState.setMonkeyHeight();
        }
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);

        //new child actions to pass with updated room from childWorldState
        actions childAction = new actions();
        childAction.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childAction.initialSetBoxRoom(childWorldState.getBoxRoom());
        childAction.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (climbUpPossible = true){
        String[] childNodeArray = new String[]{ws.getMonkeyRoom(),ws.getBoxRoom(),ws.getBananasRoom()};
        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        childWorldState.setMonkeyHeight();
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);

        //new child actions to pass with updated room from childWorldState
        actions childAction = new actions();
        childAction.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childAction.initialSetBoxRoom(childWorldState.getBoxRoom());
        childAction.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (climbDownPossible = true){
        String[] childNodeArray = new String[]{ws.getMonkeyRoom(),ws.getBoxRoom(),ws.getBananasRoom()};
        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        childWorldState.setMonkeyHeight();
        
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);

        //new child actions to pass with updated room from childWorldState
        actions childAction = new actions();
        childAction.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childAction.initialSetBoxRoom(childWorldState.getBoxRoom());
        childAction.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (pushBoxPossible1 = true){
        String newBoxRoom = otherRoomsArray.get(0);
        String[] childNodeArray = new String[]{newBoxRoom,newBoxRoom,ws.getBananasRoom()};

        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        if (childWorldState.getMonkeyHeight() != ws.getMonkeyHeight()){
          childWorldState.setMonkeyHeight();
        }
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);
        
        //new child actions to pass with updated room from childWorldState
        actions childAction = new actions();
        childAction.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childAction.initialSetBoxRoom(childWorldState.getBoxRoom());
        childAction.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (pushBoxPossible2 = true){
        String newBoxRoom = otherRoomsArray.get(1);
        String[] childNodeArray = new String[]{newBoxRoom,newBoxRoom,ws.getBananasRoom()};

        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        if (childWorldState.getMonkeyHeight() != ws.getMonkeyHeight()){
          childWorldState.setMonkeyHeight();
        }
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);
        
        //new child actions to pass with updated room from childWorldState
        actions childAction = new actions();
        childAction.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childAction.initialSetBoxRoom(childWorldState.getBoxRoom());
        childAction.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      else{
        System.out.println("Ayo what");
      }
    }
  }
  
}
