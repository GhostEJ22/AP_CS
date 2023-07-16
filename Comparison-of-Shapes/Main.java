import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static boolean ask;

  public static String choice() {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> shapesAvail = new ArrayList<String>();
    shapesAvail.add("sq");
    shapesAvail.add("rect");
    shapesAvail.add("tri");
    shapesAvail.add("edtri");
    shapesAvail.add("quit");
    String answer = "";
    do {
      System.out.print("Your options are [rect, sq, tri, edtri, quit]. Select one: ");
      answer = sc.nextLine().toLowerCase();

    } while (!(shapesAvail.contains(answer)) && ask == true);
    ask = false;
    return answer;
  }

public static String describe(Shape s) {
  return s.describe();
}
  
  public static void main(String[] args) {
    ArrayList<Shape> shapesAdded = new ArrayList<Shape>();
    Scanner sc = new Scanner(System.in);
    ask = true;
    String choice = "";
    while (!(choice.equals("quit")) && ask == true) {
      choice = choice();
      if (choice.equals("sq")) {
        System.out.print("What is the length of a side? ");
        int side = sc.nextInt();
        if (side <= 0) {
          do {
            System.out.print("Nope try again ");
            side = sc.nextInt();
          } while (side <= 0);
        }
        shapesAdded.add(new Square(side));
        ask = true;

      }
      if (choice.equals("rect")) {
        System.out.print("Width? ");
        int width = sc.nextInt();
        if (width <= 0) {
          do {
            System.out.print("Nope try again ");
            width = sc.nextInt();
          } while (width <= 0);
        }
        System.out.print("height? ");
        int height = sc.nextInt();
        if (height <= 0) {
          do {
            System.out.print("Nope try again ");
            height = sc.nextInt();
          } while (height <= 0);

        }
        shapesAdded.add(new Rectangle(width, height));
        ask = true;
      }
      if (choice.equals("edtri")) {
        System.out.print("What is the length of all three sides? ");
        int triside = sc.nextInt();
        if (triside <= 0) {
          do {
            System.out.print("Nope try again ");
            triside = sc.nextInt();
          } while (triside <= 0);
        }
        shapesAdded.add(new EdTriangle(triside));
        ask = true;

      }
      if (choice.equals("tri")) {
        System.out.print("s1? ");
        int s1 = sc.nextInt();
        if (s1 <= 0) {
          do {
            System.out.print("Nope try again ");
            s1 = sc.nextInt();
          } while (s1 <= 0);
        }
        System.out.print("s2? ");
        int s2 = sc.nextInt();
        if (s2 <= 0) {
          do {
            System.out.print("Nope try again ");
            s2 = sc.nextInt();
          } while (s2 <= 0);
        }
        System.out.print("s3? ");
        int s3 = sc.nextInt();
        if (s3 <= 0) {
          do {
            System.out.print("Nope try again ");
            s3 = sc.nextInt();
          } while (s3 <= 0);

        }
        shapesAdded.add(new Triangle(s1, s2, s3));
        ask = true;
      }
    }
    if(choice.equals("quit")) {
      for(int i = 0; i<shapesAdded.size();i++) {
        System.out.println("Shape " + (i+1) + " " + shapesAdded.get(i).describe());
      }
      System.out.println("");
      double maxPerim = shapesAdded.get(0).perim();
      double maxArea = shapesAdded.get(0).area();
      String whatHasMP = shapesAdded.get(0).describe();
      String whatHasMA = shapesAdded.get(0).describe();
      for(int i = 0; i<shapesAdded.size();i++) {
        if(shapesAdded.get(i).perim()>maxPerim) 
        {
          maxPerim = shapesAdded.get(i).perim();
          whatHasMP = shapesAdded.get(i).describe();
        }
        if(shapesAdded.get(i).area()>maxArea) 
        {
          maxArea = shapesAdded.get(i).area();
          whatHasMA = shapesAdded.get(i).describe();
        }
      }
      System.out.println("Max perim: " + whatHasMP + " With a perim of " + maxPerim );
      System.out.println("Max Area: " + whatHasMA + " With area of " + maxArea);
    }
    
  }
}
