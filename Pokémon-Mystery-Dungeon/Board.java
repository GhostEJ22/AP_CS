import java.util.ArrayList;
import java.util.Scanner;

public class Board {
  Scanner ask = new Scanner(System.in);
  /* ENTER INSTANCE VARIABLES BELOW */
  // variables
  private int gridLength;
  private String grid[][];
  private ArrayList<Pokemon> myPokemon;
  private ArrayList<Pokemon> theirPokemon;
  private ArrayList<String> ourIcons;
  private ArrayList<String> theirIcons;
  private int howManyOfOurs;
  private int howManyOfTheirs;

  /* CONSTRUCTOR AND METHODS DEFINED. COMPLETE THEM */
  // constructor for board
  public Board() {
    gridLength = 9;
    grid = new String[gridLength][gridLength];
    myPokemon = new ArrayList<Pokemon>();
    theirPokemon = new ArrayList<Pokemon>();
    ourIcons = new ArrayList<String>();
    theirIcons = new ArrayList<String>();
    howManyOfTheirs = 3;
    howManyOfOurs = 3;
    
    for (int i = 0, a = 65, gridI = 2; i < howManyOfTheirs; i++, a++) {
      theirPokemon.add(new Pikachu(0, gridI));
      char iconLetter = (char) a;
      String icon = String.valueOf(iconLetter);
      theirIcons.add(icon);
      grid[0][gridI] = icon;
      gridI += 2;
    }
  }

  // shows the board(goes through every part of the grid and adds a specific
  // thing)
  public void show() {
    for (int row = 0; row < gridLength; row++) {
      for (int col = 0; col < gridLength; col++) {
        String icons = grid[row][col];
        if (icons == null) {
          System.out.print(grid[row][col] = "-");
          System.out.print("\t");
        } else {
          System.out.print(icons + "\t");
        }
      }
      System.out.println();
    }
  }

  public boolean isGameOver() {
    // if either people have 0 pokemon do this
    if (howManyOfTheirs == 0) {
      System.out.println("Congrats, you won!");
      return true;
    }
    if (howManyOfOurs == 0) {
      System.out.println("How you gonna lose to actual bots");
      return true;
    }
    return false;
  }

  /// puts playesr on board
  public void setUp() {
    // for every two spots, put the users choice of pokemon
    for (int i = 0, gridI = 2; i < howManyOfOurs;) {
      System.out.print("Enter Pokemon: " + (i + 1) + "(Charmander, Squirtle, Bulbasaur): ");
      String pokType = ask.next();
      pokType = pokType.toLowerCase();
      if (!(pokType.equals("charmander") || pokType.equals("squirtle") || pokType.equals("bulbasaur"))) {
        System.out.print("NOT A POKEMON!! ");
        continue;
      }
      Pokemon myyPokemon = null;
      if (pokType.equals("bulbasaur")) {
        myyPokemon = new Bulbasaur(8, gridI);
      } else if (pokType.equals("squirtle")) {
        myyPokemon = new Squirtle(8, gridI);
      } else if (pokType.equals("charmander")) {
        myyPokemon = new Charmander(8, gridI);
      }
      String icons = String.valueOf(i + 1);
      myPokemon.add(myyPokemon);
      ourIcons.add(icons);
      grid[8][gridI] = icons;
      i++;
      gridI += 2;
    }
  }

