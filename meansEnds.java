import java.util.*;

public class meansEnds{
  private Stack<String> goalStack;
  private int counter;
  private worldState startState;

  
  public meansEnds(Stack<String> goalStack,worldState startState){
    this.goalStack = goalStack;
    this.counter = 0;
    this.startState =startState;

  }

  public void backwardsChainGoals(worldState ws, actions actions){
    if (ws.getMonkeyHasBananas()=="true"){
      
      //Initial Call
      String bananasRoom = ws.getBananasRoom();
      goalStack.push("bananas");

      String[] monkeyBoxBananaArray = new String[]{bananasRoom,bananasRoom,bananasRoom};
      
      worldState newWorldState = new worldState(monkeyBoxBananaArray);
      newWorldState.setMonkeyHeight();
      //ws = Banana,Banana,high,false
      
      actions newAction = new actions();
      newAction.initialSetMonkeyRoom(ws.getMonkeyRoom());
      newAction.initialSetBoxRoom(ws.getBoxRoom());
      newAction.initialSetBananasRoom(ws.getBananasRoom());
      
      backwardsChainGoals(newWorldState,newAction);
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
        //create possible worldState
        //add node to node tree
        //backwardsChainGoals
      }
      if (movePossibleBoolRoom2 = true){
        //create possible worldState
        //add node to node tree
        //backwardsChainGoals
      }
      if (climbUpPossible = true){
        //create possible worldState
        //add node to node tree
        //backwardsChainGoals
      }
      if (climbDownPossible = true){
        //create possible worldState
        //add node to node tree
        //backwardsChainGoals
      }
      if (pushBoxPossible1 = true){
        //create possible worldState
        //add node to node tree
        //backwardsChainGoals
      }
      if (pushBoxPossible2 = true){
        //create possible worldState
        //add node to node tree
        //backwardsChainGoals
      }

    }
  }
  
  public Stack<String> getGoalStack(){
    return goalStack;
  }



  
}
