public class Rectangle extends Shape {
  private int length;
  private int width;

  public Rectangle() {
    super("Rectangle");
    length = 2;
    width = 1;
  }
  public Rectangle(String why, int le, int wi) {
    super(why);
    length=le;
    width=wi;
  }
  public Rectangle(int le, int wi) {
    super("Rectangle");
    length = le;
    width = wi;
  }
  public double perim() {
    return 2*length + 2*width;
  }
  public double area() {
    return length*width;
  }
  public String toString() {
    return (super.toString());
  }
  public String describe() {
    return "The shape is a/an rectangle with side length " + length + ", and width " +width; 
  }
}