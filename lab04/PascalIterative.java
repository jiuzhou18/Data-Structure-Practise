package lab04;

import java.util.*;

public class PascalIterative {
	
	static final String PROMOT = "This is the pascal's triangle constructor.\n"
			+ "Please enter the number of rows you want:";
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int row;
		boolean judge = true;
		while(judge){
			System.out.print(PROMOT);
			if (in.hasNextInt()){
				row = in.nextInt();
				in.nextLine();
				if(row <0){
					System.out.println("Error: Please type in a positive number.");
					continue;
				}
				System.out.println("The result of Pascal's triangle of row " + row + " is:");
				pascal(row);
				System.out.println("Do you want to quit? [Q for quit, other key for continue]");
				if (in.nextLine().toUpperCase().contains("Q")) judge = false;
			}
			else{
				in.nextLine();
				System.out.println("Error input type: please enter a integer.");
			}
		System.out.println("Exiting the system....\nThank you! ");
		}
	}
	
	public static void pascal(int row){
		int[] currentRow = new int[row];
		for(int i=0; i<row; i++){
			currentRow[i] = 1;
			for(int j=i-1; j>0; j--){
				currentRow[j] = currentRow[j] + currentRow[j-1];
			}
			for(int j=0; j<=i; j++){
				System.out.print(currentRow[j] + "\t");
			}
			System.out.println();
		}
	}

}
