public class Player {
  private String name;
  private int currentWinnings;
  //basic constructor
  public Player(String initname) {
    name = initname;
    currentWinnings = 0;
  }
  //basic methods to get the winnings and change it 
  public int getCurrentWinnings() {
    return currentWinnings;
  }

  public void setCurrentWinnings(int newWinnings) {
    currentWinnings = newWinnings;
  }
  public void deposit(int amount) {
    currentWinnings += amount;
  }
  public void withdraw(int amount) {
    currentWinnings -= amount;
  }
  public String toString() {
    return name;
  }
}