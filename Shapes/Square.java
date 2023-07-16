public class Square extends Rectangle{
  private int sideSize;

  public Square() {
    super("Square", 1, 1);
    sideSize=1;
  }
  public Square(int size) {
    super("Square", size, size);
    sideSize = size;
  }
  public int perim() {
    return 2*sideSize + 2*sideSize;
  }
  public int area() {
    return sideSize * sideSize;
  }
  public String toString() {
    return (super.toString());
  }
}