public class Point{
  //creates two instance variables
  private int X;
  private int Y;

  //creates a empty point then one with parameters
  public Point() {
    X = 0;
    Y = 0;
  }
  public Point(int initXint, int initYint) {
    X = initXint;
    Y = initYint;
  }

  //sets the x and y int and then get its
  public int getX() {
    return X;
  }
  public int getY() {
    return Y;
  }
  public void setX(int newXint) {
    X = newXint;
  }
  public void setY(int newYint) {
    Y = newYint;
  }
  //prints the x and y ints
  public String toString() {
    return ("(" + X + ", " + Y + ")");
  }
  //translates them
  public void translate(int changeXint, int changeYint) {
    X+=changeXint;
    Y+=changeYint;
  }
  //finds distance from the center 
  public double distanceToOrigin() {
    double distance= Math.sqrt(Math.pow(X,2) + Math.pow(Y,2));
    return distance;
  }
  //finds distance from a  certain point
  public double distanceTo(int a, int b) {
    double distance= Math.sqrt(Math.pow(a-X,2) + Math.pow(b-Y,2));
    return distance;
  }
}