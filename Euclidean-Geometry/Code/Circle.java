public class Circle {
  //creates 3 instance variables
  private int centerX;
  private int centerY;
  private double radius;

  //creates a blank circle then creates one with parameters
  public Circle() {
    centerX=0;
    centerY=0;
    radius=1;
  }
  public Circle(int initcenterX,int initcenterY, int initradius) {
    centerX = initcenterX;
    centerY = initcenterY;
    radius = initradius;
  }
  //gets and sets the instance variables
  public int getCenterX() {
    return centerX;
  }
  public int getCenterY() {
    return centerY;
  }
  public double getRadius() {
    return radius;
  }
  public void setCenterX(int newCenterX) {
    centerX = newCenterX;
  }
  public void setCenterY(int newCenterY) {
    centerY = newCenterY;
  }
  public void setRadius(int newRadius) {
    radius = newRadius;
  }
  //prints the instance variables
  public String toString() {
    return "(" + centerX + ", " + centerY + ") with a radius of " + radius; 
  }
  //translates the x and y center points by a certain amount
  public void translate(int moveCenterX, int moveCenterY) {
    centerX+=moveCenterX;
    centerY+=moveCenterY;
  }
  //finds out if the circle contains a certain point
  public boolean contains(int containXValue, int containYValue){
    return Math.sqrt(Math.pow(containXValue-centerX,2) + Math.pow(containYValue-centerY,2)) < radius;
  }
}