  public void moveCPU(int cpu) throws InterruptedException {
    // moves the CPU when it is its turn
    System.out.println("\n\nPokemon " + theirIcons.get(cpu) + " is " + theirPokemon.get(cpu).toString());
    int currentCol = theirPokemon.get(cpu).getCol();
    int currentRow = theirPokemon.get(cpu).getRow();
    int rowChange;
    int colChange;
    int posOrNeg;
    int secondPosOrNeg;
    do {
      // math that makes it move between 0-3 spots
      posOrNeg = (int) (2 * Math.random());
      if (posOrNeg == 0) {
        rowChange = (int) (4 * Math.random());
        secondPosOrNeg = (int) (2 * Math.random());
        if (secondPosOrNeg == 0) {
            colChange = (int) ((4-Math.abs(rowChange)) * Math.random());
  
        } else {
            colChange = (int) ((-4+Math.abs(rowChange)) * Math.random());
        }
      } else {
        rowChange = (int) (-4 * Math.random());
        secondPosOrNeg = (int) (2 * Math.random());
        if (secondPosOrNeg == 0) {
            colChange = (int) ((4-Math.abs(rowChange)) * Math.random());
          
        } else {
            colChange = (int) ((-4+Math.abs(rowChange)) * Math.random());
        }
      }
    } while (currentRow + rowChange < 0 || currentRow + rowChange > 8 || currentCol + colChange < 0
        || currentCol + colChange > 8 || !grid[currentRow + rowChange][currentCol + colChange].equals("-"));
    // replaces symbols
    String oldSymbol = grid[currentRow][currentCol];
    grid[currentRow][currentCol] = "-";
    grid[currentRow + rowChange][currentCol + colChange] = oldSymbol;
    theirPokemon.get(cpu).move(rowChange, colChange);
    System.out.println("Pokemon " + theirIcons.get(cpu) + " is now at (" + theirPokemon.get(cpu).getRow() + ", "
        + theirPokemon.get(cpu).getCol() + ")");
    show();
    Thread.sleep(500);
  }

  public void CPUAttack(int cpu, int us) throws InterruptedException {
    // who to attack
    System.out.println("\n\nPokemon " + theirIcons.get(cpu) + " is " + theirPokemon.get(cpu).toString());
    theirPokemon.get(cpu).attack(myPokemon.get(us));
    if (myPokemon.get(us).getHP() == 0) {
      System.out.println("\n" + myPokemon.get(us).getName() + " fainted!\n\n");
      int rowOfDead = myPokemon.get(us).getRow();
      int colOfDead = myPokemon.get(us).getCol();
      grid[rowOfDead][colOfDead] = "-";
      howManyOfOurs--;
      myPokemon.remove(us);
      ourIcons.remove(us);
    } else {
      System.out.print(myPokemon.get(us).getName() + " has " + myPokemon.get(us).getHP() + " HP\n\n");
    }
  }

