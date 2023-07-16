import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws InterruptedException{
    Scanner ask = new Scanner(System.in);
//user name, then loop
    System.out.print("Hello!! This is Pokemon Mystery Dungenon!\nWhat's your name?? ");
    String personName = ask.next();
    boolean userTurn = true;
    Board game = new Board();
    
    game.setUp();
    game.show();
    
    while (game.isGameOver()==false) {
      game.takeTurn(personName);
      if(game.isGameOver()==false) {
        game.takeTurn("CPU");
      }
    }
    ask.close();
  }
}