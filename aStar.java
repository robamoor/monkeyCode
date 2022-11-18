import java.util.*;

public class aStar{

  public aStar(){
    
  }
  //move fn (number of correct final conditions)
  public int moveFunction(worldState ws){
    ArrayList<String> currentWorldState = ws.getWorldState();
    String monkeyRoom = currentWorldState.get(0);
    String boxRoom = currentWorldState.get(1);
    String monkeyHeight = currentWorldState.get(2);
    String monkeyHasBananas = currentWorldState.get(3);

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
    System.out.println(gn);
    return gn;
  }

  //heuristic (moving/moving box are high cost and climb/grab bananas is low)
  public int heuristicFunction(worldState ws){
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
    if(monkeyHasBananas == goalState.get(3)){
      hn = 0;
    }
    System.out.println(hn);
    return hn;
  }

  public int costFunction(int gn, int hn){
    return gn+hn;
  }

/*

start from initial conditions-add to open node list
evaluate open node neighbors-move possible?/moveBox possible?/climb up/down possible?/grabBananas possible? what are their cost values

pick lowest cost 
repeat
  */
}
