class driver{

  driver(){;}
  
  public void runDriver(){
    inputScanner scanner = new inputScanner();
    String[] monkeyBoxBananasArray;
    monkeyBoxBananasArray = scanner.runScanner();

    worldState ws = new worldState(monkeyBoxBananasArray);

    actions action = new actions();
    action.initialSetMonkeyRoom(ws.getMonkeyRoom());
    action.initialSetBoxRoom(ws.getBoxRoom());
    action.initialSetBananasRoom(ws.getBananasRoom());
    
    meansEnds meansend = new meansEnds(ws);
    Node rootNode = new Node(ws); //startState node that we search for?
    aStar aStar = new aStar();

    Node nodeTree = meansend.backwardsChainGoals(rootNode, ws, action); //Needs to be bananasNode, ws, action
    Node runAStar = aStar.runAStar(nodeTree, rootNode); //start,target
  }
}
