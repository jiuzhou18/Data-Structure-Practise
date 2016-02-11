package lab03;

import java.util.Scanner;

public class FibonacciUser
	{
	  public static void main (String[] args)
	  {
	 new FibonacciUser().run();
	  } // method main

	  
	  /**
	   *  The Fibonacci number of the integer entered has been printed.
	   */
	  public void run() 
	  { 
	      final int SENTINEL = -1;
	 
	     final String INPUT_PROMPT = "\n\nPlease enter the " +
	        "positive integer whose Fibonacci number you want (or " +
	         SENTINEL + " to quit): ";    
	           
	     final String FIBONACCI_MESSAGE = "\nIts Fibonacci number is ";
	         
	     Scanner sc = new Scanner (System.in);
	    
	 int n;

	     while (true)
	     {
	        try
	        {
	          System.out.print (INPUT_PROMPT);
	          n = sc.nextInt();
	          if (n == SENTINEL)
	           break;        
	          long startTime,
			  finishTime,
			  elapsedTime;
			final String MESSAGE_1 = "The elapsed time was ";

			final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

			final String MESSAGE_2 = " seconds.";
			
			startTime = System.nanoTime();
			recursiveVersion(40);
			finishTime = System.nanoTime();
			elapsedTime = finishTime - startTime;
			System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2 + "(Recursive version)");
			startTime = System.nanoTime();
			originalRecursiveVersion(40);
			finishTime = System.nanoTime();
			elapsedTime = finishTime - startTime;
			System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2 + "(originalRecursiveVersion)");
			startTime = System.nanoTime();
			iterativeVersion(40);
			finishTime = System.nanoTime();
			elapsedTime = finishTime - startTime;
			System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2 + "(iterativeVersion)");
			startTime = System.nanoTime();
			formulaVersion(40);
			finishTime = System.nanoTime();
			elapsedTime = finishTime - startTime;
			System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2 + "(formulaVersion)");
	        }//try
	        catch (Exception e)
	        {
	          System.out.println (e);
	          sc.nextLine();
	        }//catch Exception      
	     }//while     
	     
	  } // method run

	  public static long recursiveVersion (int n)  
		{
		      final int MAX_N = 92;

		      final String ERROR_MESSAGE = "\nThe number entered must be " +
		            "greater than 0 and at most " + MAX_N + ".";

		       if (n <= 0 || n > MAX_N)
		            throw new IllegalArgumentException (ERROR_MESSAGE);
		       
		       return f (n,1,1);        
		  } // method fib
		  
		   public static long f (int n, long previous, long current)  
		   {
		       if (n <= 2 )
		           return current;
		       else{
		    	   long temp = current;
		    	   current = current + previous;
		    	   previous = temp;
		    	   return f(n-1,previous,current);
		       }
		   } // method f // method fib
		public static long originalRecursiveVersion (int n)  
		{
			final int MAX_N = 92;

		        final String ERROR_MESSAGE = "\nThe number entered must be " +
		            "greater than 0 and at most " + MAX_N + ".";

		        if (n <= 0 || n > MAX_N)
		            throw new IllegalArgumentException (ERROR_MESSAGE);
		  	if (n <= 2 )
		    	    return 1;
		    	return originalRecursiveVersion (n - 1) + originalRecursiveVersion (n - 2); 
		} // method fib
		public static long iterativeVersion (int n) 
		{
			final int MAX_N = 92;

		        final String ERROR_MESSAGE = "\nThe number entered must be " +
		            "greater than 0 and at most " + MAX_N + ".";

		        long previous,
		             current,
		             temp;

		        if (n <= 0 || n > MAX_N)
		            throw new IllegalArgumentException (ERROR_MESSAGE);
		  	if (n <= 2) 
		    		return 1;
		  	previous = 1;
		  	current = 1;
		  	for (int i = 3; i <= n; i++) 
		  	{
		    		temp = current;
		    		current = current + previous;
		    		previous = temp;    
		  	} // for
		  	return current;
		} // method fib
		public static long formulaVersion (int n)  
		{
			final int MAX_N = 92;

		        final String ERROR_MESSAGE = "\nThe number entered must be " +
		            "greater than 0 and at most " + MAX_N + ".";

		        if (n <= 0 || n > MAX_N)
		            throw new IllegalArgumentException (ERROR_MESSAGE);
		  
		  	return (long)((1 / Math.sqrt (5)) *
		                (Math.pow((1 + Math.sqrt (5)) / 2, n)- 
		           	Math.pow((1 - Math.sqrt (5)) / 2, n)));
		} // method fib
	}
		


