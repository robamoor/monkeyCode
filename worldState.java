import java.util.*;

public class worldState {
  /*
   * 
   */
  private ArrayList<String> roomMonkeyIn = new ArrayList<String>(); // each of these have one element
  private ArrayList<String> roomBoxIn = new ArrayList<String>();
  private ArrayList<String> roomBananasIn = new ArrayList<String>();
  private String monkeyHeight = "low";
  private boolean monkeyHasBananas = false;
  private ArrayList<String> roomMonkeyInitial = new ArrayList<String>(); // each of these have one element
  private ArrayList<String> roomBoxInitial = new ArrayList<String>();
  private ArrayList<String> roomBananasInitial = new ArrayList<String>();
  public static final String roomA = "A";
  public static final String roomB = "B";
  public static final String roomC = "C";

  public worldState(){;}
  
  public worldState(String[] monkeyBoxBananaArray){
    this.roomMonkeyIn.add(monkeyBoxBananaArray[0]);
    this.roomBoxIn.add(monkeyBoxBananaArray[1]);
    this.roomBananasIn.add(monkeyBoxBananaArray[2]);
    this.roomMonkeyInitial.add(monkeyBoxBananaArray[0]);
    this.roomBoxInitial.add(monkeyBoxBananaArray[1]);
    this.roomBananasInitial.add(monkeyBoxBananaArray[2]);
  }

  //Getter for Height Question for Actions  
  public String getMonkeyHeight(){
    return this.monkeyHeight;
  }

  public String getMonkeyRoom(){
    return this.roomMonkeyIn.get(0);
  }

  public String getBoxRoom(){
    return this.roomBoxIn.get(0);
  }

  public String getBananasRoom(){
    return this.roomBananasIn.get(0);
  }

  //Questions for Actions
  public boolean isMonkeyAt(String room) {
    return this.roomMonkeyIn.get(0).equalsIgnoreCase(room);
  }

  public boolean isBoxAt(String room) {
    return this.roomBoxIn.get(0).equalsIgnoreCase(room);
  }

  public boolean isBananasAt(String room) {
    return this.roomBananasIn.get(0).equalsIgnoreCase(room);
  }

  //Goal State
  public String getMonkeyHasBananas(){
    String monkeyHasBananasString = Boolean.toString(monkeyHasBananas);
    return monkeyHasBananasString;
  }

  //Changing worldState functions
  public void setMonkeyHeight(){
    if (monkeyHeight == "low"){monkeyHeight = "high";}
    else{ monkeyHeight = "low";}
  }

  public void setMonkeyRoom(String newRoom){
    this.roomMonkeyIn.remove(0);
    this.roomMonkeyIn.add(newRoom);
  }

  public void setMonkeyHasBananas(){
    this.monkeyHasBananas = true;
  }

  public void setBoxRoom(String newRoom){
    this.roomBoxIn.remove(0);
    this.roomBoxIn.add(newRoom);
  }

  //Initial worldState setup
  public void initialSetMonkeyRoom(String newRoom){
    this.roomMonkeyIn.add(newRoom);
  }

  public void initialSetBoxRoom(String newRoom){
    this.roomBoxIn.add(newRoom);
  }

  public void initialSetBananasRoom(String newRoom){
    this.roomBananasIn.add(newRoom);
  }

  //worldState getter
  public ArrayList<String> getWorldState(){

    ArrayList<String> currentWorldState = new ArrayList<String>();
    
    currentWorldState.add(getMonkeyRoom());
    currentWorldState.add(getBoxRoom());
    currentWorldState.add(getMonkeyHeight());
    currentWorldState.add(getMonkeyHasBananas());
    //monkeyRoom,boxRoom,height,monkeyHasBananas
  return currentWorldState;
  }

  //goalState getter
  public ArrayList<String> getGoalState(){

    ArrayList<String> goalState = new ArrayList<String>();
    
    goalState.add(getBananasRoom());
    goalState.add(getBananasRoom());
    goalState.add("high");
    goalState.add("true");
    //monkeyRoom,boxRoom,height,monkeyHasBananas
  return goalState;
  }

  public worldState getGoalWorldState(String[] worldStateArray){
    
    worldState goalWorldState = new worldState(worldStateArray);

    goalWorldState.setMonkeyHeight();
    goalWorldState.setMonkeyHasBananas();
    
    return goalWorldState;
  }


  public ArrayList<String> getOtherRooms(){
    String monkeyRoom = getMonkeyRoom();
    ArrayList<String> otherRooms = new ArrayList<String>(); 
    if (monkeyRoom.equalsIgnoreCase("a")){
      otherRooms.add("b");
      otherRooms.add("c");
    }else if(monkeyRoom.equalsIgnoreCase("b")){
      otherRooms.add("a");
      otherRooms.add("c");
    }else{
      otherRooms.add("a");
      otherRooms.add("b");
    }
    return otherRooms;
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

  public worldState getTargetState() {
    String[] param = new String[]{roomMonkeyInitial.get(0),roomBoxInitial.get(0),roomBananasInitial.get(0)};
    worldState targetState = new worldState(param);
    return targetState;
  }

}
