public class Main {
  public static void main(String[] args) {
    Student s1 = new Student("Neal",11,false);
    Roster.showInfo(s1);

    Student s2 = new Student("Eric",11,true);
    Roster.showInfo(s2);

    Student s3 = new Student("Mason",11,true);
    Roster.showInfo(s3);

    Roster.showAttendance();
  }
}