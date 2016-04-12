package lab09;

import java.util.*;

public class CS401BST<E>
{
    protected TreeNode<E> root;

    protected int size;        
    
    /**
     *  Initializes this Binary Search Tree object to be empty
     */ 
    public CS401BST() 
    {
        root = null;
        size = 0;  
    } // default constructor


    /**
     *  Returns the size of this BinarySearchTree object.
     *
     * @return the size of this BinarySearchTree object.
     *
     */
    public int size( )
    {
        return size;
    } // method size()
  
    public void inorder()  {
       inorder_p(root);
    }

    /**
     *  Determines if there is at least one element in this BinarySearchTree 
     *  object that equals a specified element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).  
     *
     *  @param obj - the element sought in this BinarySearchTree object.
     *
     *  @return true - if there is an element in this BinarySearchTree object
     *                the equals obj; otherwise, return false.
     *
     *  @throws ClassCastException - if obj cannot be compared to the 
     *           elements in this BinarySearchTree object. 
     *  @throws NullPointerException - if obj is null.
     *  
     */ 
    public boolean contains (Object obj) 
    {
        return getTreeNode (obj) != null;
    } // method contains

    /**
     *  Ensures that this BinarySearchTree object contains a specified element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     *  @param element - the element whose presence is ensured in this 
     *                 BinarySearchTree object.
     *
     *  @return true - if this BinarySearchTree object changed as a result of 
     *                 this method call (that is, if element was actually 
     *                 inserted); otherwise, return false.
     *
     *  @throws ClassCastException - if element cannot be compared to the 
     *                  elements already in this BinarySearchTree object.
     *  @throws NullPointerException - if element is null.
     *
     */
    public boolean add (E element)  
    {
        if (root == null) 
        {
            if (element == null)
                throw new NullPointerException();
            root = new TreeNode<E> (element, null);
            size++;             
            return true;
        } // empty tree
        else 
        {
            TreeNode<E> temp = root;

            int comp;

            while (true) 
            {
                comp =  ((Comparable)element).compareTo (temp.element);
                if (comp == 0)
                    return false;
                if (comp < 0)
                    if (temp.left != null)
                        temp = temp.left;
                    else 
                    {
                        temp.left = new TreeNode<E> (element, temp);
                        size++;                             
                        return true;
                    } // temp.left == null
                    else if (temp.right != null)
                        temp = temp.right;
                else 
                {
                        temp.right = new TreeNode<E> (element, temp);
                        size++;                           
                        return true;
                } // temp.right == null
            } // while
        } // root not null
    } // method add
    
    public boolean recursiveAdd(E element){
    	if (root == null) 
        {
            if (element == null)
                throw new NullPointerException();
            root = new TreeNode<E> (element, null);
            size++;             
            return true;
        } // empty tree
    	else return recurAdd(root, element);   	
    }
    public boolean recurAdd(TreeNode<E> temp, E element){
    	int comp = ((Comparable)element).compareTo (temp.element);
    	if (comp == 0)
            return false;
        if (comp < 0)
            if (temp.left != null)
                return recurAdd(temp.left, element);
            else 
            {
                temp.left = new TreeNode<E> (element, temp);
                size++;                             
                return true;
            } // temp.left == null
        else if (temp.right != null)
            	return recurAdd(temp.right, element);
        else 
        {
        	temp.right = new TreeNode<E> (element, temp);
        	size++;                           
        	return true;
        } 
    }
    
    

    /**
     *  Ensures that this BinarySearchTree object does not contain a specified 
     *  element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     *  @param obj - the object whose absence is ensured in this 
     *                 BinarySearchTree object.
     *
     *  @return true - if this BinarySearchTree object changed as a result of
     *                this method call (that is, if obj was actually removed); 
     *                otherwise, return false.
     *
     *  @throws ClassCastException - if obj cannot be compared to the 
     *                  elements already in this BinarySearchTree object. 
     *  @throws NullPointerException - if obj is null.
     *
     */
    public boolean remove (Object obj)
    {
        TreeNode<E> e = getTreeNode (obj);
        if (e == null)
            return false;
        deleteTreeNode (e);       
        return true;
    } // method remove