  public void takeTurn(String player) throws InterruptedException {
    // if its your turn, choice
    isGameOver();
    if (!(player.equals("CPU"))) {
      for (int i = 0; i < howManyOfOurs; i++) {
        System.out.println("\n\nPokemon #" + (i + 1) + " is " + myPokemon.get(i).toString());
        String choice;
        do {
          System.out.print("What would you like to do(m for move, a for attack, s for special attack)? ");
          choice = ask.next().toLowerCase();
        } while (!(choice.equals("m") || choice.equals("a") || choice.equals("s")));
        if (choice.equals("m")) {
          // stores everything then moves them
          int row;
          int col;
          int currentCol = myPokemon.get(i).getCol();
          int currentRow = myPokemon.get(i).getRow();
          do {
            System.out.print("What row do you want to move to? ");
            row = ask.nextInt();
            System.out.print("What column do you want to move to? ");
            col = ask.nextInt();
            if (row < 0 || row > 8 || col < 0 || col > 8)
              System.out.println("That's not on the board, try again!");
            else if (Math.abs(currentRow - row) + Math.abs(currentCol - col) > (myPokemon.get(i).getSpeed()))
              System.out.println("Too far away, try again!");
            else if (!(grid[row][col].equals("-")))
              System.out.println("A Pokemon is already there, try again!");
          } while (row < 0 || row > 8 || col < 0 || col > 8
              || Math.abs(currentRow - row) + Math.abs(currentCol - col) > (myPokemon.get(i).getSpeed()) || !grid[row][col].equals("-"));
          myPokemon.get(i).moveUser(row, col);
          String oldSymbol = grid[currentRow][currentCol];
          grid[currentRow][currentCol] = "-";
          grid[row][col] = oldSymbol;
          show();
        }
        if (choice.equals("a")) {
          // choose who to attack
          int where;
          System.out.println("Pick an opponent to attack");
          for (int j = 0; j < howManyOfTheirs; j++) {
            System.out.println(theirIcons.get(j) + ": " + theirPokemon.get(j).toString());
          }
          String ATTACKCHOICE;
          do {
            // if they actually choose a enemy, attack
            ATTACKCHOICE = ask.next().toUpperCase();
            if (!(theirIcons.contains(ATTACKCHOICE)))
              System.out.println("Not a viable option try again");
          } while (!theirIcons.contains(ATTACKCHOICE));
          where = theirIcons.indexOf(ATTACKCHOICE);
          if (myPokemon.get(i).isCloseTo(theirPokemon.get(where))) {
            myPokemon.get(i).attack(theirPokemon.get(where));
            if (theirPokemon.get(where).getHP() == 0) {
              // removes symbols
              System.out.println("\n" + theirPokemon.get(where).getName() + " fainted!\n\n");
              int rowOfDead = theirPokemon.get(where).getRow();
              int colOfDead = theirPokemon.get(where).getCol();
              grid[rowOfDead][colOfDead] = "-";
              howManyOfTheirs--;
              theirPokemon.remove(where);
              theirIcons.remove(where);
              show();
            } else {
              System.out.println(" on " + theirPokemon.get(where).toString());
              System.out
                  .print(theirPokemon.get(where).getName() + " has " + theirPokemon.get(where).getHP() + " HP\n\n");
              show();
            }
          } else {
            System.out.println(myPokemon.get(i).getName() + " is too far from " + theirPokemon.get(where).getName());
            i--;
          }
        }
        if (choice.equals("s")) {
          // super but same thing as before
          int where;
          System.out.println("Select opponent: ");
          for (int j = 0; j < howManyOfTheirs; j++) {
            System.out.println(theirIcons.get(j) + ": " + theirPokemon.get(j).toString());
          }
          String ATTACKCHOICE;
          do {
            ATTACKCHOICE = ask.next().toUpperCase();
            if (!(theirIcons.contains(ATTACKCHOICE)))
              System.out.println("Not a viable option try again");
          } while (!theirIcons.contains(ATTACKCHOICE));
          where = theirIcons.indexOf(ATTACKCHOICE);
          if (myPokemon.get(i) instanceof Squirtle) {
            myPokemon.get(i).doSpecialMove(theirPokemon.get(where));
          } else {
            if (myPokemon.get(i).isCloseTo(theirPokemon.get(where))) {
              myPokemon.get(i).doSpecialMove(theirPokemon.get(where));
              if (theirPokemon.get(where).getHP() == 0) {
                System.out.println(theirPokemon.get(where).getName() + " fainted!\n\n");
                int rowOfDead = theirPokemon.get(where).getRow();
                int colOfDead = theirPokemon.get(where).getCol();
                grid[rowOfDead][colOfDead] = "-";
                howManyOfTheirs--;
                theirPokemon.remove(where);
                theirIcons.remove(where);
                show();
              } else {
                System.out.print("\n\n");
                show();
              }
            } else
            {
              System.out.println(myPokemon.get(i).getName() + " is too far from " + theirPokemon.get(where).getName());
            i--;
            }  
          }
        }
      }
    } else {
      // cpu turn
      System.out.println("\n\nIt's the cpu's turn now!");
      Thread.sleep(500);
      boolean close = true;
      for (int cpu = 0; cpu < howManyOfTheirs; cpu++) {
        for (int us = 0; us < howManyOfOurs; us++) {
          if (theirPokemon.get(cpu).isCloseTo(myPokemon.get(us))) {
            close = true;
          } else
            close = false;
          if (close == true) {
            CPUAttack(cpu, us);
            if (cpu < (howManyOfTheirs - 1)) {
              us = 0;
              cpu++;
              show();
              Thread.sleep(500);
            } else if (cpu == (howManyOfTheirs - 1)) {
              us = (howManyOfOurs - 1);
              show();
              Thread.sleep(500);
            }
          }
        }
        if (close == false)
          moveCPU(cpu);
      }
    }
  }
  // Clears the console. DO NOT use this until your game is finalized!
  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}