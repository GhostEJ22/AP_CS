public class Line{

  //creates 4 instance variables
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  //creates a blank line then one with parameters
  public Line() {
    x1 = 0;
    y1 = 0;
    x2 = 1;
    y2 = 1;
  }
  
  public Line(int initx1, int inity1, int initx2, int inity2) {
    x1 = initx1;
    y1 = inity1;
    x2 = initx2;
    y2 = inity2;
  } 
  //gets the line end points then sets them
  public int getX1() {
    return x1;
  }
  public int getY1() {
    return y1;
  }
  public int getX2() {
    return x2;
  }
  public int getY2() {
    return y2;
  }
  public void setX1(int newx1) {
    x1 = newx1;
  }
  public void setY1(int newy1) {
    y1 = newy1;
  }
  public void setX2(int newx2) {
    x2 = newx2;
  }
  public void setY2(int newy2) {
    y2 = newy2;
  }
  //prints out the end points
  public String toString() {
        return ("(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
  }
  //translates the end points by a certain value
  public void translate(int moveX,int moveY) {
    x1 += moveX;
    y1 += moveY;
    x2 += moveX;
    y2 += moveY;
  }
  //finds the length of the line
  public double length() {
    return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)); 
  }

  
}