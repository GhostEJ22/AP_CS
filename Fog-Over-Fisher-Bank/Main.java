import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Game g = new Game();
    g.initialize();
    while(g.gameOver()==false) {
      g.takeTurn("player");
      Thread.sleep(5000);
      if(g.gameOver()==false) {
        g.takeTurn("CPU");
        Thread.sleep(5000);
      }
    }
    g.result();
  }
}