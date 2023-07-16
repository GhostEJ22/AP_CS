import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
      
      // Instantiate a File object, then a Scanner object that uses the File object as an argument
      /* ENTER YOUR CODE BELOW */
        File file = new File("magicData.txt");
        Scanner scan = new Scanner(file);

      

      // Store which square we're on and the size of next square
      /* ENTER YOUR CODE BELOW */
      int count=1;
      int size=scan.nextInt();
    	// Keep scanning the file until the Scanner reaches -1
    	while (size != -1)  {
    		MagicSquare grid = new MagicSquare(size);
    
    		// Call the MagicSquare's read method to read the values of the square
    		grid.readSquare(scan);
    
    		System.out.println("\n******** Square " + count + " ********");
    		grid.printSquare();

        count++;
    
    		// Print the sums of its rows and columns
    		for (int row = 0; row < size; row++)
    			System.out.println("Sum of row "+ (row + 1) + ": " 
    									+ grid.sumRow(row));
  
    		for (int col = 0; col < size; col++)
    			System.out.println("Sum of column "+ (col + 1) + ": " 
    									+ grid.sumCol(col));
    
    		// Print the sum of the respective diagonals
    		System.out.println("Sum of main diagonal: " + grid.sumMainDiag());
        System.out.println("Sum of other diagonal: " + grid.sumOtherDiag());
    
    		// Determine and print whether or not the square is magic
    		if (grid.magic())
    			System.out.println("Yes, the square is a magic square!!!");
    		else
    			System.out.println("No, the square is not a magic square!!!");	
    
    		// Get the size of next square
    		size = scan.nextInt();
	    }
   }
}

