package lab07;

import java.util.Random;

public class Poisson  {

   protected Random random;

   public static void main(String args[])  {
      new Poisson().run();
   }

   public void run()  {
      int time_till_next_arrival, current_time = 0;

      random = new Random(100);

      while(true)  {
         time_till_next_arrival = getTime(3);

         System.out.print("Time to next arrival is " + time_till_next_arrival +
                          ". ");
         current_time += time_till_next_arrival;
         System.out.print("Next arrival will occur at " + current_time + " ");

         if (current_time >= 25)  {
             System.out.println("(Out of bounds)");
             break;
         }
         else
            System.out.print("\n");
      }
   }

   protected int getTime (int meanTime) 
   {  
      double randomDouble = random.nextDouble();
    
      return (int)Math.round (-meanTime*Math.log (1 - randomDouble)); 
   } // getTime
}
