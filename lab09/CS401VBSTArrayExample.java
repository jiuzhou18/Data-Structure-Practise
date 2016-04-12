package lab09;

public class CS401VBSTArrayExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CS401VBSTArrayExample().run();
	}
	
	public void run()
	  {
		CS401BSTArray<String> tree1 = new CS401BSTArray<String>();
	    
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
	      
	    CS401BSTArray<Student> tree2 = new CS401BSTArray<Student>();
	    tree2.add (new Student ("Jones", 3.17));
	    tree2.add (new Student ("Smith", 3.82));
	    tree2.add (new Student ("Jones", 3.4));                 
	    if (tree2.contains (new Student ("Jones", 10.0 - 6.6)))
	     System.out.println ("The number of elements in tree2 is " + tree2.size());
	     tree2.inorder();
	    	     
	     
	  } // method run

}
