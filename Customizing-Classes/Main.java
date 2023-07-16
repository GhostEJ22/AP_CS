import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    //creates the building superclass
    Scanner sc = new Scanner(System.in);
    System.out.print("You are building 5 building! What do you want the cost to be of the first one? This is the only cost that you will get to choose!! ");
    int val = sc.nextInt();
    Building a = new Building(val);
    System.out.println(a);
    //creates the restaurant subclass
    System.out.print("You'll now be building a restaurant! What main food do you want there? ");
    sc.nextLine();
    String food = sc.nextLine();
    Restaurant mine = new Restaurant(food);
    System.out.println(mine);
    //creates the police subclass
    System.out.print("You'll now be building a local county jail... how many cells do you want? ");
    int cells = sc.nextInt();
    Police cell = new Police(cells);
    System.out.println(cell);
    //creates the gym subclass
    System.out.print("Now you're building a gym! What do you want to name it? ");
    sc.nextLine();
    String gymName = sc.nextLine();
    System.out.print("And how high should the dumbbell weights go? ");
    int weightLevel = sc.nextInt();
    Gym WL = new Gym(gymName, weightLevel);
    System.out.println(WL);
    //creates the school subclass and ends the code afterwards
    System.out.print("Lastly, you are building a school! How many teachers do you wanna hire? ");
    sc.nextLine();
    int numteach = sc.nextInt();
    School schoools = new School(numteach);
    System.out.println(schoools);
    System.out.println("Congrats! You created all 5 buildings... and are now severely in debt.");
  }
}