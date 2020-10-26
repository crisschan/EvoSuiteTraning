/*
 * This file was automatically generated by EvoSuite
 * Fri Jul 05 02:51:03 GMT 2019
 */

package tutorial;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import tutorial.Stack;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Stack_ESTest extends Stack_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Stack<Object> stack0 = new Stack<Object>();
      assertTrue(stack0.isEmpty());
      
      Integer integer0 = new Integer(0);
      stack0.push("5~=OyYyO-8r");
      stack0.push(integer0);
      Object object0 = stack0.pop();
      assertEquals(0, object0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Stack<Object> stack0 = new Stack<Object>();
      stack0.push((Object) null);
      stack0.pop();
      assertTrue(stack0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Stack<Object> stack0 = new Stack<Object>();
      Integer integer0 = new Integer(809);
      stack0.push(integer0);
      assertFalse(stack0.isEmpty());
      
      stack0.pop();
      boolean boolean0 = stack0.isEmpty();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Stack<Object> stack0 = new Stack<Object>();
      assertTrue(stack0.isEmpty());
      
      Integer integer0 = new Integer(809);
      stack0.push(integer0);
      boolean boolean0 = stack0.isEmpty();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      Stack<Object> stack0 = new Stack<Object>();
      // Undeclared exception!
      try { 
        stack0.pop();
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Stack empty
         //
         verifyException("tutorial.Stack", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      Integer integer0 = new Integer(0);
      Stack<Integer> stack0 = new Stack<Integer>();
      stack0.push((Integer) null);
      stack0.push((Integer) null);
      stack0.push(integer0);
      stack0.push((Integer) null);
      stack0.push(integer0);
      stack0.push(integer0);
      stack0.push(integer0);
      stack0.push(integer0);
      stack0.push(integer0);
      stack0.push(integer0);
      // Undeclared exception!
      try { 
        stack0.push((Integer) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Stack exceeded capacity!
         //
         verifyException("tutorial.Stack", e);
      }
  }
}