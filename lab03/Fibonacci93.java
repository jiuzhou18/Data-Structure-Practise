package lab03;

import java.math.BigInteger;

public class Fibonacci93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger fi93 = BigInteger.valueOf(FibonacciUser.recursiveVersion(91));
		fi93 = fi93.add(BigInteger.valueOf(FibonacciUser.recursiveVersion(92)));
		System.out.println("The 93rd result is :" + fi93);

	}

}
