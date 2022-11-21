import java.util.*;

public class meansEnds{
  private int counter;
  private worldState startState;
  //private Node rootNode;

  public meansEnds(worldState startState){
    this.counter = 0;
    this.startState = startState;
    //this.rootNode = new Node(startState);
  }

  // might need to pass in the root node for recursive tree generation
  public Node backwardsChainGoals(Node rootNode, worldState ws){
    if (ws.getMonkeyHasBananas()=="true"){
      
      //Initial Call
      String bananasRoom = ws.getBananasRoom();

      String[] monkeyBoxBananaArray = new String[]{bananasRoom,bananasRoom,bananasRoom};
      worldState newWorldState = new worldState(monkeyBoxBananaArray);
      newWorldState.setMonkeyHeight();

      Node childNode = new Node(newWorldState);
      rootNode.addChild(childNode);
      childNode.setPreviousRoom(bananasRoom);
      childNode.addParentNode(rootNode);
      //ws = Banana,Banana,high,false
      //this.rootNode = childNode;
      newWorldState.initialSetMonkeyRoom(ws.getMonkeyRoom());
      newWorldState.initialSetBoxRoom(ws.getBoxRoom());
      newWorldState.initialSetBananasRoom(ws.getBananasRoom());
      
      System.out.println("1st iteration");
      backwardsChainGoals(childNode, newWorldState);

      return rootNode;
    }else{

      this.counter++;
      ArrayList<String> otherRoomsArray = ws.getOtherRooms();
      //everything after initial
      boolean movePossibleBoolRoom1 = ws.movePossible(ws.getMonkeyRoom(), otherRoomsArray.get(0));
      boolean movePossibleBoolRoom2 = ws.movePossible(ws.getMonkeyRoom(), otherRoomsArray.get(1));
      boolean climbUpPossible = ws.climbUpPossible(ws.getMonkeyRoom());
      boolean climbDownPossible = ws.climbDownPossible(ws.getMonkeyRoom());
      boolean pushBoxPossible1 = ws.pushBoxPossible(ws.getMonkeyRoom(), otherRoomsArray.get(0));
      boolean pushBoxPossible2 = ws.pushBoxPossible(ws.getMonkeyRoom(), otherRoomsArray.get(1));

      if (compareTargetStates(ws)){
        System.out.println("found start state");
        return rootNode;
      } else if (counter>10){
        return rootNode;
      }
      // if it is possible to push the box and the previous node isnt located in the same room as the new one
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
        childNode.setPreviousRoom(newBoxRoom);
        childNode.addParentNode(rootNode);
        

        childWorldState.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childWorldState.initialSetBoxRoom(childWorldState.getBoxRoom());
        childWorldState.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        System.out.println("MoveBox1 leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState);
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
        rootNode.setPreviousRoom(newBoxRoom);
        childNode.addParentNode(rootNode);
        //new child actions to pass with updated room from childWorldState

        childWorldState.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childWorldState.initialSetBoxRoom(childWorldState.getBoxRoom());
        childWorldState.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        System.out.println("MoveBox2 leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState);
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
        childNode.addParentNode(rootNode);
        //new child actions to pass with updated room from childWorldState
        childWorldState.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childWorldState.initialSetBoxRoom(childWorldState.getBoxRoom());
        childWorldState.initialSetBananasRoom(childWorldState.getBananasRoom());
      
        //recursive call
        System.out.println("Move1 to " + otherRoomsArray.get(0)+ " leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState);
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
        childNode.addParentNode(rootNode);
        //new child actions to pass with updated room from childWorldState
        childWorldState.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childWorldState.initialSetBoxRoom(childWorldState.getBoxRoom());
        childWorldState.initialSetBananasRoom(childWorldState.getBananasRoom());
              
        //recursive call
        System.out.println("Move2 to " + otherRoomsArray.get(0)+ " leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState);
      }
      if (climbUpPossible == true){
        String[] childNodeArray = new String[]{ws.getMonkeyRoom(),ws.getBoxRoom(),ws.getBananasRoom()};
        worldState childWorldState = new worldState(childNodeArray);

        //change monkeyHeight to be correct
        childWorldState.setMonkeyHeight();
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);
        childNode.addParentNode(rootNode);
        //new child actions to pass with updated room from childWorldState

        childWorldState.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childWorldState.initialSetBoxRoom(childWorldState.getBoxRoom());
        childWorldState.initialSetBananasRoom(childWorldState.getBananasRoom());
        childWorldState.setMonkeyHeight();
              
        //recursive call
        System.out.println("ClimbUp leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState);
      }
      if (climbDownPossible == true){
        String[] childNodeArray = new String[]{ws.getMonkeyRoom(),ws.getBoxRoom(),ws.getBananasRoom()};
        worldState childWorldState = new worldState(childNodeArray);


        //change monkeyHeight to be correct
        childWorldState.setMonkeyHeight();
        
        //add node to node tree
        Node childNode = new Node(childWorldState);
        rootNode.addChild(childNode);
        childNode.setPreviousRoom(childWorldState.getMonkeyRoom());
        childNode.addParentNode(rootNode);
        //new child actions to pass with updated room from childWorldState

        childWorldState.initialSetMonkeyRoom(childWorldState.getMonkeyRoom());
        childWorldState.initialSetBoxRoom(childWorldState.getBoxRoom());
        childWorldState.initialSetBananasRoom(childWorldState.getBananasRoom());
        childWorldState.setMonkeyHeight();
              
        //recursive call
        System.out.println("ClimbDown leaf/iteration"+counter);
        backwardsChainGoals(childNode,childWorldState);
      }
    }
    return rootNode;
  }
/* 
  public Node getRootNode() {
    return rootNode;
  }
  */

  public void printNodeAndChildren(Node rootNode) {

    worldState rootState = rootNode.getWorldState();
    System.out.println("root node state --> " +" Monkey is in room: "+rootState.getMonkeyRoom()+" Bananas in room: " + rootState.getBananasRoom() + " Box is in room: " + rootState.getBoxRoom() + " Monkey is at height: " +rootState.getMonkeyHeight());
    for (int i = 0; i < rootNode.getChildren().size(); i++) {
      System.out.println("child state at index " + i + " --> " + " Monkey is in room: "+rootNode.getChildren().get(i).getWorldState().getMonkeyRoom()+" Bananas in room: " + rootNode.getChildren().get(i).getWorldState().getBananasRoom() + " Box is in room: " + rootNode.getChildren().get(i).getWorldState().getBoxRoom() + " Monkey is at height: " +rootNode.getChildren().get(i).getWorldState().getMonkeyHeight());
    } 
  }
// there is omething horribly wrong w/ this function
  public void printTree(Node rootNode) {

    worldState rootState = rootNode.getWorldState();
    System.out.println("root node state --> " +" Monkey is in room: "+rootState.getMonkeyRoom()+" Bananas in room: " + rootState.getBananasRoom() + " Box is in room: " + rootState.getBoxRoom() + " Monkey is at height: " +rootState.getMonkeyHeight());
    while (rootNode.getChildren() != null) {
      for (int i = 0; i < rootNode.getChildren().size(); i++) {
        System.out.println("child state at index " + i + " --> " + " Monkey is in room: "+rootNode.getChildren().get(i).getWorldState().getMonkeyRoom()+" Bananas in room: " + rootNode.getChildren().get(i).getWorldState().getBananasRoom() + " Box is in room: " + rootNode.getChildren().get(i).getWorldState().getBoxRoom() + " Monkey is at height: " +rootNode.getChildren().get(i).getWorldState().getMonkeyHeight());
        Node newNode = rootNode.getChildAt(i);  
        printTree(newNode);
      } 
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
