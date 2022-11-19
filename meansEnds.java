import java.io.*;
import java.util.*;

public class meansEnds{
  private Stack<worldState> goalStack;

  
  public meansEnds(Stack<worldState> goalStack){
    this.goalStack = goalStack;

  }

  public possibleBackGoals(worldsState ws, actions actions){
    if (ws.getMonkeyHasBananas()=="true"){
      goalStack.push(actions.printGrabBananas());
      goalStack.push(actions.printClimbDown());

      String bananasRoom = ws.getBananasRoom();
      String[] monkeyBoxBananaArray = new String[]{BananasRoom,bananasRoom,bananasRoom};
      
      worldState newWorldState = new worlState(monkeyBoxBananaArray);
    }
  }

  public getGoalStack(){
    return goalStack;
  }

  public int getFinalGoal{
    
    return finalGoal;
  }


  
}
