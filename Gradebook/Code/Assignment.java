import java.util.ArrayList;
import java.util.Arrays;

public class Assignment {
//instance variables
  private String assignmentName;
  private String assignmentType;
  private double pointsEarned;
  private double totalPoints;

  public Assignment(String initAN, String initAT, double initPE, double initTP) {
    //constructor
    assignmentName=initAN;
    assignmentType=initAT;
    pointsEarned=initPE;
    totalPoints=initTP;
  }
//getters and setters
  public String getName() {
    return assignmentName;
  }
  public String getType() {
    return assignmentType;
  }
  public double getPointsEarned() {
    return pointsEarned;
  }
  public double getPointsTotal() {
    return totalPoints;
  }
  
  public void setName(String AN) {
    assignmentName = AN;
  }
  public void setType(String AT) {
    assignmentType=AT;
  }
  public void setPointsEarned(double PE) {
    pointsEarned = PE;
  }
  public void setPointsTotal(double TE) {
    totalPoints = TE;
  }
  public String toString() {
    return (assignmentName + "; " + assignmentType + "; " + pointsEarned + "; " + totalPoints);
  }
}