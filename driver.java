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
    
    action.move("A","B");
    action.printMove("A","B");
    action.pushBox("B","C");
    action.printPushBox("B","C");
    action.climbUp("C");
    action.printClimbUp();
    //action.climbDown("C");
    //action.printClimbDown();
    action.grabBananas("C");
    action.printGrabBananas();
    System.out.println("Monkey has bananas = " + action.getMonkeyHasBananas());
    
  }
}