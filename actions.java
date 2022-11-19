class actions extends worldState{
  
  actions(){;}
  
  public void move(String roomX, String roomY){
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low")){
      setMonkeyRoom(roomY);
    }
  }

  //maybe bools so that we can use these fns as checks to see if they are possible?
  //or new fns too
  
  public void pushBox(String roomX, String roomY){
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low") && (isBoxAt(roomX))){
      setMonkeyRoom(roomY);
      setBoxRoom(roomY);
    }
  }

  
  public void climbUp(String roomX){
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low") && (isBoxAt(roomX))){
      setMonkeyHeight();
    }
  }
  
  public void climbDown(String roomX){
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="high") && (isBoxAt(roomX))){
      setMonkeyHeight();
    }
  }
  
  public void grabBananas(String roomX){
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="high") && (isBananasAt(roomX))){
      setMonkeyHasBananas();
    }
  }

  public boolean movePossible(String roomX, String roomY){
    boolean possible = false;
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low")){
      possible = true;
    }
    return possible;
  }

  public boolean pushBoxPossible(String roomX, String roomY){
    boolean possible = false;
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low") && (isBoxAt(roomX))){
      possible = true;
    }
    return possible;
  }

  public boolean climbUpPossible(String roomX){
    boolean possible = false;
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low") && (isBoxAt(roomX))){
      possible = true;
    }
    return possible;
  }

  public boolean climbDownPossible(String roomX){
    boolean possible = false;
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="high") && (isBoxAt(roomX))){
      possible = true;
    }
    return possible;
  }

  public void printMove(String roomX, String roomY){
    System.out.println("Move("+roomX+","+roomY+")");
  }
  
  public void printPushBox(String roomX, String roomY){
    System.out.println("PushBox("+roomX+","+roomY+")");
  }
  
  public void printClimbUp(){
    System.out.println("ClimbUp()");
  }
  
  public void printClimbDown(){
    System.out.println("ClimbDown()");
  }
  
  public void printGrabBananas(){
    System.out.println("GrabBananas()");
  }

}
