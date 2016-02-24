package lab05;

public class CS401ArrayImpl<E extends Comparable> implements CS401CollectionInterface<E>
{
   private E[] elements;
   private int num_elements;

   private int capacity = 5;

   @SuppressWarnings("unchecked")
   public CS401ArrayImpl()
   {
      elements = (E[]) new Comparable[capacity];
      num_elements = 0;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_full()
   {
      if (num_elements == capacity)
          return true;
      return false;
   }

   public boolean is_empty()
   {
      if (num_elements == 0) 
          return true;
      return false;
   }

   public int size() { return num_elements; }

   public boolean add(E e)  {
      add(Where.BACK, e);  // Add at the end
      return true;
   }

   /*
    * Remove element at index i.  If the element exists in the collection, 
    * return that element back to the user.  If the index is out of bounds,
    * return null.
    */
   public E remove(int i) {
      /*
       * Add code here.
       * Remember to compact the array so there are no spaces in between
       * if an element from the middle is removed or an element at the
       * beginning of the array is removed.
       */
	  if(i<num_elements){
		  E temp = elements[i];
		  for(int j=i+1; j<num_elements; j++ ){
			  elements[j-1] = elements[j];
		  }
		  num_elements--;
		  return temp;
	  }
	  
      return null;
   }

   /*
    * Return true if e is in the collection class, false otherwise.
    */
   public boolean contains(E e) {
       /*
        * Add code here
        */
	   for(int i=0; i<num_elements; i++){		   
		   if (elements[i].compareTo(e) == 0) return true;
	   }
       return false;
   }

   /**
    * ---- Methods defined by this class 
    * ----------------------------------------------------------
    * Methods that are added by this class and not in the 
    * CS401CollectionInterface
    */

   /**
    * Add element in middle.
    * Preconditions: where == MIDDLE
    *                index <= num_elements - 1
    */
   public boolean add(Where where, int index, E e) { 
  
      /* 
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }
      if (where!=Where.MIDDLE) return false;
      for(int i=num_elements; i>index; i--){
    	  elements[i] = elements[i-1];
      }
      elements[index] = e;
      num_elements++;
      
      /**
       * Add code here 
       */
      return true; 
   }

   /**
    * Add element in front or at the end, as dictated by where.
    * Preconditions: where != MIDDLE
    */
   public boolean add(Where where, E e) { 
   
      /* 
       * If there is no space to add the new element, grow the array. */
      if (is_full())  {
          grow();
      }

      if (where == Where.BACK)  {
          System.out.println("Inserting element at index " + num_elements);
          elements[num_elements] = e;
          num_elements++;
      } 
      else if (where == Where.FRONT)  {
          System.out.println("Inserting element at index 0");
          System.out.println("Compacting storage");
          
          for(int i=num_elements; i>0; i--){
        	  elements[i] = elements[i-1];
          }
          elements[0] = e;
          num_elements++;
          /*
           * Add code here.
           * You will add the new element at index 0, and shift all the
           * elements down by one. */
      }

      return true; 
   }

   /*
    * Gets the element at index i (0 <= i <= num_elements-1)
    */
   public E get(int i)  {

      if (i < 0 && i > num_elements)
          return null;

      return(elements[i]);
   }

   /**
    * ----------- Private methods
    */
   /*
    * Grows elements array to hold more elements.  Copies old (existing)
    * elements in the new array.
    * 
    * Postcondition: (a) elements must contain the contents of the old array
    *                (b) elements must now have twice as much capacity as
    *                    before
    */
   @SuppressWarnings("unchecked")
   private boolean grow()  {

      E[] neweles = (E[]) new Comparable[capacity*2];
	  for(int i=0; i<num_elements; i++){
		  neweles[i] = elements[i];
	  }
      elements = neweles;     
      capacity *=2;
	   /* 
       * Add code here 
       * Expand capacity (double it) and copy old array contents to the
       * new one. 
       */

      System.out.println("Capacity reached.  Increasing storage...");
      System.out.println("New capacity is " + capacity + " elements");

      return true;
   }
   
   /**
   * subList(int from, int to): Returns the view of a portion of the list between the specified index from,
   * inclusive, and index to, exclusive. That is returns a sublist [from, to).
   *
   * Ensure that from and to are valid indices.
   *
   * The method returns a new CS401ArrayImpl<E> object.
   */
   public CS401ArrayImpl<E> subList(int from, int to){
	   if(to<=from) return null;
	   CS401ArrayImpl subArray = new CS401ArrayImpl();
	   for(int i=from; i<to; i++){
		   subArray.add(Where.BACK, elements[i]);
	   }
	   return subArray;
   }


}
