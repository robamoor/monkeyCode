class driver{

  driver(){;}
  
  public void runDriver(){
    inputScanner scanner = new inputScanner();
    String[] monkeyBoxBananasArray;
    monkeyBoxBananasArray = scanner.runScanner();

    //create initial worldState
    worldState nonBananasWorldState = new worldState(monkeyBoxBananasArray);
    Node nonBananasNode = new Node(nonBananasWorldState); 

    //create worldState where monkey has bananas to start from
    String[] bananasArray = new String[]{nonBananasWorldState.getBananasRoom(),nonBananasWorldState.getBananasRoom(),nonBananasWorldState.getBananasRoom()};
    worldState bananasWorldState = nonBananasWorldState.getGoalWorldState(bananasArray);
    System.out.println("bananasWorldState height "+ bananasWorldState.getMonkeyHeight());
    Node bananasNode = new Node(bananasWorldState);

    //create means ends instance of the ending state for backwards chaining
    meansEnds meansend = new meansEnds(nonBananasWorldState);

    //create actions class
    actions action = new actions();
    action.initialSetMonkeyRoom(bananasWorldState.getMonkeyRoom());
    action.initialSetBoxRoom(bananasWorldState.getBoxRoom());
    action.initialSetBananasRoom(bananasWorldState.getBananasRoom());
    action.setMonkeyHeight();
    
    //Initialize aStar and run backwards chaning starting from 
    aStar aStar = new aStar();
    Node nodeTree = meansend.backwardsChainGoals(bananasNode, bananasWorldState, action); //Needs to be bananasNode, ws, action
    Node runAStar = aStar.runAStar(nodeTree, nonBananasNode); //start,target
  }
}
