package lab04;

import java.lang.IllegalArgumentException;
import java.util.Scanner;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a integer of the base integer:");
		int i = sc.nextInt();
		System.out.print("Please enter a integer of the power time:");
		int n = sc.nextInt();
		long value;
		try{
			startTime = System.nanoTime();
			System.out.print("The runtime of 1st recursive method is: "   );
			value = power(i,n);
			endTime = System.nanoTime();
			System.out.println((startTime-endTime)/1000000000.0 + " seconds.\nThe value is " + value );
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		try{
			startTime = System.nanoTime();
			System.out.print("The runtime of iterative method is: "   );
			value = iterativePower(i,n);
			endTime = System.nanoTime();
			System.out.println((startTime-endTime)/1000000000.0 + " seconds.\nThe value is " + value );
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
		try{
			startTime = System.nanoTime();
			System.out.print("The runtime of 2rd recursive method is: "   );
			value = recursivePower(i,n);
			endTime = System.nanoTime();
			System.out.println((startTime-endTime)/1000000000.0 + " seconds.\nThe value is " + value );
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	
		sc.close();
	}
	
	/**
	* Calculates the value of a given integer raised to the power of a second integer.
	* The worstTime(n) is O(n), where n is the second integer.
	*
	* @param i ¨C the base integer (to be raised to a power).
	* @param n ¨C the exponent (the power i is to be raised to).
	*
	* @return the value of i to the nth power.
	*
	* @throws IllegalArgumentException ¨C if n is a negative integer or if i raised to
	* to the n is greater than Long.MAX_VALUE.
	*
	*/	
	public static long power (int i, int n){
		if (n<0) {
			throw new IllegalArgumentException("Negative integer!");
		}
		if (n==0) return 1;
		if (n==1) return i;
		long sum;
		sum = power(i,n-1);
		if (Math.abs(Long.MAX_VALUE/sum) < Math.abs(i)) 
			throw new IllegalArgumentException("Exceed the range of Long!");
		return sum*i;			
	}
	public static long iterativePower(int i , int n){
		if (n<0) {
			throw new IllegalArgumentException("Negative integer!");
		}
		if (n==0) return 1;
		if (n==1) return i;
		long sum = 1;
		for (int j=0; j<n; j++){
			if (Math.abs(Long.MAX_VALUE/sum) < Math.abs(i))
				throw new IllegalArgumentException("Exceed the range of Long!");
			sum *= i;
		}
		return sum;
	}
	public static long recursivePower(long i, int n){
		if (n<0) {
			throw new IllegalArgumentException("Negative integer!");
		}
		if (n==0) return 1;
		if (n==1) return i;
		if (n%2==0){
			if (Math.abs(Long.MAX_VALUE/i) < Math.abs(i))
				throw new IllegalArgumentException("Exceed the range of Long!");
			long sum = recursivePower(i*i,n/2);
			return sum;
			
		}else{
			if (Math.abs(Long.MAX_VALUE/i/i) < Math.abs(i))
				throw new IllegalArgumentException("Exceed the range of Long!");
			long sum = i *recursivePower(i*i,n/2);
			return sum;
		}
	}
	

}
