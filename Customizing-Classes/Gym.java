public class Gym extends Building {
  //name of the gym and the amount of weight the dumbbells will go up to
  private String name;
  private int weights;

  //constructors
  public Gym() {
    super(5000000);
    name = "lifetime";
    weights = 140;
  }
  public Gym(String n, int w) {
    super(5000000);
    name = n;
    weights = w;
  }  

  //what you are doing, the weights the dumbbells go up to, and prints the info(toString)
  public String action() {
    return ". You named the gym ";
  }
  public String weights() {
    return " and added dumbbells up to ";
  }
  public String toString() {
    return super.toString() + name + weights() + weights + " lbs.";
  }
}