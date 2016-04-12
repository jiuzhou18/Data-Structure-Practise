package lab09;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;
import java.io.*;

public class BinarySearchTreeTest 
{
    public static void main(String[ ] args)
    {  
        Result result = runClasses (BinarySearchTreeTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main

    protected BinarySearchTree<String> tree;          
                       
    @Before    
    public void RunBeforeEachTest()
    {
        tree = new BinarySearchTree<String>();      
    } // method RunBeforeEachTest
 
    @Test
    public void testDefaultConstructor() 
    {                                                      
        assertEquals (0, tree.size()); 
        assertEquals ("[]", tree.toString());       
    } // method testDefaultConstructor
    
    @Test
    public void testCopyConstructor() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");
        BinarySearchTree newTree = new BinarySearchTree<String> (tree);            
        assertEquals (tree, newTree);        
    } // method testCopyConstructor
        
    @Test
    public void testAdd()
    {                      
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            tree.add ("e");
            tree.add ("c");
            tree.add ("d");           
            assertEquals ("[a, b, c, d, e]", tree.toString());        
    } // method testAdd    
    
    @Test
    public void testContains()
    {                         
            tree.add ("a");
            tree.add ("b"); 
            tree.add ("c"); 
            assertEquals (true, tree.contains ("a")); 
            assertEquals (true, tree.contains ("b")); 
            assertEquals (true, tree.contains ("c")); 
            assertEquals (false, tree.contains ("x"));
            assertEquals (false, tree.contains (""));                
    } // method testContains
    
    @Test (expected = NullPointerException.class)
    public void testContainsNull()
    {                         
            tree.add ("a");
            tree.add ("b"); 
            tree.add ("c"); 
            tree.contains (null);        
    } // method testContainsNull
    
    @Test
    public void testRemove()
    {                            
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            assertEquals (true, tree.remove ("b"));
            assertEquals (2, tree.size());
            assertEquals (false, tree.remove ("b"));
            assertEquals (2, tree.size());                             
    } // method testRemove
    
    @Test
    public void testIteratorConstructor()
    {       
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());           
    } // method testIteratorConstructor
    
    @Test
    public void testIteratorHasNext()
    {        
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());
            assertEquals ("b", itr.next());
            assertEquals (true, itr.hasNext());
            assertEquals ("c", itr.next());
            assertEquals (false, itr.hasNext());            
    } // method testIteratorHasNext
    
    @Test (expected = NoSuchElementException.class)
    public void testIteratorNextFail()
    {       
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());
            assertEquals ("b", itr.next());
            assertEquals (true, itr.hasNext());
            assertEquals ("c", itr.next());
            assertEquals (false, itr.hasNext());
            itr.next();                  
    } // method testIteratorNextFail     
    
    @Test
    public void testHeight(){
    	tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");
        assertEquals (1, tree.height());
    }
    
    @Test
    public void testHeightComplex(){
    	tree.add ("d"); 
        tree.add ("c");
        tree.add ("e");
        tree.add ("b");
        tree.add ("a");
        
        assertEquals (3, tree.height());
    }
    
} // class BinarySearchTreeTest