package lab06;

public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>
{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;

   public CS401LinkedListImpl()
   {
      head = tail = null;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /* 
    * Adds element e at the end of the linked list. */
   public boolean add(E e)
   {
      add(Where.BACK, e);
      
      return true;
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
      /**
       * Add code here. */

	   if (i<=num_elements){
		   LinkEntry<E> privious = null;
		   LinkEntry<E> current = head;
		   for (int j=1; j<i; j++){
			   privious = current;
			   current = current.next;
		   }
		   if(i==1){
			   head = head.next;
		   }
		   if(i==(num_elements)){
			   tail = privious;
		   }
		   if(privious!=null) privious.next = current.next;
		   current.next = null;
		   num_elements--;
		   return current.element;		   
	   }
	   
      return null;
   }

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      /**
       * Add code here. */ 
	   LinkEntry<E> current = head;
	   for(int i=1; i<=num_elements; i++){
		   if (current.element.equals(e)) return true;
		   current = current.next;
	   }
      return false;
   }   
   
   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

      if (where == Where.MIDDLE) 
          return false;

      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  {
          /**
           * Add code here. */
    	  ne.next = head;
    	  head = ne;
      }
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  First element of the linked list
    * is 0, second is 1, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {
	   
      /**
       * Add code here. */
	   
	   if(where!=Where.MIDDLE) return false;
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;
	   LinkEntry<E> current = head;
	   for (int i=1; i<index; i++){
		   current = current.next;
	   }
	   ne.next = current.next;
	   current.next = ne;
	   num_elements++;
      return true;
   }

   /**
    * Print the collection class (linked list) by iterating over all of
    * the elements in the collection class and serializing them. 
    * Returns a Java String object that represents the serialization of
    * the collection class. */
   public String toString()  {

      StringBuilder result = new StringBuilder();
 
      /**
       * Add code here. 
       * Traverse the linked list and serialize each object.  Add the
       * serialized form to result. */
      LinkEntry<E> current = head;
      for(int i=1; i<=num_elements; i++){
    	  result.append(current.element.toString());
    	  current = current.next;
      }
      

      return result.toString();
   }
   

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
   }
   /* ------------------------------------------------------------------- */

} /* CS401LinkedListImpl<E> */

