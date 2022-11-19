import java.util.*;

public class meansEnds{
  private Stack<String> goalStack;

  
  public meansEnds(Stack<String> goalStack){
    this.goalStack = goalStack;

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

      //everything after initial
      boolean movePossibleBoolRoom1 = actions.movePossible(null, null);
      boolean movePossibleBoolRoom2 = actions.movePossible(null, null);
      boolean climbUpPossible = actions.climbUpPossible(null);
      boolean climbDownPossible = actions.climbDownPossible(null);
      boolean pushBoxPossible1 = actions.pushBoxPossible(null, null);
      boolean pushBoxPossible2 = actions.pushBoxPossible(null, null);

      //if (ws == goalState){
        //break
      //}

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
