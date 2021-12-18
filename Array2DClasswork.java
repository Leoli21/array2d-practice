import java.util.Scanner;

/***
 * 
 * @author Leo Li
 * 2D Array Classwork Project
 *
 */
public class Array2DClasswork 
{

	public static void main(String[] args) 
	{
		//Creating 1-dimensional array with random number of index between 50 and 100 inclusive
		int randInt = (int) (Math.random()*51 + 50);
		int [] array1D = new int[randInt];
		
		//Filling 1-dimensional array with random values from 1-100 inclusive
		for(int i = 0; i < array1D.length; i++)
		{
			int randInt2 = (int) (Math.random() * 100 + 1);
			array1D[i] = randInt2;
		}
		
		//Creating 2 dimensional array 
		double maxNumRowsDouble = (Math.ceil(array1D.length/7.0)); //Maximum number of rows = 100/7 = 14.286...round up to 15.
		int maxNumRowsInt = (int) (maxNumRowsDouble);
		int currentElement = 1;
		int [] [] array2D = new int [maxNumRowsInt] [7];
		for(int i = 0; i < array2D.length; i++)
		{
			for(int j = 0; j < array2D[0].length; j++)
			{
				if(currentElement > array1D.length)
				{
					array2D[i][j] = 0;
					currentElement++;
				}
				else
				{
					array2D[i][j] = array1D[currentElement-1];
					currentElement++;
				}
				
			}
			
		}
		
		
		//Printing Original Array
		System.out.print("Original Array \n{");
		for(int i = 0; i < array1D.length; i++)
		{
			System.out.print(array1D[i]);
			if(i != array1D.length-1)
			{
				System.out.print(",");
			}
		}
		System.out.println("}");
		
		
		
		//Printing 2D Array filled with 1D Array values
		System.out.print("2D Array \n{");
		for(int i = 0; i< array2D.length; i++)
		{
			System.out.print("{");
			for(int j = 0; j< array2D[0].length; j++)
			{
				System.out.print(array2D[i][j]);
				if(j != array2D[0].length-1)
				{
					System.out.print(",");
				}
			}
			System.out.print("}");
			if(i != array2D.length-1) //Formatting so that no new line is created after the last row. 
			{						 
				System.out.println();
			}
		}
		System.out.println("}");
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose a number between 1 and 100, inclusive: ");
		int intInput = input.nextInt();
		
		System.out.print(Array2DClasswork.getNumRowAndColumn(array2D, intInput));
		
	}
	
	//Static Method returning a String with 2D integer array and integer arguments 
	//Returns the row and column index of where value is in the 2D array. 
	//Returns "Value not found" if it is not in the array.
	public static String getNumRowAndColumn(int[][] array2D, int intInput)
	{
		for(int i = 0; i < array2D.length; i++)
		{
			for(int j=0; j<array2D[0].length; j++)
			{
				if(array2D[i][j] == intInput)
				{
					return "Row: " + i + "\nColumn: " + j;
				}
				
				
			}	
		}
		return "Value not found";
	}

}
