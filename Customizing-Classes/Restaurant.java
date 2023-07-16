public class Restaurant extends Building{
  //type of food being put in restaurant
  private String TypeofFood;
  
  //two constructors
  public Restaurant() {
    super(1000000);
    TypeofFood = "Sandwiches";
  }
  public Restaurant(String choice) {
    super(1000000);
    TypeofFood = choice;
  }
  //what you are doing and prints the info(toString)
  public String action() {
    return " and you are putting ";
  }
  public String toString() {
    return super.toString() + TypeofFood + " on the menu.";
  }
}