package lab07;

import java.util.Random;
import java.util.Scanner;

public class CarWash {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.print("Please enter the mean arrival time: ");
		int arrival = sc.nextInt(); sc.nextLine();
		System.out.print("Please enter the mean service time: ");
		int service = sc.nextInt(); sc.nextLine();
		System.out.print("Please enter the maximum arrival time:");
		int max = sc.nextInt(); sc.nextLine();
		CS401QueueLinkedListImpl<Integer> carArrive = poissionRun(arrival, max);
		CS401QueueArrayFixedImpl<Integer> waitlist = new CS401QueueArrayFixedImpl<Integer>(5);
		System.out.println("Time\tEvent\t\tWaiting Time");
		int carnum = 0, overflow = 0;
		int sumwait = 0, waittime = 0, clock = 0, leavetime = Integer.MAX_VALUE, nextarrive = 0;
		boolean bayEmpty = true;
		Integer cartime = carArrive.remove();
		while(cartime!=null||!waitlist.is_empty()){
			if(cartime==null||cartime>=leavetime){
				clock = leavetime;
				System.out.println(clock+"\t"+"Departure\t\t"+waittime);
				bayEmpty = true;
				if(!waitlist.is_empty()){	
					nextarrive = waitlist.remove();
					waittime = clock - nextarrive;
					sumwait += waittime;
					leavetime = clock + getTime(service);
					bayEmpty = false;
				}
			}else{
				if(!waitlist.is_full())	{
					waitlist.add(cartime);
					System.out.println(cartime+"\t"+"Arrive");
				}
				else {
					System.out.println(cartime+"\t"+"Arrive(Overflow)");
					overflow++;
				}
				carnum++;
				clock = cartime;
				if(bayEmpty == true){	
					nextarrive = waitlist.remove();
					waittime = clock - nextarrive;
					sumwait += waittime;
					leavetime = clock + getTime(service);
					bayEmpty = false;
				}
				cartime = carArrive.remove();
			}
			
		}
		clock = leavetime;
		System.out.println(clock+"\t"+"Departure\t\t"+waittime);
		System.out.println("The average waiting time was "+ sumwait/carnum+ " minutes per car.");
		System.out.println("The average queue length was "+ sumwait/clock+ " cars per minute");
		System.out.println("The number of overflows was "+ overflow);
		
	}
	
	protected static Random random;
	
	 public static CS401QueueLinkedListImpl<Integer> poissionRun(int arrival, int max)  {    
		 int time_till_next_arrival, current_time = 0;	
		 random = new Random(100);
		 CS401QueueLinkedListImpl<Integer> carArrive = new CS401QueueLinkedListImpl<Integer>();
		 while(true)  {
			 time_till_next_arrival = getTime(arrival);
			 
			 System.out.print("Time to next arrival is " + time_till_next_arrival +
					 ". ");
			 current_time += time_till_next_arrival;
			 carArrive.add(current_time);
			 System.out.print("Next arrival will occur at " + current_time + " ");
			 
			 if (current_time >= max)  {
				 System.out.println("(Out of bounds)");
				 break;
			 }
			 else
				 System.out.print("\n");
		 }
		 return carArrive;
	 }
	 
	 public static int getTime (int meanTime) 
	 {  
		 double randomDouble = random.nextDouble();
		 
		 return (int)Math.round (-meanTime*Math.log (1 - randomDouble)); 
	 } // getTime

}
