package lab04;

public class RecMin {

	public static void main(String[] args) {
		int[] a = {10, -20, 1, 2, 0, 5, 100};
		int s = minimum(a, a.length-1);
		System.out.println("The smallest element is " + s + ".");
		
	}
	public static int minimum (int[] A, int size){
		if (size == 0) return A[0];
		int temp = minimum(A, size-1);
			if (temp > A[size])
				temp = A[size];
		return temp;
	}

}
