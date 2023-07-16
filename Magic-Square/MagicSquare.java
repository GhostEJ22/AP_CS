import java.util.Scanner;

public class MagicSquare {
  private int[][] grid;
  
  public MagicSquare(int size) {
    grid = new int [size][size];
  }
   
  /* 
   * Add up the numbers in a row
   * Precondition: row is a valid row index in grid
   * Postcondition: return the sum of the values in the given row
   */
  public int sumRow(int row) {
    /* ENTER YOUR CODE BELOW */
    int sum = 0;
    for(int i = 0; i<grid[row].length;i++) {
      sum+=grid[row][i];
    }
    return sum;
  }

  /* 
   * Add up the numbers in a column
   * Precondition: col is a valid row index in grid
   * Postcondition: return the sum of the values in the given column
   */
  public int sumCol(int col) {
    /* ENTER YOUR CODE BELOW */
    int sum=0;
    for(int i = 0; i<grid.length;i++) {
      sum+=grid[i][col];
    }
    return sum;
  }

  /* 
   * Add up the numbers in the main diagonal (top left to bottom right)
   * Precondition: grid.length > 0
   * Postcondition: return the sum of the values in the main diagonal
   */
  public int sumMainDiag() {
    /* ENTER YOUR CODE BELOW */
    int sum = 0;
    for(int i = 0; i<grid.length;i++) {
      sum+=grid[i][i];
    }
    return sum;  
  }

  /* 
   * Add up the numbers in the other diagonal (top right to bottom left)
   * Precondition: grid.length > 0
   * Postcondition: return the sum of the values in the other diagonal
   */
  public int sumOtherDiag() {
    /* ENTER YOUR CODE BELOW */
    int sum = 0;
    for (int i = 0; i<grid.length; i++) {
      for(int j = grid[i].length-1; j>grid[i].length-2;j--) {
        sum+=grid[j][i];
      }
    }
    return sum;
  }

  /* 
   * Determine if grid is a magic square by checking all rows, columns, and diagonals have the same sum
   * Precondition: grid.length > 0
   */
  public boolean magic() {
    /* ENTER YOUR CODE BELOW */
      int rowSum = sumRow(0);
      int colSum = sumCol(0);
      int diagSum = sumMainDiag();
      for(int i = 0; i<grid.length;i++) {
      if(rowSum !=sumRow(i) || colSum != sumCol(i)) return false;
    
    if(diagSum!=sumOtherDiag()) return false;
    }
    
    return true;
  }

  /* 
   * Update grid's values
   * Precondition: grid.length > 0 and scan is instantiated
   */
  public void readSquare(Scanner scan) {
    for (int row = 0; row < grid.length; row++)
       for (int col = 0; col < grid.length; col ++)
          grid[row][col] = scan.nextInt();
  }

  /* 
   * Print out grid's values
   * Precondition: grid.length > 0
   */
  public void printSquare() {
    System.out.println("The Square is: ");
    for (int row = 0; row < grid.length; row++) {
       for (int col = 0; col < grid.length; col ++)
          System.out.print("\t" + grid[row][col]);
       System.out.println();
    }    			
  }
}