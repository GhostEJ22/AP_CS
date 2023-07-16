public class Student {
  private String StudentName;
  private int grade;
  private boolean present;

  public Student() {
    StudentName = "";
    grade = 0;
    present = false;
    Roster.updateNumOfStudents();
    Roster.updateAttendance(present);
  }
  public Student(String initName, int initgrade, boolean initpresent) {
    StudentName = initName;
    grade = initgrade;
    present = initpresent;
    Roster.updateNumOfStudents();
    Roster.updateAttendance(present);
  }
  public String getName() {
    return StudentName;
  }
  public int getGrade() {
    return grade;
  }
  public boolean getPresent() {
    return present;
  }
  
}