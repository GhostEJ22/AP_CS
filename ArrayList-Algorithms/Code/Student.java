public class Student {
  private String name;
  private int grade;
  private double GPA;

  public Student() {
    name = "Batman";
    grade = 12;
    GPA = 0.0;
  }

  public Student(String name, int grade, double GPA) {
    this.name = name;
    this.grade = grade;
    this.GPA = GPA;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return (name + "; " + grade + "; " + GPA +".");
  }
}