    /**
     *  Finds the TreeNode object that houses a specified element, if there is 
     *  such an TreeNode.
     *  The worstTime(n) is O(n), and averageTime(n) is O(log n).
     *
     *  @param obj - the element whose TreeNode is sought.
     *
     *  @return the TreeNode object that houses obj - if there is such an TreeNode;
     *                otherwise, return null.  
     *
     *  @throws ClassCastException - if obj is not comparable to the elements
     *                  already in this BinarySearchTree object.
     *  @throws NullPointerException - if obj is null.
     *
     */
    protected TreeNode<E> getTreeNode (Object obj) 
    {
        int comp;

        if (obj == null)
           throw new NullPointerException();
        TreeNode<E> e = root;
        while (e != null) 
        {
            comp = ((Comparable)obj).compareTo (e.element);
            if (comp == 0)
                return e;
            else if (comp < 0)
                e = e.left;
            else
                e = e.right;
        } // while
        return null;
    } // method getTreeNode
    
  

     /**
      *  Deletes the element in a specified TreeNode object from this 
      *  BinarySearchTree.
      *  
      *  @param p - the TreeNode object whose element is to be deleted from this
      *                 BinarySearchTree object.
      *
      *  @return the TreeNode object that was actually deleted from this
      *                BinarySearchTree object. 
      *
      */
    protected TreeNode<E> deleteTreeNode (TreeNode<E> p) 
    {
        size--;

        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if (p.left != null && p.right != null) 
        {
            TreeNode<E> s = successor (p);
            p.element = s.element;
            p = s;
        } // p had two children


        // At this point, p has either no children or one child.

        TreeNode<E> replacement;
         
        if (p.left != null)
            replacement = p.left;
        else
            replacement = p.right;

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) 
        {
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;
        } // p has at least one child  
        else if (p.parent == null)
            root = null;
        else 
        {
            if (p == p.parent.left)
                p.parent.left = null;
            else
                p.parent.right = null;        
        } // p has a parent but no children
        return p;
    } // method deleteTreeNode


    /**
     *  Finds the successor of a specified TreeNode object in this 
     *  BinarySearchTree. The worstTime(n) is O(n) and averageTime(n) is 
     *  constant.
     *
     *  @param e - the TreeNode object whose successor is to be found.
     *
     *  @return the successor of e, if e has a successor; otherwise, return null
     *
     */
    protected TreeNode<E> successor (TreeNode<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != null) 
        {
            // successor is leftmost TreeNode in right subtree of e
            TreeNode<E> p = e.right;
            while (p.left != null)
                p = p.left;
            return p;

        } // e has a right child
        else 
        {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            TreeNode<E> p = e.parent;
            TreeNode<E> ch = e;
            while (p != null && ch == p.right) 
            {
                ch = p;
                p = p.parent;
            } // while
            return p;
        } // e has no right child
    } // method successor
    
    protected static class TreeNode<E> 
    {
        protected E element;

        protected TreeNode<E> left = null,
                           right = null,
                           parent;
 
        /**
         *  Initializes this TreeNode object.
         *
         *  This default constructor is defined for the sake of subclasses of
         *  the BinarySearchTree class. 
         */
        public TreeNode() { }

        /**
         *  Initializes this TreeNode object from element and parent.
         *
         */ 
         public TreeNode (E element, TreeNode<E> parent) 
         {
             this.element = element;
             this.parent = parent;
         } // constructor

    } // class TreeNode

    private void inorder_p(TreeNode<E> root)  {
       if (root != null)  {
           inorder_p(root.left); 
           System.out.println(root.element);
           inorder_p(root.right);
       }
    }

} // class BinarySearchTree

