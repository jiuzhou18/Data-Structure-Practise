package lab04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;

import lab02.EmployeeTest;
import lab02.FullTimeEmployee;

import static org.junit.runner.JUnitCore.runClasses;

public class PowerTest extends Power{
	 
	protected int i ,n;
	protected long value;
	
	 public static void main(String[] args){
		 Result result = runClasses(PowerTest.class);
		 System.out.println ("Tests run = " + result.getRunCount() +
				 "\nTests failed = " + result.getFailures() + 
				 "\nTests result = " + result.wasSuccessful());
	 }
	 

	@Before
	public void BeforeTest(){
		  i = 20;
		  n = 8;
		  value = 25600000000L;
	}
	@Test
	public void test1() {
		assertEquals(value, power(i,n));
	
	}
	@Test
	public void test2() {		
		assertEquals(value, iterativePower(i,n));
	}
	@Test
	public void test3() {
		assertEquals(value, recursivePower(i,n));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test4() {
		assertEquals(value, power(i,-1));
	}
	@Test (expected = IllegalArgumentException.class)
	public void test5() {
		assertEquals(value, iterativePower(i,-1));
	}

	@Test (expected = IllegalArgumentException.class)
	public void test6() {
		assertEquals(value, recursivePower(i,-1));
	}



}
