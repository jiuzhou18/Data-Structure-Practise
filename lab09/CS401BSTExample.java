package lab09;

public class CS401BSTExample
{
  public static void main (String[] args)
  {
    new CS401BSTExample().run();
  } // method main
  
  public void run()
  {
    CS401BST<String> tree1 = new CS401BST<String>();
    
    tree1.add ("yes");
    tree1.add ("no");
    tree1.add ("maybe");
    tree1.add ("always");
    tree1.add ("no"); // not added: duplicate element
    if (tree1.remove ("often"))
      System.out.println ("How did that happen?");
    else
      System.out.println (tree1.remove ("maybe"));
    System.out.println("Elements in tree1: ");
    tree1.inorder();
    
    CS401BST<String> tree3 = new CS401BST<String>();
    System.out.println();
    tree3.recursiveAdd ("yes");
    tree3.recursiveAdd ("no");
    tree3.recursiveAdd ("maybe");
    tree3.recursiveAdd ("always");
    tree3.recursiveAdd ("no"); // not added: duplicate element
    if (tree3.remove ("often"))
      System.out.println ("How did that happen?");
    else
      System.out.println (tree3.remove ("maybe"));
    System.out.println("Elements in tree3: ");
    tree3.inorder();
    System.out.println();
    
    CS401BST<Student> tree2 = new CS401BST<Student>();
    tree2.add (new Student ("Jones", 3.17));
    tree2.add (new Student ("Smith", 3.82));
    tree2.add (new Student ("Jones", 3.4));                 
    if (tree2.contains (new Student ("Jones", 10.0 - 6.6)))
     System.out.println ("The number of elements in tree2 is " + tree2.size());
     tree2.inorder();
     
     CS401BST<Student> tree4 = new CS401BST<Student>();
     System.out.println();
     tree4.recursiveAdd (new Student ("Jones", 3.17));
     tree4.recursiveAdd (new Student ("Smith", 3.82));
     tree4.recursiveAdd (new Student ("Jones", 3.4));                 
     if (tree4.contains (new Student ("Jones", 10.0 - 6.6)))
      System.out.println ("The number of elements in tree4 is " + tree4.size());
      tree4.inorder();
     
     
  } // method run
  
} // class BinarySearchTreeExample
