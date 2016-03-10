package lab07;

public class CS401StackArrayImpl<E> implements CS401StackInterface<E> 
{
   private int num_elements;
   private int max_elements;
   private E[] elements;

   public CS401StackArrayImpl()
   {
      max_elements = 10; 
      num_elements = 0;
      elements = (E[]) new Object[max_elements];
   }

   /**
    * Push an element on the stack.  If the stack is full, then allocate
    * more memory to hold a new stack, copy existing elements to the new
    * stack and add the new element to the newly enlarged stack.
    * Do not use System.arraycopy().  You are essentially implementing
    * what System.arraycopy() will do when you expand an existing array. **/
   public void push(E e)
   {
      if(num_elements == max_elements){
    	  max_elements *=2;
    	  E[] feiyu = (E[]) new Object[max_elements];
    	  System.out.println("Growing stack by "+ max_elements/2 +" elements.");
    	  for(int i=0; i<num_elements; i++){
    		  feiyu[i] = elements[i];
    	  }
    	  elements = feiyu;
      }
	  elements[num_elements] = e;
	  num_elements++;
	   /** Add code here **/
      return;
   }

   public E pop()
   {
	   if (num_elements == 0) return null;
	   num_elements --;
	   return elements[num_elements-1];
      /** Add code here **/
   }

   public int size()
   {
	   return num_elements;
      /** Add code here **/
   }

} /* CS401StackArrayImpl<E> */
