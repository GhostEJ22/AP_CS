public class Main{
  public static void main(String[] args) {
    Game.setUp();
    //players
    Player p1 = new Player("Eric");
    Player p2 = new Player("Neal");

    
    //while the game isn't over, the players are looped through
    while (Game.gameOver()==false) {
      Game.takeTurn(p1);
      if(Game.gameOver()==false) {
        Game.takeTurn(p2);
      }
    }
  }
}