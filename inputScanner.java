import java.util.Scanner;

class inputScanner{
  
  private String monkeyRoom;
  private String boxRoom;
  private String bananasRoom;

  public inputScanner(){
    
  };

  public String[] runScanner(){
    Scanner input = new Scanner(System.in);
    monkeyRoom = monkeyStart(input);
    boxRoom = boxStart(input);
    bananasRoom = bananasStart(input);
    input.close();
    String[] monkeyBoxBananaArray = new String[]{monkeyRoom,boxRoom,bananasRoom};
    return monkeyBoxBananaArray;
  }
  

  public String monkeyStart(Scanner input){
    
    System.out.println("Select which room the monkey starts in:");
    System.out.println("[1] Room A");
    System.out.println("[2] Room B");
    System.out.println("[3] Room C");
    System.out.print("==> ");
    String monkeyRoom = input.nextLine();
    System.out.println("");
    return monkeyRoom;
  }

  public String boxStart(Scanner input){
    
    System.out.println("Select which room the box starts in:");
    System.out.println("[1] Room A");
    System.out.println("[2] Room B");
    System.out.println("[3] Room C");
    System.out.print("==> ");
    String boxRoom = input.nextLine();
    System.out.println("");
    return boxRoom;
  }

  public String bananasStart(Scanner input){
    
    System.out.println("Select which room the bananas start in:");
    System.out.println("[1] Room A");
    System.out.println("[2] Room B");
    System.out.println("[3] Room C");
    System.out.print("==> ");
    String bananasRoom = input.nextLine();
    System.out.println("");
    return bananasRoom;
  }
  
}