/*
 * Uses split to break up a string of input separated by
 * commas and/or whitespace.
 */
import java.util.regex.*;

public class StringFun {

  public void regExpDemo(String str) {
    System.out.println("Look for domain pattern in string");
    Pattern p = Pattern.compile("^http://w{3}\\.\\w+.\\w{3}");
    Matcher m = p.matcher(str);
    if ( m.find() ) {
	System.out.println("Match of base Domain: "+m.group());
    }

  }
  public void strCompare(String str, String str2 ) {
      // example
      //String str = "Hello World";
      //String str2= "hello world";
      Object objStr = str;

      System.out.println( "Compare two strings");
      System.out.println( str.compareTo(str2) );
      System.out.println( str.compareToIgnoreCase(str2) );
      System.out.println( str.compareTo(objStr.toString()));
   }

  public void splitExample(String str) {
    // Create a pattern to match breaks
    Pattern p = Pattern.compile("[,\\s]+");
    // Split input with the pattern
    String[] result = p.split(str);
    // print each string
    for (int i=0; i<result.length; i++)
            System.out.println(result[i]);
  }


  public void substrDemo(String str){
      str = "Welcome to the Terrordome!";

      System.out.print("Return Value :" );
      System.out.println(str.substring(0,10) );

      System.out.print("Return Value :" );
      System.out.println(str.substring(10, str.length()) );
  }



  public void stringFormat() {
      double e = Math.E;
      System.out.format("%-10.4f%n", e);
  }

  public void strReverse(){
      String string="abcdef";
      String reverse = new StringBuffer(string).
      reverse().toString();
      System.out.println("\nString before reverse: "+string);
      System.out.println("String after reverse: "+reverse);
  }


  // *********** MAIN ************
  public static void main(String[] args) throws Exception {
    StringFun sf = new StringFun();
    sf.regExpDemo("http://www.hello.com/test.php?var=value");
    sf.splitExample("one,two, three   four ,  five");
    sf.strCompare("Hello World","hello world");
    sf.substrDemo("");
  }
}

