import static org.junit.Assert.*;

import org.junit.Test;


public class TwoThreeTreeGivenTests
{

   @Test
   public void singleNodeTree()
   {
      TwoThreeTree t = new TwoThreeTree();
      int val = 9;
      t.insert(val);
      String expected = "9";
      
      assertEquals(expected, t.search(val));
      val = 8;
      assertEquals(expected, t.search(val));
      val = 10;
      assertEquals(expected, t.search(val));
      
      val = 15;
      t.insert(val);
      expected = "9 15";
      val = 9;
      assertEquals(expected, t.search(val));
      val = 8;
      assertEquals(expected, t.search(val));
      val = 10;
      assertEquals(expected, t.search(val));
      val = 15;
      assertEquals(expected, t.search(val));
      val = 18;
      assertEquals(expected, t.search(val));

      t = new TwoThreeTree();
      val = 15;
      t.insert(val);
      val = 9;
      t.insert(val);
      val = 9;
      assertEquals(expected, t.search(val));
      val = 8;
      assertEquals(expected, t.search(val));
      val = 10;
      assertEquals(expected, t.search(val));
      val = 15;
      assertEquals(expected, t.search(val));
      val = 18;
      assertEquals(expected, t.search(val));

   }
   
   @Test
   public void oneSplitLeft()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(9);
      t.insert(15);
      t.insert(1);
      
      String expected = "9";
      assertEquals(expected, t.search(9));
      expected = "15";
      assertEquals(expected, t.search(15));
      assertEquals(expected, t.search(17));
      assertEquals(expected, t.search(11));

      expected = "1";
      assertEquals(expected, t.search(1));
      assertEquals(expected, t.search(0));
      assertEquals(expected, t.search(3));
   }
   
   @Test
   public void oneSplitRight()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(1);
      t.insert(9);
      t.insert(15);
      
      String expected = "9";
      assertEquals(expected, t.search(9));
      expected = "15";
      assertEquals(expected, t.search(15));
      assertEquals(expected, t.search(17));
      assertEquals(expected, t.search(11));

      expected = "1";
      assertEquals(expected, t.search(1));
      assertEquals(expected, t.search(0));
      assertEquals(expected, t.search(3));
   }

   @Test
   public void oneSplitMiddle()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(1);
      t.insert(15);
      t.insert(9);
      
      String expected = "9";
      assertEquals(expected, t.search(9));
      expected = "15";
      assertEquals(expected, t.search(15));
      assertEquals(expected, t.search(17));
      assertEquals(expected, t.search(11));

      expected = "1";
      assertEquals(expected, t.search(1));
      assertEquals(expected, t.search(0));
      assertEquals(expected, t.search(3));
   }
@Test
public void testconditions()
{
    TwoThreeTree t= new TwoThreeTree();
    t.insert(9);
     t.insert(1);
      t.insert(4);
      t.insert(10);
      t.insert(11);
      assertEquals("4 10", t.search(10));
      t.insert(14);
      t.insert(15);
     assertEquals("10", t.search(10));
}
   
   @Test
   public void testDuplicates()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(1);
  
      t.insert(9);
     
      t.insert(15);
      
      t.insert(13);
    
      t.insert(20);
      
      t.insert(7);
      t.insert(4);
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);

      String expected = "9";
      assertEquals(expected, t.search(9));
      expected = "4";
      assertEquals(expected, t.search(4));
      expected = "15";
      assertEquals(expected, t.search(15));

      expected = "13";
      assertEquals(expected, t.search(12));
      assertEquals(expected, t.search(13));
      assertEquals(expected, t.search(14));
      expected = "20";
      assertEquals(expected, t.search(19));
      assertEquals(expected, t.search(20));
      assertEquals(expected, t.search(21));

      expected = "1";
      assertEquals(expected, t.search(1));
      assertEquals(expected, t.search(0));
      assertEquals(expected, t.search(3));

      expected = "7";
      assertEquals(expected, t.search(6));
      assertEquals(expected, t.search(7));
      assertEquals(expected, t.search(8));
t.insert(30);
t.insert(31);
t.insert(32);
t.insert(33);
t.insert(33);
t.insert(16);
t.insert(146);
t.insert(26);
t.insert(12);
t.insert(8);
t.insert(6);
t.insert(1);
t.insert(10);
t.insert(6);
   }


}