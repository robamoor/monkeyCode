import java.util.*;

public class aStar{

  public aStar(){
    
  }

  public int costFunction(int gn, int hn){
    return gn+hn;
  }

  public Node runAStar(Node start, Node target){
    PriorityQueue<Node> closedList = new PriorityQueue<>();
    PriorityQueue<Node> openList = new PriorityQueue<>();

    //start.f = start.g + start.calculateHeuristic(target);
    openList.add(start);
    return start;
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

/*public static void printPath(Node target){
    Node n = target;

    if(n==null)
        return;

    List<Integer> ids = new ArrayList<>();

    while(n.parent != null){
        ids.add(n.id);
        n = n.parent;
    }
    ids.add(n.id);
    Collections.reverse(ids);

    for(int id : ids){
        System.out.print(id + " ");
    }
    System.out.println("");
*/
}
