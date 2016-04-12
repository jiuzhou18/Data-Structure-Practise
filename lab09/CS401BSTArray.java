package lab09;

import lab09.CS401BST.TreeNode;

public class CS401BSTArray<E extends Comparable <E>> {
   protected TreeNode<E> [] tree;
   protected int root, size, indx;
	
   public CS401BSTArray() {
       /**
        * Do not initialize tree as: tree=(TreeNode<E> []) new Object[50];
        * While this will compile, it will throw a ClassCastException
        * when run.  Instead, use the initialization below.  Even the one
        * shown below is not the best, since Java does not allow a clean
        * way to allocate memory to hold an array of generic class objects.
        * For more information, see
        * https://courses.cs.washington.edu/courses/cse332/10su/notes/
        * genericArrays.html 
        * (Mind the line break in the above URL.  When you go to the above
        * URL, see Workaround #2.) */
      tree =  (TreeNode<E>[]) new TreeNode[50];
      root = 0;
      size = 50;
      indx = 0;
   }

   protected static class TreeNode<E> {
      E element;
      int parent, left, right;
		
      public TreeNode (E element, int parent, int left, int right) {
         this.element = element;
         this.parent = parent;
         this.left = left;
         this.right = right;
      }
   }
   
   public int size( )
   {
       return indx;
   } // method size()
   
   public void inorder()  {
       inorder_p(root);
    }
   private void inorder_p(int root)  {
       if (root != -1)  {
           inorder_p(tree[root].left); 
           System.out.println(tree[root].element);
           inorder_p(tree[root].right);
       }
    }
   
   public boolean contains (Object obj) 
   {
       return getTreeNode (obj) != null;
   } // method contains
   
   public boolean remove (Object obj)
   {
       TreeNode<E> e = getTreeNode (obj);
       if (e == null)
           return false;
       deleteTreeNode (e);       
       return true;
   } // method remove
   
   public void grow(){
	   
	   TreeNode<E> [] temp = new TreeNode[size*2];
	   for(int i=0; i<indx; i++){
		   temp[i] = tree[i];
	   }
	   tree = temp;
	   size *=2;
   }

   public boolean add(E element)  {
	   boolean r = false;
	   if(indx == 0){
    	  tree[indx] = new TreeNode(element, -1, -1, -1);
    	  r = true;
      }else{
    	  int current = root;
    	  int comp;
    	  while (true){
    		  comp = ((Comparable)element).compareTo(tree[current].element);
    		  if (comp == 0){
    			  r = false;
    			  break;
    		  }
    		  if (comp < 0)
    			  if (tree[current].left != -1)
    				  current = tree[current].left;
    			  else 
    			  {
    				  if(indx == size) this.grow();
    				  tree[indx] = new TreeNode(element, current, -1, -1);
    				  tree[current].left = indx;                  
    				  r = true;break;
    			  } // temp.left == null
    		  else if (tree[current].right != -1)
    			  current = tree[current].right;
    		  else 
    		  {
    			  if(indx == size) this.grow();
    			  tree[indx] = new TreeNode(element, current, -1, -1);
    			  tree[current].right = indx;                      
    			  r = true;break;
    		  } // temp.right == null
    	  }	  
      }
	   
      if(r==true) indx++;
      return r;
   }
   
   
   protected TreeNode<E> getTreeNode (Object obj) 
   {
       int comp;

       if (obj == null)
          throw new NullPointerException();
       int current = root;
       while (current != -1) 
       {
           comp = ((Comparable)obj).compareTo (tree[current].element);
           if (comp == 0)
               return tree[current];
           else if (comp < 0)
               current = tree[current].left;
           else
        	   current = tree[current].right;
       } // while
       return null;
   } // method getTreeNode
   
   protected TreeNode<E> deleteTreeNode (TreeNode<E> p) 
   {
	   int local = -1;
	   if (p.parent != -1)
	   if (p == tree[tree[p.parent].left])
    	   local = tree[p.parent].left;
       else
    	   local = tree[p.parent].right;

       // If p has two children, replace p's element with p's successor's
       // element, then make p reference that successor.
       if (p.left != -1 && p.right != -1) 
       {
           TreeNode<E> s = successor (p);
           p.element = s.element;
           p = s;
       } // p had two children
       // At this point, p has either no children or one child.

       int replacement;
        
       if (p.left != -1)
           replacement = p.left;
       else
           replacement = p.right;

       // If p has at least one child, link replacement to p.parent.
       if (replacement != -1) 
       {
           tree[replacement].parent = p.parent;
           if (p.parent == -1)
               root = replacement;
           else if (p == tree[tree[p.parent].left])
        	   tree[p.parent].left  = replacement;
           else
        	   tree[p.parent].right = replacement;
       } // p has at least one child  
       else if (p.parent == -1)
           local = 0;
       else 
       {
           if (p == tree[tree[p.parent].left])
        	   tree[p.parent].left = -1;
           else
        	   tree[p.parent].right = -1;        
       } // p has a parent but no children
       
       for(int i = local; i<indx-1; i++){
    	   tree[local] = tree[local+1];
    	   if (local+1 == tree[tree[local].parent].left)
    		   tree[tree[local].parent].left = local;
    	   else
    		   tree[tree[local].parent].right = local;
    	   if(tree[local].left !=-1)
    		   tree[tree[local].left].parent = local;
    	   if(tree[local].right !=-1)
    		   tree[tree[local].right].parent = local;
       }       
       indx--;
       return p;
   } // method deleteTreeNode
   
   protected TreeNode<E> successor (TreeNode<E> e) 
   {
       if (e == null)
           return null;
       else if (e.right != -1) 
       {
           // successor is leftmost TreeNode in right subtree of e
           TreeNode<E> p = tree[e.right];
           while (p.left != -1)
               p = tree[p.left];
           return p;

       } // e has a right child
       else 
       {

           // go up the tree to the left as far as possible, then go up
           // to the right.
           int p = e.parent;
           TreeNode<E> ch = e;
           while (p != -1 && ch == tree[tree[p].right]) 
           {
               ch = tree[p];
               p = tree[p].parent;
           } // while
           return tree[p];
       } // e has no right child
   } // method successor

   /**
    * print - Prints the array based tree as a table with 4 columns.
    */
   void print()  {
      int indx;

      for (indx = 0; indx < size; indx++)  {
         System.out.println(tree[indx].element + ", " +
                            tree[indx].parent  + ", " +
                            tree[indx].left    + ", " +
                            tree[indx].right);
      }
   }

   public static void main(String[] args)  {
      CS401BSTArray<Integer> myGenClassArray = new CS401BSTArray<Integer>();

      myGenClassArray.add(33);
      myGenClassArray.add(20);
      myGenClassArray.add(40);

      myGenClassArray.print();
   }
}
