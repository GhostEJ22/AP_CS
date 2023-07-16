 import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gradebook {
  //instance variables
  private String gradebookName;
  private ArrayList<Assignment> grades;
  private int assignmentNum;
//constructor
  public Gradebook(String initGN) {
    gradebookName = initGN;
    grades = new ArrayList<Assignment>();
    assignmentNum = 0;
  }
//getters and setters
  public String getClassName() {
    return gradebookName;
  }
  public ArrayList<Assignment> getGrades() {
    return grades;
  }
  public int getAssignmentNum() {
    return assignmentNum;
  }
  public void setClassName(String initGN) {
    gradebookName = initGN;
  }
  public void setGrades(ArrayList<Assignment> initG) {
    grades = initG;
  }
  public void setAssignmentNum(int initAN) {
    assignmentNum = initAN;
  }
  public void show() {
    //Shows the stuff put in in add()
    System.out.println(gradebookName + " Grades:");
    for(Assignment element: grades) {
      System.out.printf("\t%-30s %-20s %-10.2f %.2f %n", element.getName(), element.getType(), element.getPointsEarned(), element.getPointsTotal());
      
    }
  }
  public void add() {
    //gets the assignment instance variables and adds it to the gradebook ArrayList
    Scanner ask = new Scanner(System.in);
    assignmentNum++;
    System.out.print("Enter Assignment " + assignmentNum + "'s name: ");
    String nam = ask.nextLine();
    
    System.out.print("Enter Assignment " + assignmentNum + "'s type: ");
    String typ = ask.nextLine();
    System.out.print("Enter the points earned on the assignment: ");
    int earne = ask.nextInt();
    System.out.print("Enter the total points on the assignment: ");
    int tota = ask.nextInt();
    grades.add(new Assignment(nam,typ,earne,tota));
  }
  //removes an assignment specified by the user
  public void remove() {
    Scanner ask = new Scanner(System.in);
    System.out.print("Which assignment # do you want to remove? ");
    int remove = ask.nextInt();
      
    while(remove>assignmentNum || remove<=0) {
      System.out.print("Invalid #; try again: ");
      remove = ask.nextInt();
    };
    grades.remove(remove-1);
    assignmentNum--;
  }
  //modifies an exising grade
  public void modify() {
    Scanner ask = new Scanner(System.in);
    System.out.print("Which assignment would you like to modify? ");
    int modify = ask.nextInt();
      
    while(modify>assignmentNum || modify<=0) {
      System.out.print("Invalid #; try again: ");
      modify = ask.nextInt();
    };
    int storedValue=assignmentNum;
    assignmentNum=modify-1;
    assignmentNum++;
    ask.nextLine();
    System.out.print("Enter Assignment " + assignmentNum + "'s name: ");
    String nam = ask.nextLine();
    System.out.print("Enter Assignment " + assignmentNum + "'s type: ");
    String typ = ask.nextLine();
    System.out.print("Enter the points earned on the assignment: ");
    int earne = ask.nextInt();
    System.out.print("Enter the total points on the assignment: ");
    int tota = ask.nextInt();
    
    
    grades.set(modify-1,new Assignment(nam,typ,earne,tota));
    assignmentNum=storedValue;
  }
//calculates your overall grade 
  public double calculate() {
    double total=0;
    double totalDivisor=0;
    double percent;
    for(Assignment num: grades) {
      total+= (double)num.getPointsEarned();
      totalDivisor += (double)num.getPointsTotal();
    }
    percent = (total/totalDivisor)*100;
    return percent;
  }
}