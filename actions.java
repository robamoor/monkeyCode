class actions extends worldState{
  
  actions(){;}
  
  public void move(String roomX, String roomY){
    if ((isMonkeyAt(roomX)) && (getMonkeyHeight()=="low")){
      setMonkeyRoom(roomY);
    }
  }
  
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