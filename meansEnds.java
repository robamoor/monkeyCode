import java.io.*;
import java.util.*;

public class meansEnds{
  private Stack<actions> goalStack;

  
  public meansEnds(Stack<actions> goalStack){
    this.goalStack = goalStack;

  }

  public void backwardsChainGoals(worldState ws, actions actions){
    if (ws.getMonkeyHasBananas()=="true"){
      
      String bananasRoom = ws.getBananasRoom();
      goalStack.push(actions.grabBananas(bananasRoom));
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
      int i = 0;
    }
  }
  

  public Stack<actions> getGoalStack(){
    return goalStack;
  }



  
}
