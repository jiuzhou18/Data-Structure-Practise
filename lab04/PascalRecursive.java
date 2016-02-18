package lab04;

import java.util.Scanner;

public class PascalRecursive {

	static final String PROMOT = "This is the pascal's triangle constructor.\n"
			+ "Enter \"row, element\": ";
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime;
		
		Scanner in = new Scanner(System.in);
		String typein;
		String[] numbers;
		int row,element,result;
		boolean judge = true;
		while(judge){
			System.out.print(PROMOT);
			typein = in.nextLine();
			numbers = typein.split(",");
			row = Integer.valueOf(numbers[0]);
			element = Integer.valueOf(numbers[1]);			
			System.out.print("pascal(" + row +"," + element +")= ");
			startTime = System.nanoTime();
			result = pascal(row,element);
			endTime = System.nanoTime();
			System.out.println(result);
			System.out.println("The running time is :" +(endTime-startTime)/1000000000.0 + " seconds.");
			System.out.println("Do you want to quit? [Q for quit, other key for continue]");
			if (in.nextLine().toUpperCase().contains("Q")) judge = false;
		}
		System.out.println("Exiting the system....\nThank you! ");
		in.close();
		
		
	}
	
	public static int pascal(int row, int element){
		int[] currentRow = new int[row];
		currentRow[0] = 1;
		pascalRecursion(row, 1, currentRow);
	    return currentRow[element-1];
	}
	
	public static void pascalRecursion(int row, int now, int[]array){
		if (now < row){
			array[now] = 1;
			rowRefresh(now-1, array);
			pascalRecursion(row, now+1, array);
		}
		
	}
	public static void rowRefresh(int now, int[] array){
		if(now>0){
			array[now] = array[now] + array[now-1];
			rowRefresh(now-1, array);			
		}
		
	}
}
