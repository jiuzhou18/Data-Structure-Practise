package lab06;

import java.util.Iterator;

import lab06.CS401LinkedListImpl.LinkEntry;

public class CS401DblLinkedListImpl<E> extends CS401LinkedListImpl<E> 
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements = 0;

   public CS401DblLinkedListImpl()
   {
      head = tail = null;
   }

   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /*
    * Add e to the end of the doubly linked list.
    * Returns true - if e was successfully added, false otherwise.
    */
   public boolean add(E e)
   {
      /** Add code here **/
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;
	   if(head == null && tail == null){
		   head = tail = ne;
		   num_elements++;
		   return true;
	   }
	   ne.previous = tail;
	   tail.next = ne;
	   tail = ne;
	   num_elements++;
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
		   LinkEntry<E> current = null;
		   
		   if(i==1){
			   current = head;
			   head = head.next;
			   head.previous = null;
			   num_elements--;
			   return current.element;
			   
		   }
		   if(i==(num_elements)){
			   current = tail;
			   tail = tail.previous;
			   tail.next = null;
			   num_elements--;
			   return current.element;
		   }
		   
		   if (i <= num_elements/2){
			   current = head;
			   for (int j=1; j<i; j++){
				   current = current.next;
			   }
		   }else{
			   current = tail;
			   for (int j=num_elements; j>i; j--){
				   current = current.previous;
			   }
		   }
		   current.previous.next = current.next;
		   current.next.previous = current.previous;
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
      return true;
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
      
      
      /**
       * Add code here.
       * Hint: follow the same logic as 
       * CS401LinkedListImpl::add(Where where, E e) except account for 
       * the previous and next references in the doubly linked list. */
      if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         ne.previous = tail;
    	 tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  {
          /**
           * Add code here. */
    	  ne.next = head;
    	  head.previous = ne;
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
       * Add code here. 
       * Hint: follow the same logic as 
       * CS401LinkedListImpl::add(Where where, int index, E e) except 
       * account for the previous and next references in the doubly 
       * linked list. */

	   if(where!=Where.MIDDLE) return false;
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;
	   LinkEntry<E> current =null;
	   if (index <= num_elements/2){
		   current = head;
		   for (int i=1; i<index; i++){
			   current = current.next;
		   }
	   }else{
		   current = tail;
		   for (int i=num_elements; i>index; i--){
			   current = current.previous;
		   }
	   }
	   ne.next = current.next;
	   current.next = ne;
	   ne.previous = current;
	   ne.next.previous = ne;
	   num_elements++;
      return true;
   }

   /**
    * Print the doubly linked list starting at the beginning.
    */
   public void print_from_beginning()
   {
      /** Add code here **/
	   StringBuilder result = new StringBuilder();
	   LinkEntry<E> current = head;
	   for(int i=1; i<=num_elements; i++){
		   result.append(current.element.toString());
		   current = current.next;
	   }
      System.out.println(result.toString());
      return;
   }

   /**
    * Print the doubly linked list starting the end.
    */
   public void print_from_end()
   {
      /** Add code here **/
	   StringBuilder result = new StringBuilder();
	   LinkEntry<E> current = tail;
	   for(int i=num_elements; i>=1; i--){
		   result.append(current.element.toString());
		   current = current.previous;
	   }
      System.out.println(result.toString());
      return;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry<E> previous;

      protected LinkEntry() { element = null; next = previous = null; }
   }
} /* CS401LinkedListImpl<E> */
