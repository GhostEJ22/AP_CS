public class Triangle extends Shape {
  private int s1;
  private int s2;
  private int s3;
  public Triangle() {
    super("Triangle");
    s1=1;
    s2=2;
    s3=3;
  }
  public Triangle(String porque, int ss1, int ss2, int ss3) {
    super(porque);
    s1=ss1;
    s2=ss2;
    s3=ss3;
  }
  public Triangle(int ss1, int ss2, int ss3) {
    super("Triangle");
    s1 = ss1;
    s2 = ss2;
    s3 = ss3;
  }
  public double perim() {
    return s1 + s2 + s3;
  }
  public double area() {
    double s = perim()/2;
    return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3)); 
  }
  public String toString() {
    return super.toString();
  }
  public String describe() {
    return "The shape is a/an triangle with side lengths " + s1 + ", " + s2 + ", " + s3; 
  }
}