package lab07;

/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {
	   if(front<back && back-front == capacity-1){
		   capacity *= 2 ;
		   E[] newData = (E[]) new Object[capacity];
		   for (int i=0; i<back; i++){
			   newData[i] = data[i];
		   }
		   data = newData;
	   }else if (front>back && front-back == 1){
		   capacity *= 2 ;
		   E[] newData = (E[]) new Object[capacity];
		   for (int i=0; i<back; i++){
			   newData[i] = data[i];
		   }
		   for(int i=capacity/2-1; i>=front; i--){
			   newData[i+capacity/2] = data[i];
		   }
		   front += capacity/2;
	   }
	   data[back] = element;
	   back = (back+1) % capacity;

      /*** Add code ***/
   }

   public E remove()  {
	   if(back==front) return null;
	   E e = data[front];
	   front = (front+1) % capacity;
	   return e;
      
      /*** Add code ***/

   }
   public E peek()  {
	   if(back==front) return null;
	   return data[front];

      /*** Add code ***/

   }

   public boolean is_empty()  {
	   return(back==front);

      /*** Add code ***/

   }

   public boolean is_full()  {
	   return((front<back && back-front == capacity-1)||front>back && front-back == 1);
      /*** Add code ***/

   }

}
