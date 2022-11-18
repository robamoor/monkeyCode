import java.util.*;

public class aStar{

  public aStar(){
    
  }

  public int costFunction(worldState ws){
    ArrayList<String> currentWorldState = ws.getWorldState();
    String monkeyRoom = currentWorldState.get(0);
    String boxRoom = currentWorldState.get(1);
    String monkeyHeight = currentWorldState.get(2);
    String monkeyHasBananas = currentWorldState.get(3);

    ArrayList<String> goalState = ws.getGoalState();
    String monkeyGoalRoom = goalState.get(0);
    String boxGoalRoom = goalState.get(1);
    String monkeyGoalHeight = goalState.get(2);
    
    int fn = 0;
    if(monkeyRoom != monkeyGoalRoom){
      fn = fn+2;
    }
    if(boxRoom != boxGoalRoom){
      fn = fn+2;
    }
    if(monkeyHeight != monkeyGoalHeight){
      fn++;
    }
    if(monkeyHasBananas == goalState.get(3)){
      fn = 0;
    }

    return fn;
  }

    /*
cost fn = move + heuristic
move fn (number of correct final conditions)
heuristic (moving/moving box are high cost and climb/grab bananas is low)

start from initial conditions-add to open node list
evaluate open node neighbors-move possible?/moveBox possible?/climb up/down possible?/grabBananas possible? what are their cost values

pick lowest cost 
repeat
  */
}
