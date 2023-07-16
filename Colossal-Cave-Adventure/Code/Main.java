import java.util.Scanner;

public class Main {
  public static Scanner ask = new Scanner(System.in);
  //Creates the coordinate plane
  public static int x = 0;
  public static int y = 0;
  public static boolean talk = true;

  public static void findLocation(String local) {

    //Moves you up(north), down(south), or right(east) depending on your input
    if(local.equals("n")){
      y+=1;
    }
    if(local.equals("s")){
      y-=1;
    }
    if(local.equals("e")){
      x+=1;
    }
    if(local.equals("w")){
      x-=1;
    }
    //Prints where you are based on the coordinate system
    //Based on the game Colossal Cave Adventure, the coordinate system is only valid between the x values of o to 1 and the y coordinates are only valid from -1 to 1 
    if(x <= -1 || x >= 2 || y >=2 || y<=-2 || (y==-1 && x==1) || (y==1 && x==1)) {
      System.out.println("You can't go this way.");   
    }

    if(y==-1 && x==1 && local.equals("s")) {
      talk = false;
      x=1;
      y=0;
    }
    else if(y==1 && x==1 && local.equals("n")) {
      talk = false;
      x=1;
      y=0;
    }
    else talk=true;
    if(y > 0){
      if(y<2 ) {
        if(x==0) {
        System.out.println("You're in the woods");
        }
        else{
          x=0;
        }
        
      }
      else{
        y=1;
      }
    }
    if(y < 0){
      if(y > -2) {
        if(x==0) {
          System.out.println("You're at the sea");
        }
        else{
          x=0;
        }
      }
      else {
        y=-1;
      }
    }
    if(x > 0){
      if(x < 2 ){
        if(y==0) {
          if(talk!=false) {
            System.out.println("You're at the beach shack"); 
          }
        }
        else{
          y=0;
        }
      }
      else {
        x=1;
        
      }
    }
    if(x < 0){
      x=0;
    }
    if(x == 0 && y == 0){
      System.out.println("You're back where you started");
    }
    
  }
  public static void main(String[] args) {
    //Prints the starting info
    System.out.println("You are on an island surrounded by water.\n" + "There is a path to the woods to the north, the sea is to the south, and there is a beach shack to the east.");
    System.out.print("Which way do you want to go (n,s,e,w)? ");    
    //Asks the questions over and over three times(question1,question2, and question3)  
  for(int x = 0;true;x++) {  
    String question1 = ask.nextLine();
      findLocation(question1);
      System.out.print("\n");
      System.out.print("Which way do you want to go (n,s,e,w)? ");        
  }
  
  }
}