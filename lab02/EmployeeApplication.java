package lab02;

public class EmployeeApplication {

	public static void main(String[] args) {
		FullTimeEmployee x = new FullTimeEmployee("Bill" , 20);
		FullTimeEmployee y = new FullTimeEmployee("Bill" , 20);
		FullTimeEmployee z = new FullTimeEmployee("Bill" , 20);
		 
		System.out.println("No.1 " + x.equals(x));
		System.out.println("No.2 " + (x.equals(y) == y.equals(x)));
		if(x.equals(y)==true && y.equals(z)==true)
			System.out.println("No.3 " + x.equals(z));
		System.out.println("No.4 " + (x.equals(y) == x.equals(y)));
		System.out.println("No.5 " + x.equals(null));


	}

}
