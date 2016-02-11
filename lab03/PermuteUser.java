package lab03;

import java.util.*;

public class PermuteUser
{
    public static void main (String [ ] args)
    {
        new PermuteUser().run();
    } // method main
    
  /**
   *  Permutes the input strings entered.
   */
  public void run()
  {
    final String SENTINEL = "***";

    final String INPUT_PROMPT =
        "\nPlease enter a string (or " + SENTINEL + " to quit): ";

    String line;
 
    Scanner sc = new Scanner (System.in);
     
    while (true)
    {
      try
      {
        System.out.print (INPUT_PROMPT);
        line = sc.nextLine(); 
        if (line.equals (SENTINEL))
            break;
        System.out.println (permute (line));
      }//try
      catch (Exception e) 
      {
        System.out.println (e);
      }//catch Exception
    }//while
  } // method run

  /**
   * Finds all permutations of a given string.
   *
   * @param s - the string to be permuted  
   *
   * @return a String representation of all the permutations of s.
   *    
   */
  public static String permute (String s)
   { 
	  StringBuffer sb=new StringBuffer(s);
      return newRecPermute (sb, 0);
   } // method permute
                             
  /**
   * Finds all permutations of a subarray from a given position to the end of the array.
   *
   * @param c - an array of characters
   * @param k - the starting position in c of the subarray to be permuted.
   *
   * @return a String representation of all the permutations.
   *    
   */
  protected static String recPermute (char[] c, int k)
  {
     if (k == c.length - 1)
        return String.valueOf (c) + "\n";
     else
     {
        String allPermutations = new String();

        char temp;

        for (int i = k; i < c.length; i++)
        {
			
            temp = c [i];
            c [i] = c [k];
            c [k] = temp;
            allPermutations += recPermute (String.valueOf (c).toCharArray(), k + 1);            
        } // for
        return allPermutations;
     } // else
 } // method recPermute
	
/**
   * Finds all permutations of a subarray from a given position to the end of the array.
   *
   * @param c - a StringBuffer of characters
   * @param k - the starting position in c of the subarray to be permuted.
   *
   * @return a String representation of all the permutations.
   *    
   */
  protected static String newRecPermute (StringBuffer c, int k)
  {
     if (k == c.length() - 1)
        return c + "\n";
     else
     {
		
        String allPermutations = new String();

        char temp;

        for (int i = k; i < c.length(); i++)
        {
			if((c.charAt(i)==c.charAt(k))&&(i!=k)) continue;
            temp = c.charAt(i);
            c.setCharAt(i,c.charAt(k));
            c.setCharAt(k,temp);
            allPermutations += newRecPermute (new StringBuffer(c.toString()), k + 1);            
        } // for
        return allPermutations;
     } // else
 } // method newRecPermute
  
} // class PermuteUser
