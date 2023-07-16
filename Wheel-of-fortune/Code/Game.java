import java.util.Scanner;

public class Game {
  private static String secretPhrase;
  private static String guessPhrase;
  private static String category;
  private static String guess;

  /* Consider this method to be very similar to a constructor:
   * it updates all of the global variables provided earlier
   */
  public static void setUp() {
    secretPhrase = "COMPUTER SCIENCE";
    guessPhrase = "";
    category = "Courses";
    guess = "";
    setGuessPhrase(secretPhrase);

    
  }

  // ENTER METHODS FROM STEP 5 IN THE SPACE BELOW
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

  /**********************************************************/

  // ENTER METHODS FROM STEP 6 IN THE SPACE BELOW
  //user decides what move they want to make
  public static String makeChoice() {
    Scanner ask = new Scanner(System.in);
    do {
    System.out.print("Do you want to spin ('spin'), buy a vowel ('vowel'), or solve ('solve')? ");
    guess = ask.nextLine();
    guess = guess.toLowerCase();
    }while(!(guess.equals("spin") || guess.equals("vowel") || guess.equals("solve")));
    return guess;
  }
  //this is what happens if the user says they want to spin.They guess a non vowel letter and see how much they won
  public static boolean spin(Player currentPlayer, int spinValue) {
    
    Scanner ask = new Scanner(System.in);
    
    int num = 0;
    if(spinValue==0){
      System.out.println("The wheel shows 'Lose a Turn'\n");
      return false;
    } else {
      System.out.print("The wheel shows $" + spinValue + ". What consonant would you like to guess? ");
      guess = ask.nextLine();
      guess = guess.toUpperCase();
      while(guess.length()>1 || guess.equals("A") || guess.equals("E") || guess.equals("I") || guess.equals("O") || guess.equals("U")){

      System.out.print("\"" + guess + "\" is not a consonant; try again: ");
    
        guess = ask.nextLine();
        guess = guess.toUpperCase();
      } 
    }
    
    if(guessPhrase.contains(guess)==false && secretPhrase.indexOf(guess)!=-1) {
        num = countGuess(guess);
        System.out.println("\"" + guess + "\" was found " + num + " time(s)!\n");
        currentPlayer.deposit(spinValue*num);
        return true;
    } else if(guessPhrase.contains(guess)==true && secretPhrase.indexOf(guess)!=-1){
        System.out.println("That consonant has already been guessed!\n");
        return false;
    }else{
      System.out.println("There are no " + guess + "'s in the phrase.\n");
      return false;
    }
  }
  //allows the user to buy a vowel if they have enough
  public static boolean pickVowel(Player currentPlayer) {
    guess=" ";
    Scanner ask = new Scanner(System.in);
    if(currentPlayer.getCurrentWinnings()<250) {
      System.out.println("You don't have enough money to buy a vowel!");
      return false;
    } else {
      System.out.print("What vowel would you like to purchase? ");
      currentPlayer.withdraw(250);
      guess = ask.nextLine();
      guess = guess.toUpperCase();
        while(guess.length()>1 || !(guess.equals("A") || guess.equals("E") || guess.equals("I") || guess.equals("O") || guess.equals("U"))){
        

        System.out.print("\"" + guess + "\" is not a vowel; try again: ");
        
        guess = ask.nextLine();
        guess = guess.toUpperCase();
        
      }
    }
    if(guessPhrase.contains(guess)==false && secretPhrase.indexOf(guess)!=-1){
      System.out.println("\"" + guess + "\" was found " + countGuess(guess) + " time(s)!\n");
      countGuess(guess);
      return true;
    }
    else if(guessPhrase.contains(guess)==true && secretPhrase.indexOf(guess)!=-1) {
      System.out.println("That vowel has already been guessed!\n");
      return true;
    } else{
      System.out.println("There are no " + guess + "'s in the phrase.\n");
      return true;
    }
    
  }
  //attempt to solve the phrase
  public static boolean solve(Player currentPlayer) {
    guess = " ";
    Scanner ask = new Scanner(System.in);
    System.out.print("Alright, go ahead: ");
    guess = ask.nextLine();
    guess = guess.toUpperCase();
    if(guess.equals(secretPhrase)){
      System.out.println("That's right, " + currentPlayer + "! You won $"+ currentPlayer.getCurrentWinnings() + "!");
      guessPhrase=secretPhrase;
      gameOver();
      return false;
    } else {
      
      System.out.println("That's not it!");
      return false;
    }
    
  }
  //displays the information the user knows
  public static void takeTurn(Player currentPlayer) {
    boolean ContTurn=true;
    
    while(ContTurn!=false){
      displayGuess(guessPhrase);
      System.out.println(guessPhrase);
      System.out.println("Category: " + category);
      System.out.println("Player: " + currentPlayer);
      System.out.println("You currently have $" + currentPlayer.getCurrentWinnings());
      String choice = makeChoice();
      //calls the other methods depending on what the user picks
      if(choice.equals("spin")) {
        int randMultiple = (int)(Math.random()*11) * 100;
        ContTurn = spin(currentPlayer, randMultiple);
      }
      if(choice.equals("vowel")) {
        ContTurn = pickVowel(currentPlayer);
      }
      if(choice.equals("solve")) {
        ContTurn = solve(currentPlayer);
      }
      
    }
    
  }
  //keeps the game going or ends it
  public static boolean gameOver() {
    if(guessPhrase.equals(secretPhrase)) {
      return true;
    } else {
      return false;
    }
  }
}