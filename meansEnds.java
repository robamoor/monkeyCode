import java.util.*;

public class meansEnds{
  private int counter;
  private worldState startState;
  private Node rootNode;

  
  public meansEnds(worldState startState){
    this.counter = 0;
    this.startState = startState;
    rootNode = new Node(startState);
  }

  // might need to pass in the root node for recursive tree generation
  public Node backwardsChainGoals(Node rootNode, worldState ws, actions actions){
    if (ws.getMonkeyHasBananas()=="true"){
      
      //Initial Call
      String bananasRoom = ws.getBananasRoom();

      String[] monkeyBoxBananaArray = new String[]{bananasRoom,bananasRoom,bananasRoom};
      worldState newWorldState = new worldState(monkeyBoxBananaArray);
      newWorldState.setMonkeyHeight();

      this.rootNode = rootNode;
      Node childNode = new Node(newWorldState);
      rootNode.addChild(childNode);
      //ws = Banana,Banana,high,false
      
      actions newAction = new actions();
      newAction.initialSetMonkeyRoom(ws.getMonkeyRoom());
      newAction.initialSetBoxRoom(ws.getBoxRoom());
      newAction.initialSetBananasRoom(ws.getBananasRoom());
      
      System.out.println("1st iteration");
      backwardsChainGoals(childNode, newWorldState, newAction);

      return rootNode;
    }else{

      this.counter++;
      ArrayList<String> otherRoomsArray = ws.getOtherRooms();
      //everything after initial
      boolean movePossibleBoolRoom1 = actions.movePossible(ws.getMonkeyRoom(), otherRoomsArray.get(0));
      boolean movePossibleBoolRoom2 = actions.movePossible(ws.getMonkeyRoom(), otherRoomsArray.get(1));
      boolean climbUpPossible = actions.climbUpPossible(ws.getMonkeyRoom());
      boolean climbDownPossible = actions.climbDownPossible(ws.getMonkeyRoom());
      boolean pushBoxPossible1 = actions.pushBoxPossible(ws.getMonkeyRoom(), otherRoomsArray.get(0));
      boolean pushBoxPossible2 = actions.pushBoxPossible(ws.getMonkeyRoom(), otherRoomsArray.get(1));

      if (compareTargetStates(ws)){
        System.out.println("found start state");
        return rootNode;
      } else if (counter>10){
        return rootNode;
      }
      if (pushBoxPossible1 == true){
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
        System.out.println("MoveBox1 leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (pushBoxPossible2 == true){
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
        System.out.println("MoveBox2 leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (movePossibleBoolRoom1 == true){
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
        System.out.println("Move1 to " + otherRoomsArray.get(0)+ " leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState,childAction);
      }

      if (movePossibleBoolRoom2 == true){
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
        System.out.println("Move2 to " + otherRoomsArray.get(0)+ " leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (climbUpPossible == true){
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
        childAction.setMonkeyHeight();
              
        //recursive call
        System.out.println("ClimbUp leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
      if (climbDownPossible == true){
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
        childAction.setMonkeyHeight();
              
        //recursive call
        System.out.println("ClimbDown leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState,childAction);
      }
    }
    return rootNode;
  }

  public void printTree(Node rootNode) {

    while(rootNode.getChildren() != null) {
      
    }
  }

  public boolean compareTargetStates(worldState currentWorldState){
    
    Boolean monkeyHasBananasCheck = currentWorldState.getMonkeyHasBananas().equalsIgnoreCase(startState.getMonkeyHasBananas());
    Boolean heightCheck = currentWorldState.getMonkeyHeight().equalsIgnoreCase(startState.getMonkeyHeight());
    Boolean bananasRoomCheck = currentWorldState.getBananasRoom().equalsIgnoreCase(startState.getBananasRoom());
    Boolean boxRoomCheck = currentWorldState.getBoxRoom().equalsIgnoreCase(startState.getBoxRoom());
    Boolean monkeyRoomCheck = currentWorldState.getMonkeyRoom().equalsIgnoreCase(startState.getMonkeyRoom());

    return monkeyHasBananasCheck&&heightCheck&&bananasRoomCheck&&boxRoomCheck&&monkeyRoomCheck;
  }
}
