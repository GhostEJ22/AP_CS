import java.util.Scanner;
import java.util.Random;
import java.util.List;

public class Main {
  public static Scanner ask = new Scanner(System.in);
  // Global variables
  private static String secretPhrase = "";
  private static String guessPhrase = "";
  private static int numOfParts = 2;
  private static int numOfGuesses = 0;

  /* Helps test cases set the secretPhrase to use for the duration of the game.
   * Do NOT use this method in your code!
   */
  public static void setSecretPhrase(String phrase) {
    secretPhrase = phrase;
  }

  /* Helps test cases easily get the secretPhrase variable.
   * Do NOT use this method in your code!
   */
  public static String getSecretPhrase() {
    return secretPhrase;
  }

  public static void setGuessPhrase(String secretPhrase) {
    // ENTER YOUR CODE BELOW
    //Turns the phrase into a bunch of underscores and spaces
    guessPhrase="";
    String firstLetter="";

    for(int i = 0;i<secretPhrase.length();i++) {
      firstLetter=(secretPhrase.substring(i,i+1));
      if(!(firstLetter.equals(" "))) {
        guessPhrase+="_";
      } else guessPhrase+= " ";
    }
     

  }

  /* Helps test cases easily get the guessPhrase variable.
   * Do NOT use this method in your code!
   */
  public static String getGuessPhrase() {
    return guessPhrase;
  }

  // ENTER REMAINING METHODS BELOW
  public static String displayGuess(String guessPhrase) {
    //resets the guessedPhrase, and turns the guessed phrase into blank spaces
    String guessPhrase2="";
    for(int i = 0;i<guessPhrase.length();i++) {
        guessPhrase2+=guessPhrase.substring(i,i+1) + " ";
    }

    return guessPhrase2;  
  }
  public static String getGuess(){
    //gets a letter that the user guesses and adds that guess to the total number of guesses
    String guess;
    System.out.print("Guess a character: ");
    guess = ask.nextLine();
    while(guess.length()>1) {
      System.out.print(guess + " is not a character! Try again: ");
      guess = ask.nextLine();
    }
    guess = guess.toUpperCase();
    numOfGuesses++;
    return guess;
  }
  
  public static int countGuess(String guess){
    //adds the guess to the blank phrase
    String currentLetter = "";
    int count = 0;
    for(int i = 0; i<secretPhrase.length();i++) {
      currentLetter = secretPhrase.substring(i,i+1);
      if (guess.equals(currentLetter)) {
        count++;
        if(i>0) {
        guessPhrase = guessPhrase.substring(0,i) + currentLetter + guessPhrase.substring(i+1);
        } else {
          guessPhrase = currentLetter + guessPhrase.substring(i+1);
        }
      }
    }
    return count;
  }
  public static void gameOver(){
    System.out.println();
    //determines if you win or lose
    if(numOfParts==0) {
      System.out.println("Olaf has melted :(");
      System.out.println("You printed this much of the phrase:");
      System.out.println(guessPhrase);
      System.out.println("The actual word was: " + secretPhrase);
    } else {
      System.out.println("You saved olaf!");
      System.out.println("You guessed the secret of \"" + secretPhrase + "\" in " + numOfGuesses + " guesses");
    }
  }
  public static void main(String[] args) {
    String[] options = {"AP COMPUTER SCIENCE", "BASEBALL", "SOCCER", "FOOTBALL", "SUPERCALIFRAGILISTICEXPIALIDOCIOUS","MR. PARK","NEW ENGLAND PATRIOTS","BUFFALO BILLS","DOLPHINS == DEPPRESION"};
    Random r = new Random();
    
    secretPhrase = options[r.nextInt(options.length)];

    setGuessPhrase(secretPhrase);
    System.out.println("Olaf isn't sure if he'll make it to winter!");
    System.out.println("Help him before it's too late by guessing the secret phrase");
    
    
      
    while(guessPhrase.indexOf("_")!=-1 && (numOfParts!=0)){
      System.out.println();
    //displays the blank guesses phrase and how many parts olaf has
      displayGuess(guessPhrase);
      System.out.println(guessPhrase);
      System.out.println("Olaf has " + numOfParts + " parts left.");
    
      String guess = getGuess();
      int numGuess = countGuess(guess);  
      //if users guess is not in the phrase, we tell them that, otherwise we tell them how many times it was in the phrase
      if(numGuess == 0) {
        System.out.println("\"" + guess + "\" is not in the secret phrase");
        System.out.println("Olaf lost a part!");
        numOfParts-=1;
      } else{
        System.out.println("\"" + guess + "\" is found in the secret phrase " + numGuess + " time(s)");
      }
    }
    //if there is no more olaf parts, or there are no more blank spaces in the phrase, then it ends the game
    gameOver();
    
  }
}