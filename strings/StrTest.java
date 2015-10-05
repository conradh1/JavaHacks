
import java.lang.*;

public class StrTest
{
  public static void main (String args[])
  {
    System.out.println ("String Concatenation Performance Test");

    StrTest test = new StrTest();

    long before,after;
    
    
    before = System.currentTimeMillis();
    test.string();
    after = System.currentTimeMillis();
    System.out.println ("String concats = " + (after-before) + " ms");

    before = System.currentTimeMillis();
    test.stringBuffer();
    after = System.currentTimeMillis();
    System.out.println ("StringBuffer concats = " + (after-before) + " ms");

    before = System.currentTimeMillis();
    test.stringStatic();
    after = System.currentTimeMillis();
    System.out.println ("String static concats = " + (after-before) + " ms");

    before = System.currentTimeMillis();
    test.stringBufferStatic();
    after = System.currentTimeMillis();
    System.out.println ("StringBuffer static concats = " + (after-before) + " ms");

    before = System.currentTimeMillis();
    test.stringStaticInt();
    after = System.currentTimeMillis();
    System.out.println ("String static int concats = " + (after-before) + " ms");




    String x = "String 1";
    String y = "String 2";

    System.out.println ("x = " + x + " y = " + y);

    swap (x, y);

    System.out.println ("x = " + x + " y = " + y);

    

/*    before = System.currentTimeMillis();
    test.stringInt();
    after = System.currentTimeMillis();
    System.out.println ("String int concats = " + (after-before) + "
    ms");*/


    
  }

  public static void swap (String x, String y)
  {
//    String temp;

//    temp = x;
    x.concat (y);
    y.concat (x);
  }

  private void string ()
  {
    String temp = "";
    
    for (int index = 0; index < 1024; index++)
    {
      temp += index + "\n";
    }

  }

  private void stringBuffer()
  {
    StringBuffer temp = new StringBuffer (16384);
    
    for (int index = 0; index < 1024; index++)
    {
      temp.append (index);
      temp.append ("\n");
    }
  }

  private void stringStatic ()
  {
    String temp;
    
    for (int index = 0; index < 1024; index++)
    {
      temp = "This is a string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n";
    }

  }

  private void stringBufferStatic()
  {
    StringBuffer temp = new StringBuffer (1024);
    
    for (int index = 0; index < 1024; index++)
    {
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");
      temp.append ("This is a string\n");

      temp.delete (0,temp.length());
    }
  }

  private void stringStaticInt ()
  {
    String temp = "";
    
    for (int index = 0; index < 200; index++)
    {
      temp = 1 + "This is a string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n" +
        2 + "This is another string\n";
    }

  }

  private void bigString ()
  {
    String temp = "";
    
    for (int index = 0; index < 200; index++)
    {
      temp += "This is a string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n" +
        "This is another string\n";
    }
  }

}
