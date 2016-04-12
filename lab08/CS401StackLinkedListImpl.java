package lab08;

import java.util.Iterator;

public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> 
{
   private LinkEntry<E> head;
   private int num_elements;

   public CS401StackLinkedListImpl()
   {
      head = null;
      num_elements = 0;
   }

   public void push(E e)
   {
      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;
	   if (head == null){
    	  head = ne;
      }else{
    	  ne.next = head;
    	  head = ne;
      }
	   num_elements++;
	   /** Add code here **/
      return;
   }

   public E pop()
   {
	   if(head == null) return null;
	   E e = head.element;
	   head = head.next;
	   num_elements--;
	   return e;
      /** Add code here **/
   }

   public int size()
   {
	   return num_elements;
      /** Add code here **/
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
} /* CS401StackLinkedListImpl<E> */
