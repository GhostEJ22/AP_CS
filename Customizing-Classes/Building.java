public class Building {
  //instance variable for the cost of the building
  private int Avg_Cost;

  //constructors 
  public Building() {
    Avg_Cost = 750000;
  }
  public Building(int AC) {
    Avg_Cost = AC;
  }
  //what you are doing and prints the info(toString)
  public String action() {
    return " and you are walking through the door.";
  }
  public String toString() {
    return "The cost is $" + Avg_Cost + action();
  }
}