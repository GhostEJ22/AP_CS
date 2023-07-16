public class Police extends Building {
  //number of cells in jail
  private int numCells;

  //constructors
  public Police() {
    super(1500000);
    numCells = 5;
  }
  public Police(int cells) {
    super(1500000);
    numCells = cells;
  }
  
  //what you are doing and prints the info(toString)
  public String action() {
    return " and there are ";
  }
  public String toString() {
    return super.toString() + numCells + " cells.";
  }
}