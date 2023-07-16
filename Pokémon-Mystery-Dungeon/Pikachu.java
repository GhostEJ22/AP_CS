public class Pikachu extends Pokemon {
  /* ENTER CONSTRUCTORS BELOW */
    //constructors for instance variables in pokemon

  public Pikachu() {
    super("Pikachu", 0, 0, 50, 5, 10);
  }

  public Pikachu(int row, int col) {
    super("Pikachu", row, col, 50, 5, 10);
  }
  //attack damage and on who
  public void attack(Pokemon p) {
    /* ENTER YOUR CODE BELOW */
    p.deductHP(super.getStrength());
    System.out.println("Pikachu uses quick attack on " + p.toString());
    if(p.getName().equals("Squirtle")) {
      Squirtle v = (Squirtle) p;
      int leftOver = v.getShieldHP()-super.getStrength();
      if(leftOver<0) {
        v.deductHP(Math.abs(leftOver));
        v.setShieldHP(0);
      }
      else {
        v.setShieldHP(leftOver);
      }
    
    }

  }

  public String toString() {
    return super.toString();
  }

}