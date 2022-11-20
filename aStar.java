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

    //be careful to check what this is
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
A* pseudocode
make an empty list C of closed nodes
make a list O of open nodes and their respective fn values containing the start node
while O isn't empty:
    pick a node n from O with the best value for fn
    if n is target:
        return solution
    for every m which is a neighbor of n:
        if (m is not in C) and (m is not in O):
            add m to O, set n as m's parent
            calculate g(m) and f(m) and save them
        else:
            if f(m) from last iteration is better than g(m) from this iteration:
                set n as m's parent
                update g(m) and f(m)
                if m is in C:
                    move m to O
    move n from O to C

return that there's no solution */
}
