  public class Main {
    public static void main(String[] args) {
      Shape a1 = new Shape("Polygon");
      System.out.println(a1.toString());
      Rectangle as = new Rectangle(1,10000);
      System.out.println(as.toString());
      Triangle a = new Triangle(10,10,10);
      System.out.println(a.toString());
      Square ab = new Square(393);
      System.out.println(ab.toString());
      EdTriangle abc = new EdTriangle(10);
      System.out.println(abc.toString());
    }
  }