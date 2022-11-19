import java.io.*;
import java.util.*;

public class meansEnds{
  private Stack<worldState> goalStack;

  
  public meansEnds(Stack<worldState> goalStack){
    this.goalStack = goalStack;

  }

  public backwardsChainGoals(worldState ws, actions actions){
    if (ws.getMonkeyHasBananas()=="true"){
      goalStack.push(actions.printGrabBananas());

      String bananasRoom = ws.getBananasRoom();
      String[] monkeyBoxBananaArray = new String[]{BananasRoom,bananasRoom,bananasRoom};
      
      worldState newWorldState = new worldState(monkeyBoxBananaArray);
      newWorldState.setMonkeyHeight();
      //ws = Banana,Banana,high,false
      
      actions newAction = new actions();
      newAction.initialSetMonkeyRoom(ws.getMonkeyRoom());
      newAction.initialSetBoxRoom(ws.getBoxRoom());
      newAction.initialSetBananasRoom(ws.getBananasRoom());
      
      backwardsChainGoals(newWorldState,action);
    }else{
      int i = 0;
    }
  }
  

  public getGoalStack(){
    return goalStack;
  }

  public int getFinalGoal{
    
    return finalGoal;
  }


  
}
