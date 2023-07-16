public class Charmander extends Pokemon {
  private int numOfGrowls;
//constructors for instance variables
  public Charmander() {
    super("Charmander", 0, 0, 50, 4, 20);
    numOfGrowls = 3;
  }

  public Charmander(int row, int col) {
    super("Charmander", row, col, 50, 4, 20);
    numOfGrowls = 3;
  }
//how many left
  public int getNumOfGrowls() {
    return numOfGrowls;
  }
  //attack and super attack damage and on who

  public void attack(Pokemon p) {
    p.deductHP(super.getStrength());
    System.out.print("Charmander uses ember");
  }

  public void doSpecialMove(Pokemon p) {
    if (numOfGrowls > 0) {
      System.out.print("Charmander uses growl. " + p.getName() + " attack goes from " + p.getStrength() + " to "); 
      p.deductAttack();
      System.out.print(p.getStrength() + "\n");
      numOfGrowls--;
      System.out.println("Charmander has " + numOfGrowls + " growls left");
    } else
      System.out.println("Charmander is out of growls!!!");

  }

  public String toString() {
    return super.toString();
  }
}