//imports
import java.util.Arrays;
import java.util.HashMap;




/*
 * @author		Andrew Parise <andrew_parise@students.ocean.edu>
 * @version		1.0
 * @since		2016-01-25
 * 
 * Assignment 1.2
 * 
 * <p>
 * Description:
 * Write a Java program to create a 4-by-4 matrix with the following values: 
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, and 16. 
 * Your program must read from the matrix and display the sum of the elements in the matrix. 
 * The program must then display the sum of each row, each column, and the diagonal elements of the matrix.
 * 
 */

public class MatrixSum {
	/*
	 * @param int[][] 2D array with filled values
	 * 
	 */
	public static final boolean DEBUG = false;
	
	public int[][] matrix; //the matrix to have summations performed on
	
	HashMap<String, Integer> sumValues = new HashMap<>(); //hashmap to store the values of the summations
	
	/* sumValues:
	 * 
	 * Valid Keys:
	 * 
	 * numRows		=		the total number of rows in the matrix
	 * numCols		=		the total number of columns in the matrix
	 * row#Sum		=		the sum of each row, where # is the row number
	 * col#Sum		=		the sum of each column, where # is the column number
	 * totalSum		=		the total sum of the matrix
	 * leftDiagSum	=		the left diagonal sum
	 * rightDiagSum =		the right diagonal sum
	 * 
	 */
	
	//constructors
	public MatrixSum(int[][] input){
		//constructor that takes user provided data
		this.matrix = input;
		if(DEBUG){System.out.println("DEBUG: MatrixSum() : matrix = " + Arrays.deepToString(matrix));}
		storeRowCol();
		calcSums();
	}
	
	private void storeRowCol(){
		//Finds the number of rows and columns in the matrix and stores them in the hashmap
		//Rows
		if(DEBUG){System.out.println("DEBUG: storeRowCol() : rows (matrix[0].length) = " + matrix[0].length);}
		sumValues.put("numRows", matrix[0].length);
		//Columns
		sumValues.put("numCols", matrix.length);
	}
	
	private void calcRowSum(){
		//Calculates the sum of each row and stores the value in the sumValues hashmap

		int rowSum; //keeps a running total of the row summation
		for(int i = 0; i < sumValues.get("numRows"); i++){
			rowSum = 0; //reset the value with each iteration
			for(int j = 0; j < sumValues.get("numCols"); j++){
				rowSum += matrix[i][j];
			}
			sumValues.put(("row" + i + "Sum"), rowSum); //naming convention for hashmap access "row#Sum"
		}
	}
	private void calcColSum(){
		//Calculates the sum of each column and stores the value in the sumValues hashmap
		
		int colSum; //keeps a running total of the column summation
		for(int i = 0; i < sumValues.get("numCols"); i++){
			colSum = 0; //reset the value with each iteration
			for(int j = 0; j < sumValues.get("numRows"); j++){
				colSum += matrix[j][i];
				if(DEBUG){System.out.println("Debug: calcColSum() : int colSum = " + colSum);}
			}
			sumValues.put("col" + i + "Sum", colSum); //naming convention for hashmap access "col#Sum"
		}
	}
	private void calcTotalSum(){
		//Calculates the total summation of the matrix by adding the values of every entry in sumValues for row#Sum
		int totalSum = 0;
		for(int i = 0; i < sumValues.get("numRows"); i++){
			totalSum += sumValues.get("row" + i + "Sum");
		}
		sumValues.put("totalSum", totalSum); //enters the total sum into the hashmap
	}
	private void calcDiagSum(){
		//Calculates the left and right diagonal sums
		
		int leftSum = 0; //keeps running sum
		//Left Diagonal
		for(int i = 0; i < sumValues.get("numRows"); i++){
			leftSum += matrix[i][i];
			if(DEBUG){System.out.println("Debug: calcDiagSum() : leftSum = " + leftSum);}

		}
		sumValues.put("leftDiagSum", leftSum); //store in HashMap sumValues
		
		
		//Right Diagonal
		int rightSum = 0; //reset sum variable
		if(DEBUG){System.out.println("Debug: calcDiagSum() : rightSum = " + rightSum);}

		int counter = 0; //to count iterations of for loop
		for(int i = (sumValues.get("numRows") - 1); i > -1; i--){ // "i > -1" because matrix[0][3] needs to be accessed
			rightSum += matrix[i][counter];
			if(DEBUG){System.out.println("Debug: calcDiagSum() : rightSum = " + rightSum);}
			counter++;
		}
		sumValues.put("rightDiagSum", rightSum); //store in HashMap sumValues
	}
	
	
	public void calcSums(){
		//Calls the various functions to perform calculations on the matrix
		calcRowSum(); //Calculates the sum of each row in the matrix
		calcColSum(); //Calculates the sum of each column in the matrix
		calcDiagSum(); //Calculates the sum of the diagnols of the matrix
		calcTotalSum(); //Calculates the total summation of the matrix
	}
	public void printHashMap(){
		//Prints all of the values of the sumValues hashmap to the console
		//NOTE: use for debug
		for(HashMap.Entry<String, Integer> entry : sumValues.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	public void printValues(){
		//Prints the data to the console in an easily read format
		
		System.out.println("The total sum of the " + sumValues.get("numRows") + "-by-" + sumValues.get("numCols") + " matrix is " + sumValues.get("totalSum")); //Prints total sum
		//Print Row Sum Values
		for(int i = 0; i < sumValues.get("numRows"); i++){
			System.out.println("The sum of row #" + (i+1) + " is " + sumValues.get("row" + i + "Sum"));
		}
		//Print Column Sum Values
		for(int i = 0; i < sumValues.get("numCols"); i++){
			System.out.println("The sum of column #" + (i+1) + " is " + sumValues.get("col" + i + "Sum"));
		}
		System.out.println("The sum of the left diaganol elements is " + sumValues.get("leftDiagSum"));
		System.out.println("The sum of the right diaganol elements is " + sumValues.get("rightDiagSum"));

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//testData from instructions
		int[][] inputData = new int[][]{
										{1, 2, 3, 4}, 
										{5, 6, 7, 8}, 
										{9, 10, 11, 12}, 
										{13, 14, 15, 16}
										
										};
		
		if(DEBUG){System.out.println("DEBUG: main() : inputData[][] = " + Arrays.deepToString(inputData));}
		MatrixSum ms = new MatrixSum(inputData); //create instance of MatrixSum object with test data
		if(DEBUG){
			System.out.println("DEBUG: main() : contents of HashMap sumValues<String, Integer>: ");
			ms.printHashMap();
		}
		ms.printValues();		
		
		
	}

}
