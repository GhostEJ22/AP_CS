public class Roster {
  private static int numOfStudents=0;
  private static int numPresent=0;
  private static int numAbsent=0;

  
  public static void showInfo(Student s) {
    String presOabs = "";
    if(s.getPresent()==false) {
      presOabs = "absent";
    } else {
      presOabs = "present";
    }
    System.out.println("This student is " + s.getName() + " who is in grade " + s.getGrade() + ". \n" + s.getName() + " is " + presOabs + ".\n");
    
  }

  public static void updateNumOfStudents() {
    numOfStudents+=1;
  }

  public static void updateAttendance(boolean isPresent) {
    if(isPresent==true) {
      numPresent+=1;
    } else {
      numAbsent+=1;
    }
  }

  public static void showAttendance() {
    System.out.println("The total number of students present is " + numPresent);
    System.out.println("The total number of students absent is " + numAbsent);
  }
}