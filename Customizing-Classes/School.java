public class School extends Building {
  //number of teachers being hired
  private int numTeachers;

  //constructors
  public School() {
    super(45000000);
    numTeachers=40;
  }
  public School(int num) {
    super(45000000);
    numTeachers = num;
  }

  //what you are doing and prints the info(toString)
  public String action() {
    return " and you are hiring ";
  }
  public String toString() {
    return super.toString() + numTeachers + " teachers.";
  }
}