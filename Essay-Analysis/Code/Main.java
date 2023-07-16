import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

  
public class Main {
    private static File file = new File("Code/sampleEssay.txt");
    private static int[] lengthCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0};
  
    
  
  public static void printEssay() {
      
    

    
      try {
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
        String paragraph = sc.nextLine();
        System.out.println(paragraph);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    
  }
  public static void printWords() {
      try {
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
        String word = sc.next();
        System.out.println(word);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }    
  }
  public static void countWordLengths() {
          try {
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
        String word = sc.next();
        for(int i = 0; i <word.length();i++) {
          if(!(Character.isLetter(word.charAt(i)))){
                word = word.substring(0,i) + word.substring(i,word.length()-1);
            }
          }
        for(int i = 0; i<lengthCount.length;i++) {
          if(word.length()==i+1) {
            lengthCount[i]+=1;
          }
        }

        }
      } catch (Exception e) {
        e.printStackTrace();
      }    
      }
  public static void main(String[] args) {
    //printEssay();
    printWords();
    countWordLengths();
    System.out.println(Arrays.toString(lengthCount));
  }

}