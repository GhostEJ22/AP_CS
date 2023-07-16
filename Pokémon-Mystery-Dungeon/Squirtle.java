public class Squirtle extends Pokemon {
  private int shieldHP;
  //constructors for instance variables in pokemon

  public Squirtle() {
    super("Squirtle", 0, 0, 100, 2, 40);
  }

  public Squirtle(int row, int col) {
    super("Squirtle", row, col, 100, 2, 40);
  }
//get shield
  public int getShieldHP() {
    
    return shieldHP;
  }

  public void setShieldHP(int a) {
    shieldHP = a;
  }
  //attack and super attack damage and on who

  public void attack(Pokemon p) {
    p.deductHP(super.getStrength());
    System.out.print("Squirtle uses water gun");

  }

  public void doSpecialMove(Pokemon p) {
    System.out.print("Squirtle uses defense curl. " + p.getName() + " gets flustered!\n\n\n");
    shieldHP=25;
    
  }

  public String toString() {
    return super.toString();
  }
}