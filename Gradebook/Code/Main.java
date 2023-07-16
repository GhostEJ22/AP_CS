import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
  private static String answer="";
//asks the user what they want to do
  public static void MakeCall() {
    Scanner ask = new Scanner(System.in);
    do {
      System.out.print("Would you like to add, remove, modify, show, calculate, or quit? ");
      answer=ask.nextLine();
      answer=answer.toLowerCase();

    }while(!(answer.equals("show") || answer.equals("modify") || answer.equals("add") || answer.equals("remove") || answer.equals("calculate") || answer.equals("quit")));
    }
  
  public static void main(String[] args) {
    Scanner ask = new Scanner(System.in);

    //creates gradebook object 
    Gradebook one= new Gradebook("Computer Science");
    System.out.println("Welcome to the gradebook!\n");
    //specifies what to do based on the MakeCall() thingie
    while(!(answer.equals("quit"))){
      MakeCall();
        if(answer.equals("show")) {
          one.show();
          System.out.println();          
        }
        if(answer.equals("modify")) {
          one.modify();
          System.out.println();          
        }
        if(answer.equals("add")) {
          one.add();
          System.out.println();
        }
        if(answer.equals("remove")) {
          one.remove();
          System.out.println();          
        }
        if(answer.equals("calculate")) {
          String calced = String.format("%.2f",one.calculate());
          System.out.println("The final percentage is " + calced);    
          System.out.println();
        }
    
    

    }
  }
}