import java.util.Scanner;

public class Main{
  public static Scanner ask = new Scanner(System.in);

  public static void showGeneratorInfo(NumberGenerator generator,int numGenerator) {
    //does all the calculations then gets the values and prints them
    generator.randomize();
    generator.calcMinAndMax();
    generator.calcMean();
    generator.calcMedian();
    generator.calcSD();
    System.out.println("NUMBER GENERATOR " + numGenerator + ":" );
    System.out.println("Minimum value: \t\t" + generator.getMin());
    System.out.println("Maximum value: \t\t" + generator.getMax());
    System.out.println("Mean value: \t\t" + String.format("%.2f",generator.getMean()));
    System.out.println("Median value: \t\t" + generator.getMedian());
    System.out.println("Standard deviation: " + String.format("%.2f",generator.getSD()));
    System.out.print("The order:\t\t\t");
    generator.showAllValues();
    System.out.println();
    System.out.print("The reverse order:\t");
    generator.reverse();
    generator.showAllValues();
    System.out.println("\n");
  }
  public static NumberGenerator[] createNumberGenerators(int size, int create) {
    //creates a certain number of lists(create) at a certain length(size)
    NumberGenerator[] b = new NumberGenerator[create];
    NumberGenerator a;
    for(int i = 0; i<create;i++) {
      a = new NumberGenerator(size);
      showGeneratorInfo(a,i+1);
      b[i] = a;
      
      
    }
    return b;
    

  }
  public static void compare(NumberGenerator[] all) {
    //calculates the overall min and max and mean of all the arrays together and prints them
    int min=all[0].getMin();
    int max=all[0].getMax();
    double mean = 0;
    int checkMin=0;
    int checkMax=0;
    for(int i = 0; i<all.length;i++){
      
      if(min>all[i].getMin()) {
        min = all[i].getMin();
        checkMin=i+1;
      }
      if(max<all[i].getMax()) {
        max = all[i].getMax();
        checkMax=i+1;
      }
      mean+=all[i].getMean();
        
      }
      mean/=all.length;
      System.out.println("The NumberGenerator object with the lowest min is #" + checkMin + " with a min of " + min);
      System.out.println("The NumberGenerator object with the highest max is #" + checkMax + " with a max of " + max);
      System.out.println("The average of all the NumberGenerator objects is " + String.format("%.2f",mean));  
    }
    
  
  public static void main(String[] args) {
    
    //This will be the length of each array
    int randomVals=0;
    do {
      System.out.print("Enter a value between 5 and 50 to set the size of a single NumberGenerator object: ");
      randomVals = ask.nextInt();
    }while(5>=randomVals || randomVals>=50);

    //This will be the number of arrays
    int numObjects=0;
    do {
      System.out.print("Enter a value between 3 and 10 to determine how many NumberGenerator object to instantiate: ");
      numObjects = ask.nextInt();
    }while(3>=numObjects || numObjects>=10);

    
    NumberGenerator[] c=createNumberGenerators(randomVals,numObjects);
    compare(c);;
  }
  
}