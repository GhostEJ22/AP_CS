public class Bulbasaur extends Pokemon {
  private boolean isCharged;
  //constructors for instance variables in pokemon

  Bulbasaur() {
    super("Bulbasaur", 0, 0, 70, 3, 30);
    isCharged = false;
  }

  public Bulbasaur(int row, int col) {
    super("Bulbasaur", row, col, 70, 3, 30);
    isCharged = false;
  }
//is it charged
  public boolean getIsCharged() {
    return isCharged;
  }
  //attack and super attack damage and on who

  public void attack(Pokemon p) {
    p.deductHP(super.getStrength());
    System.out.print("Bulbasaur uses vine whip");

  }

  public void doSpecialMove(Pokemon p) {
    if (isCharged == true) {
      System.out.print("Bulbasaur uses solar beam on " + p.toString() + "\n");
      int Strengther = (int) (super.getStrength() * 1.5);
      p.deductHP(Strengther);
      System.out.println(p + " has " + p.getHP() + " HP");
      isCharged = false;
      System.out.println(p.getName() + " has " + p.getHP() + " HP");
    } else {
      System.out.println("charging...");
      isCharged = true;
    }

  }

  public String toString() {
    return super.toString();
  }
}
