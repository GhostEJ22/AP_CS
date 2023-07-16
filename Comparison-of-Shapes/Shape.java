public class Shape {
  private String name;
  public Shape() {
    name = "polygon";
      }
  public Shape(String b) {
    name = b;
  }
  public String toString() {
    return name;
  }
  public String describe() {
    return "The shape is a/an polygon"; 
  }
  public double perim() {
    return 0;
  }
  public double area() {
    return 0;
  }
  }

