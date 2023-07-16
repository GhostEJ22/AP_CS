import java.util.Scanner;

public class Main {
  //creates a scanner to ask questions
  public static Scanner ask = new Scanner(System.in);

  //This defines the tax brackets and how much of your income gets taxed in each one
  //We decided to go with option b to find the tax, as to us it made more logical sense
  public static double calcTax(double salary) {
    double totalTaxed=0;
    if(salary>539900) {
      double taxedSalary = salary-539900;
      double taxedAmount = taxedSalary*0.37;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    if(salary>215950 && salary <=539900) {
      double taxedSalary = salary - 215950;
      double taxedAmount = taxedSalary*0.35;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    if(salary>170050 && salary <= 215950) {
      double taxedSalary = salary - 170050;
      double taxedAmount = taxedSalary*0.32;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    if(salary>89075 && salary <=170050) {
      double taxedSalary = salary - 89075;
      double taxedAmount = taxedSalary*0.24;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    if(salary>41775 && salary <= 89075) {
      double taxedSalary = salary - 41775;
      double taxedAmount = taxedSalary*0.22;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    if(salary>10275 && salary <= 41775) {
      double taxedSalary = salary - 10275;
      double taxedAmount = taxedSalary*0.12;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    if(salary<=10275) {
      double taxedSalary = salary;
      double taxedAmount = taxedSalary*0.10;
      totalTaxed+=taxedAmount;
      salary-=taxedSalary;
    }
    return totalTaxed;
  }
  
  //This rounds whatever value you want to whatever decimal place you want
  public static String round(double amount, int decimalPlace) {
    String rounded = String.format("%." + decimalPlace + "f", amount);
    return rounded;
      }

  //This calculates your new salary based on the rating you inputed. The higher the rating, the better the bonus
  public static double calcNewSalary(String rating, double salary) {
    if(rating.equals("A"))
      return salary + (salary * 0.20);
    else if(rating.equals("B"))
      return salary + (salary * 0.08);
    else if(rating.equals("C"))
      return salary + (salary * 0.04);
    else if(rating.equals("D"))
      return salary + (salary * 0.02);
    else if(rating.equals("F"))
      return salary;
    else
      return salary = -1;
  }
    
  
  public static void main(String[] args) {
    //Asks the user for their salary then calculates the amount taxed on it and the percentage of tax payed.
    System.out.print("Enter your Salary: ");
    double salaryAnswer = ask.nextDouble();

    double amountTaxed = calcTax(salaryAnswer);
    
    System.out.println("The total amount of federal tax you must pay is " + round(amountTaxed, 2) + ".");
    System.out.println("The percentage of federal income tax you pay is " + round((amountTaxed/salaryAnswer)*100,3) + "%.");
    System.out.println();
    ask.nextLine();

    //Gets the users rating to find their bonus, then calculates their newSalary and what their new tax and tax percentage would be
    System.out.print("Now, what is your rating? ");
    String rating = ask.nextLine();
    double newSalary = calcNewSalary(rating,salaryAnswer);
    double newTax = calcTax(newSalary);
    
    //If they received a bonus it prints the new tax and tax percentage. If they received no bonus it prints no bonus, and if they input an invalid value it tells the user it was invalid. Must be in uppercase to be valid.
    if(rating.equals("A") || rating.equals("B") || rating.equals("C") || rating.equals("D")){
      System.out.println("The new total amount of federal tax you must pay is " + round(newTax,2) + ".");
      System.out.println("The new percentage of federal income tax you pay is " + round((newTax/newSalary)*100,3) + "%.");
    }
    else if(rating.equals("F")) {
      System.out.println("No raise for you :-(");
    }
    else {
      System.out.println("Uh... that's not a valid rating");
    }
  }

}