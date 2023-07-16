import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
public class Game {
  // Instance variables
  /* ENTER CODE BELOW */
  //the size of the grid, the players grid, both the visible and stored CPU grid and how many ships everyone has
  private final int rowLength;
  private final int colLength;
  private String[][] PlayerGrid;
  private String[][] CPUGridSeen;
  private String[][] OGCPUGrid;
  private int playerShips;
  private int CPUShips;
  // Constructors
  /* ENTER CODE BELOW */
  //default constructor with a 8 by 8 grid
  public Game() {
    rowLength = 8;
    colLength = 8;
    PlayerGrid = new String[rowLength][colLength];
    CPUGridSeen =new String[rowLength][colLength];
    OGCPUGrid = new String[rowLength][colLength];
    playerShips = 4;
    CPUShips = 4;
  }
  //constructor that picks the size of the grid
  public Game(int dimensions) {
    rowLength = dimensions;
    colLength = dimensions;
    PlayerGrid = new String[rowLength][colLength];
    CPUGridSeen =new String[rowLength][colLength];
    OGCPUGrid = new String[rowLength][colLength];
    playerShips = 4;
    CPUShips = 4;
  }
  // Methods
  /*
   * This method helps with keeping the console easy to read as the game progresses.
   * Note it is private so that it should only be called within this class.
   * Feel free to not use this until your game logic is complete!
   */
  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /* ENTER CODE BELOW */
  //initialize the game boards to there elected values and lets the player place there ships
  public void initialize() {
    Scanner sc = new Scanner(System.in);
    for(int row = 0; row<rowLength;row++) {
      for(int col = 0; col<colLength;col++) {
        PlayerGrid[row][col]="-";
        CPUGridSeen[row][col]="-";
        OGCPUGrid[row][col]="-";
      }
    }
    //places AI and our ships
    int row=-1;
    int col=-1;
    
    for(int i = 1;i<=CPUShips;i++) {
        row = (int)(Math.random()*rowLength-1)+1;
        col = (int)(Math.random()*colLength-1)+1;
        if((OGCPUGrid[row-1][col-1].equals("-"))) {
          OGCPUGrid[row-1][col-1] = "O";
          
  
        } else i--;
    }
    for(int i = 1;i<=playerShips;i++) {
        System.out.print("Enter the row for Ship #" + i + ": ");
        row = sc.nextInt();
        System.out.print("Enter the column for Ship #" + i + ": ");
        col = sc.nextInt();
        if(row>rowLength || row<=0 || col>colLength || col<=0) {
          System.out.println("You can't place a ship there! Try again.");
          i--;
        }
        else if ((PlayerGrid[row-1][col-1].equals("-"))) {
          PlayerGrid[row-1][col-1] = "O";
          
        } else {
          System.out.println("There is already a ship there. Try again.");
          i--;
        }
      }
  }
  //determines when it ends
  int count = 0;
  int ourCount = 0;
  public boolean gameOver() {
    for(int row = 0; row<rowLength; row++) {
      for (int col = 0;col<colLength; col++) {
        if(CPUGridSeen[row][col].equals("X")) count++;
      }
    }
    if(count>=4) return true;
    count =0;
    for(int row = 0; row<rowLength; row++) {
      for (int col = 0;col<colLength; col++) {
        if(PlayerGrid[row][col].equals("X"))ourCount++;
      }
    }    
    if(ourCount>=4) return true;
    ourCount=0;
    return false;
   

  }
  //determines who won
  public void result() {
    if(gameOver()==true){
      if(count>=4) System.out.println("YOU WIN!");
        else System.out.println("The CPU wins...");
          } 
      }
  //shows the game board(both CPUShown and PlayerGrid)
  public void showGrid() {
    clearScreen();
    for(int row = 0; row<rowLength; row++) {
      for (int col = 0;col<colLength; col++) {
        System.out.print(CPUGridSeen[row][col]);
      }
      System.out.println();
    }
    System.out.println("==================");
    for(int row = 0; row<rowLength; row++) {
      for (int col = 0;col<colLength; col++) {
        System.out.print(PlayerGrid[row][col]);
      }
      System.out.println();
    }
    
  }
  //who plays the game
  public void takeTurn(String player) {
    
    Scanner sc = new Scanner(System.in );
    
    showGrid();
    int row;
    int col;
    int close;
    //if it is the players turn, the pick a row and column to shoot at and it marks it there
    if(player.equals("player")) {
      do {
        System.out.print("Pick a row to shoot at: ");
        row=sc.nextInt();
        System.out.print("Pick a column to shoot at: ");
        col=sc.nextInt();
        if(row>rowLength || row<=0 || col>colLength || col<=0) System.out.println("really?");
      }while(row>rowLength || row<=0 || col>colLength || col<=0);
      //if it hits does this
      if(OGCPUGrid[row-1][col-1].equals("O")&& CPUGridSeen[row-1][col-1].equals("-")) {
        System.out.println("You sunk a ship!");
        CPUGridSeen[row-1][col-1]="X";
      }
      //if you already hit do this
      else if(CPUGridSeen[row-1][col-1].equals("X")) {
        System.out.println("You already sunk that ship...");
      }
      //if it is a miss show the close ones
      if(OGCPUGrid[row-1][col-1].equals("-")) {
        System.out.println("Missed... Just like Josh Allen on the seam route to Diggs");
        close = 0;
        for(int i = 1; i<OGCPUGrid[row-1].length;i++) {
          if(OGCPUGrid[row-1][i-1].equals("O")) 
          {
          close++;
          }
        }
        for(int i = 1; i<OGCPUGrid.length;i++) {
          if(OGCPUGrid[i-1][col-1].equals("O")) 
          {
          close++;
          }

        }
        CPUGridSeen[row-1][col-1]=Integer.toString(close);
      }
    }
    //automatic turn
    if(player.equals("CPU")) {
      row = (int)(Math.random()*rowLength)+1;
      col = (int)(Math.random()*colLength)+1;
      if(PlayerGrid[row-1][col-1].equals("O") || PlayerGrid[row-1][col-1].equals("X")) {
        PlayerGrid[row-1][col-1]="X";
        System.out.println("THE AI HIT YOU GET IT TOGETHER");
      } else {
        PlayerGrid[row-1][col-1]="*";
        System.out.println("THE AI MISSED YOURE SAFE FOR NOW");
      }
    } 
    
  }
  
  
  //getters and setters for test cases
  public int getROW() {
    return rowLength;
  }
  public int getCOL() {
    return colLength;
  }
  public String[][] getPlayerGrid() {
    return PlayerGrid;
  }
  public String[][] getCPUGridShown() {
    return CPUGridSeen;
  }
  public String[][] getCPUGridHidden() {
    return OGCPUGrid;
  }
  public int getNumOfPlayerShips() {
    return playerShips;
  }
  public int getNumOfCPUShips() {
    return CPUShips;
  }
  public void setPlayerGrid(String[][] initPG) {
    PlayerGrid = initPG;
  }
  public void setCPUGridShown(String[][] initCGS) {
    CPUGridSeen = initCGS;
  }
  public void setCPUGridHidden(String[][] initCGH) {
    OGCPUGrid = initCGH;
  }
  public void setNumOfPlayerShips(int NPS) {
    playerShips = NPS;
  }
  public void setNumOfCPUShips(int CPUS) {
    CPUShips = CPUS;
  }
  //prints out all the stats
  public String toString() {
    return (rowLength + " " + colLength + " " + Arrays.deepToString(PlayerGrid) + " " + Arrays.deepToString(CPUGridSeen) + " " + Arrays.deepToString(OGCPUGrid) + " " + playerShips + " " + CPUShips);
  }
} 

