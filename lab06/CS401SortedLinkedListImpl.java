package lab06;

public class CS401SortedLinkedListImpl<E extends Comparable<E>> extends CS401LinkedListImpl<E>
{
   public CS401SortedLinkedListImpl()
   {
      super();
   }

   /** 
    * Adds element e in sorted order in the collection class (linked 
    * list).
    * Returns true if e was added successfully, false otherwise.
    */
   public boolean add(E e)
   {
      /**
       * Add code here. */
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element = e;
	   if (head == null && tail == null){
	          head = tail = ne;
	          num_elements++;
	          return true;
	   }else{		  
		   if (e.compareTo(tail.element)>=0){
			   tail.next = ne;
		       tail = ne;
		       num_elements++;
		       return true;
		   }
		   if (e.compareTo(head.element)<=0){
			   ne.next = head;
			   head = ne;
			   num_elements++;
		       return true;			   
		   }
		   LinkEntry<E> current = head;
		   LinkEntry<E> previous = null;
		   while (e.compareTo(current.element)==1){
			   previous = current;
			   current = current.next;
		   }
		   previous.next = ne;
		   ne.next = current;
		   num_elements++;
	       return true;	
	   }
	   
	   
      
   }

   /**
    * Print the sorted linked list in reverse order using recursion.
    */
   public void reverse_print()  {
      /**
       * Add code here 
       */
	   reversePrint(head);
	   System.out.println();
   }
   public void reversePrint(LinkEntry<E> link){
	   if (link == null) return;
	   else{
		   reversePrint(link.next);
		   System.out.print(link.element.toString());
	   }
   }

} /* CS401SortedLinkedListImpl<E> */

