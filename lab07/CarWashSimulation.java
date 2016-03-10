package lab07;

import java.util.Random;
import java.util.Scanner;

public class CarWashSimulation {

	protected static Random random;
	
	public static void main(String[] args) {
		final String ARRIAL = "Please enter the mean arrival time: ";
		final String SERVICE = "Please enter the mean service time: ";
		final String MAX = "Please enter the maximum arrival time:";
		Scanner in = new Scanner(System.in);	
		System.out.print(ARRIAL);
		int arrival = in.nextInt(); 
		System.out.print(SERVICE);
		int service = in.nextInt(); 
		System.out.print(MAX);
		int max = in.nextInt();
		in.nextLine();
		
		CS401QueueArrayFixedImpl<Integer> waitlist = new CS401QueueArrayFixedImpl<Integer>(5);
		System.out.println("Time\tEvent\t\tWaiting Time");
		boolean empty = true;
		int carNumber = 0, overflow = 0;
		int waitWhole = 0, waittime = 0, clock = 0, leavetime = Integer.MAX_VALUE, nextarrive = 0, goService = 0;
		
		random = new Random(100);
		nextarrive = getTime(arrival);
		if(nextarrive >= max) nextarrive = -1;
		
		
		while(nextarrive != -1 || !waitlist.is_empty()){
			if(nextarrive == -1 || nextarrive >= leavetime){
				clock = leavetime;
				System.out.println(clock+"\t"+"Departure\t\t"+waittime);
				empty = true;
				if(!waitlist.is_empty()){	
					empty = false;
					goService = waitlist.remove();
					waittime = clock - goService;
					waitWhole += waittime;
					leavetime = clock + getTime(service);
				}else leavetime = Integer.MAX_VALUE;
			}else{
				clock = nextarrive;
				if(!waitlist.is_empty() && empty == true){	
					empty = false;
					goService = waitlist.remove();
					waittime = clock - goService;
					waitWhole += waittime;
					leavetime = clock + getTime(service);
				}
				if(!waitlist.is_full())	{
					waitlist.add(nextarrive);
					System.out.println(nextarrive+"\t"+"Arrive");
				}
				else {
					System.out.println(nextarrive+"\t"+"Arrive(Overflow)");
					overflow++;
				}
				carNumber++;
				if(empty == true){	
					empty = false;
					goService = waitlist.remove();
					leavetime = clock + getTime(service);
				}

				nextarrive = clock + getTime(arrival);
				if(nextarrive >= max) nextarrive = -1;
			}
		}
		clock = leavetime;
		System.out.println(clock+"\t"+"Departure\t\t"+waittime);
		System.out.println("The average waiting time was "+ (double)waitWhole/carNumber+ " minutes per car.");
		System.out.println("The average queue length was "+ (double)waitWhole/clock+ " cars per minute");
		System.out.println("The number of overflows was "+ overflow);
		
	}

	 
	 public static int getTime (int meanTime) 
	 {  
		 
		 double randomDouble = random.nextDouble();
		 
		 return (int)Math.round (-meanTime*Math.log (1 - randomDouble)); 
	 } // getTime
		

	

}
