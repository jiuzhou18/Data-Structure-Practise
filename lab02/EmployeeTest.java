package lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

public class EmployeeTest {
	
	 protected FullTimeEmployee x,y,z;
	 
	 public static void main(String[] args){
		 Result result = runClasses(EmployeeTest.class);
		 System.out.println ("Tests run = " + result.getRunCount() +
				 "\nTests failed = " + result.getFailures() + 
				 "\nTests result = " + result.wasSuccessful());
	 }
	 

	@Before
	public void BeforeTest(){
		 x = new FullTimeEmployee("Bill" , 20);
		 y = new FullTimeEmployee("Bill" , 20);
		 z = new FullTimeEmployee("Bill" , 20);
	}
	
	@Test
	public void test1() {
		assertEquals(x.equals(x), true);
		assertEquals(x.equals(y) == y.equals(x), true);
		assertEquals(x.equals(z), (x.equals(y) && y.equals(z)));
		assertEquals(x.equals(y) == x.equals(y), true);
		assertEquals(x.equals(null), false);

	}

}
