package lab07;

public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;

   public void add(E element) {
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = element;
	   if(head==null){
		   head = tail = ne;
	   }
	   tail.next = ne;
	   tail = ne;
	   num_elements++;

      /*** Add code ***/
   }

   public E remove()  {
      if(head == null) return null;
      E e = head.element;
      head = head.next;
      if (head == null) tail = null;
      num_elements--;
      return e;
      /*** Add code ***/

   }
   public E peek()  {
	   if(head == null) return null;
	   return head.element;

      /*** Add code ***/

   }

   public boolean is_empty()  {
	   return head == null;

      /*** Add code ***/

   }

   public boolean is_full()  {
	   return head!=null;

      /*** Add code ***/

   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
}
