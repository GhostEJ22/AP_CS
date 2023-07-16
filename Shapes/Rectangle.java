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
  public int perim() {
    return 2*length + 2*width;
  }
  public int area() {
    return length*width;
  }
  public String toString() {
    return (super.toString() + ": length: " + length + ", width: " + width + ", perim: " + perim() + ", area: " + area());
  }
}