/*
 * This file was automatically generated by EvoSuite
 * Fri Jul 05 02:52:24 GMT 2019
 */

package tutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import tutorial.Node;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Node_ESTest extends Node_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Node<Object> node0 = new Node<Object>("Wv-a!}YFv~Y@Q`me");
      Object object0 = node0.getObject();
      assertEquals("Wv-a!}YFv~Y@Q`me", object0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Node<Object> node0 = new Node<Object>("Wv-a!}YFv~Y@Q`me");
      node0.setNext(node0);
      Node<Object> node1 = node0.getNext();
      assertSame(node1, node0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Node<String> node0 = new Node<String>((String) null);
      node0.setNext((Node<String>) null);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Node<String> node0 = new Node<String>((String) null);
      String string0 = node0.getObject();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Node<String> node0 = new Node<String>((String) null);
      Node<String> node1 = node0.getNext();
      assertNull(node1);
  }
}
