public class EdTriangle extends Triangle {
  private int side;
  public EdTriangle() {
    super("EdTriangle",1,1,1);
    side = 1;
  }
  public EdTriangle(int s) {
    super("EdTriangle",s,s,s);
    side = s;
  }
    
    
  public double perim() {
    return side*3;
  }
  public double area() {
    return (Math.sqrt(3)/4) * Math.pow(side,2);
  }
  public String toString() {
    return super.toString();
}
  public String describe() {
    return "The shape is a/an edtriangle with side lengths of " + side; 
  }
}