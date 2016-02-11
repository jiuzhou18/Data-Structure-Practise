package lab03;

import static org.junit.Assert.*;

import org.junit.Test;



	/**
	 *  Returns the nth Fibonacci number.
	 *
	 *  @param n - the integer whose Fibonacci number is sought.
	 *
	 * @throws IllegalArgumentException - if n <= 0 or > 92 (note 
	 *         that fib (93) is larger than Long.MAX_VALUE).
	 *
	 */

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;

public class FibonacciTest{
	public static void main(String[ ] args)
	{  
		Result result = runClasses (FibonacciTest.class);
		System.out.println ("Tests run = " + result.getRunCount() +
				"\nTests failed = " + result.getFailures());
	} // method main          
	
	@Test (expected = IllegalArgumentException.class)
	public void test1Illegal()
	{
		fib (0);    
	} // method test1Illegal
	
	@Test (expected = IllegalArgumentException.class)
	public void test93Illegal()
	{
		fib (93);    
	} // method test93Illegal
	
	@Test
	public void test1Legal()
	{        
		assertEquals (1, fib (1));    
	} // method test1Legal
	
	@Test
	public void test5Legal()
	{        
		assertEquals (5, fib (5));    
	} // method test5Legal
	
	@Test
	public void test10Legal()
	{        
		assertEquals (55, fib (10));    
	} // method test10Legal
	
	@Test
	public void test15Legal()
	{      
		assertEquals (610, fib (15));    
	} // method test15Legal
	
	public static long fib (int n)  
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
	
} // class FibonacciTest   


