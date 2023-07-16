public class Main {
  //public static Scanner ask = new Scanner(System.in);

  public static boolean isSelfDivisor(int number) {
  //creates a num and then stores the original number in ogNum, since number will be changing
    int num;
    int ogNum = number;
    do {
      //gets the last digit of number, then checks to make sure that the digit isn't 0, and that the double of the ogNum/num is a whole number. If all this is true, it divides the number by 10, sets num = to the new number, and gets the first digit of that. then repeat
      num = number;
      num = number%10;
      
      if((double)num/ogNum!=0 && (double)ogNum/num==(int)ogNum/num){
          number/=10;
        }else return false;
    }while(number>0);
  return true;
  }
  
  public static String scrambleWord(String word) {
    //creates a scrambled word, and gets the first and second letter
    String scrambledWord = "";
    String firstLetter = "";
    String secondLetter = "";
    for (int i = 0;i < (word.length());i++){

      //of the first letter is a and the next one isn't, it switches the letters posititions and moves the letter you are looking at forward.
      if (i ==(word.length()-1)) {
        firstLetter = word.substring(i,i+1);

      } else {
        firstLetter = word.substring(i,i+1);
        secondLetter = word.substring(i+1,i+2);
      }
      if(firstLetter.equals("A") && !(secondLetter.equals("A"))) {
        scrambledWord = scrambledWord + secondLetter + firstLetter; 
        i++;
      }else {
          scrambledWord = scrambledWord + firstLetter;
      }
    }


    return scrambledWord;
  }
    public static void main(String[] args) {

    boolean Divisor = isSelfDivisor(128);
    System.out.println(Divisor);
    String scramble = scrambleWord("ABRACADABRA");
    System.out.println(scramble);

  }

}