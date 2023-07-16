

public class Main {
  public static void main(String[] args) {
    //Creates two new points then says where they are located, then uses all the methods created
    Point a = new Point();
    Point b = new Point(3,4);
    System.out.println("Point A is at: " + a);
    System.out.println("Point B is at: " + b);
    a.setX(6);
    a.setY(8);
    System.out.println("Point A has been set to " + a);
    System.out.println("The distance from point A to point B is: " + a.distanceTo(b.getX(),b.getY()));
    System.out.println("The distance from point A to the origin is: " + a.distanceToOrigin());
    a.translate(-5,-5);
    System.out.println("Point A has been translated to " + a);

    System.out.println();

    //Creates two new lines then says where they are located, then uses all the methods created
    Line c = new Line();
    Line d = new Line(10,11,12,13);
    System.out.println("Line c has been set to the following points: " + c);
    System.out.println("Line d has been set to the following points: " + d);
    d.setX1(19);
    d.setY2(20);
    System.out.println("Line d's x1 has been set to " + d.getX1() + " and its y2 has been set to " + d.getY2());
    System.out.println("Therefore, line d has now been set to the following points: " + d);
    System.out.println("The length of d is: " + d.length());
    d.translate(-5,7);
    System.out.println("d has been translated to: " + d);

    System.out.println();

    //Creates two new circles then says where they are located, then uses all the methods created
    Circle c1 = new Circle();
    Circle c2 = new Circle(10,15,5);
    System.out.println("Circle c1 is located at: " + c1);
    System.out.println("Circle c2 is located at: " + c2);
    c1.setRadius(10);
    System.out.println("c1's radius has been set to " + c1.getRadius());
    c1.translate(8,-8);
    System.out.println("Circle c1 has been translated to " + c1);
    System.out.println("The statement that Point A is in the circle c1 is " + c1.contains(5,5));
    
    
  }
}