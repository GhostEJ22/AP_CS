import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static Integer smallest(ArrayList<Integer> abc) {
    Integer small = abc.get(0);
    for (Integer num: abc) {
      if(num<small) {
        small = num;
      }
    }
    return small;
  }
  
  public static String longest(ArrayList<String> def) {
    String biggest = def.get(0);
    for (int i = 0; i <def.size();i++) {
      String current = def.get(i);
      if(current.length()>biggest.length()) {
        biggest = def.get(i);
      }
    }
    return biggest;
  }

  public static void remove(ArrayList<Student> period, String name) {
    for(int i = 0; i<period.size(); i++) {
      if(period.get(i).getName().equals(name)) {
        period.remove(i);
      }
    }      
  }
  
  public static void main(String[] args) {
    Integer[] nums = {12,5,9,10,15,20,8};
    ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(nums));
    System.out.println(smallest(numbers));
    String[] words = {"hi", "Mr.Park", "this", "isn't", "fun"};
    ArrayList<String> wordss = new ArrayList<String>(Arrays.asList(words));
    System.out.println(longest(wordss));
    Student[] people = {new Student(), new Student("Eric",11,4.4), new Student("Neal",11,4.39)};
    ArrayList<Student> period1 = new ArrayList<Student>(Arrays.asList(people));
    System.out.println(period1);
    remove(period1,"Neal");
    System.out.println(period1);
    
  }
}