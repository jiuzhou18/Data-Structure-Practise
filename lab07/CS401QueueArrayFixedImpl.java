package lab07;


/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      if (back == capacity){
    	  capacity *= 2 ;
    	  E[] newData = (E[]) new Object[capacity];
    	  for (int i=0; i<back; i++){
    		  newData[i] = data[i];
    	  }
    	  data = newData;
      }
      data[back] = element;
      back++;
	   /*** Add code ***/
   }

   public E remove()  {
      if(back == 0) return null;
      E e = data[0];
      for(int i=1; i<back; i++){
    	  data[i-1] = data[i];
      }
	   back--;
	   return e;
      /*** Add code ***/
   }

   public E peek()  {
	   if(back == 0) return null;
	   return data[0];

      /*** Add code ***/
   }

   public boolean is_empty()  {
	   return (back==0);

      /*** Add code ***/
   }

   public boolean is_full()  {
	   return(back==capacity);

      /*** Add code ***/

   }
}
