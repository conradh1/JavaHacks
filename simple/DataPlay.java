import java.util.*;
import java.io.*;

public class DataPlay
{

    boolean mybool;
    char mychar;
    byte mybyte;
    short myshort;
    int myint;
    long mylong;
    float myfloat;
    double mydouble;

    // Prints out unassigned datatypes
    void printInitialValues() {

      System.out.println("List of values WITHOUT Inialization below:");
      System.out.println(" (true or false) Boolean: "+mybool);
      System.out.println(" Character: "+mychar);
      System.out.println(" (-128 to 128) Byte: "+mybyte);
      System.out.println(" (-32,768 to 32,767) Short: "+myshort);
      System.out.println(" (-2^31 to 2^32-1) Int: "+myint);
      System.out.println(" (-2^64 to 2^64-1) Long: "+mylong);
      System.out.println(" (32-bit IEEE 754) Float: "+myfloat);
      System.out.println(" (64-bit IEEE 754) Double: "+mydouble);

    } //printInitialValues

    // Prints out unassigned datatypes
    void printAssignedValues(boolean print) {

      mybool = true;
      mychar = 'c';
      mybyte = 42;
      myshort = 9;
      myint = -999;
      mylong = 987654312;
      myfloat = 3.14f;
      mydouble = 3.14159;
      if (print) {
	System.out.println("List of values WITH Inialization below:");
	System.out.println(" Boolean: "+mybool);
	System.out.println(" Char: "+mychar);
	System.out.println(" Byte: "+mybyte);
	System.out.println(" Short: "+myshort);
	System.out.println(" Int: "+myint);
	System.out.println(" Long: "+mylong);
	System.out.println(" Float: "+myfloat);
	System.out.println(" Double: "+mydouble);
      }
    } //printInitialValues


    private void printSimpleMathOperations() {

      this.mybool = true;
      Random myrandomobj = new Random();
      int myrandom = myrandomobj.nextInt(10);
      System.out.println("List of simple operations below:");
      if (mybool) {
        System.out.println(" Is Boolean true: "+mybool);
      }
      else {
        System.out.println(" Is Boolean false: "+mybool);
      }
      long mymultiple = 0;
      mymultiple = myrandom * myshort;
      System.out.println("Random number(1-100): "+myrandom);
      System.out.println("Random multiplication: "+mymultiple);
      mymultiple = 11 / 2;
      System.out.println("11 DIV 2 division: "+mymultiple);
      mymultiple = 11 % 2;
      System.out.println("11 MOD 2 division: "+mymultiple);
      System.out.println("Char * 5?: "+(mychar*5));

    } //printSimpleMathOperations

    private void printLiterals() {
      this.myint = 101;
      System.out.println("The int: "+this.myint+" in binary: "+Integer.toString(this.myint,2));
      System.out.println("The int: "+this.myint+" in octal "+Integer.toString(this.myint,8));
      System.out.println("The int: "+this.myint+" in hex: "+Integer.toString(this.myint,2));
    } //printDataTypeConversions

    private void printBitWiseOperators() {
      int a = 60;
      int b = 13;
      int c;
      String binarya = Integer.toString(a,2);
      String binaryb = Integer.toString(b,2);
      c = a&b;
      String binaryc = Integer.toString(c,2);
      System.out.println("The binary AND (&) operators of "+a+" and "+b+" is:"+c );
      System.out.println(("00000000" + binarya).substring(binarya.length()));
      System.out.println(("00000000" + binaryb).substring(binaryb.length()));
      System.out.println("--------");
      System.out.println(("00000000" + binaryc).substring(binaryc.length()));
      c = a|b;
      binaryc = Integer.toString(c,2);
      System.out.println("The binary OR (|) operators of "+a+" and "+b+" is:"+c );
      System.out.println(("00000000" + binarya).substring(binarya.length()));
      System.out.println(("00000000" + binaryb).substring(binaryb.length()));
      System.out.println("--------");
      System.out.println(("00000000" + binaryc).substring(binaryc.length()));
      c = a^b;
      binaryc = Integer.toString(c,2);
      System.out.println("The binary XOR (^) operators of "+a+" and "+b+" is:"+c );
      System.out.println(("00000000" + binarya).substring(binarya.length()));
      System.out.println(("00000000" + binaryb).substring(binaryb.length()));
      System.out.println("--------");
      System.out.println(("00000000" + binaryc).substring(binaryc.length()));
      c = ~a;
      System.out.println("Bit flip "+a+" is:"+c );
      System.out.println(("00000000" + binaryc).substring(binaryc.length()));
      c = a<<2;  //left shift two bits
      System.out.println("Left shift two bits of "+a+" is:"+c );
      System.out.println(("00000000" + binarya).substring(binarya.length()));
      System.out.println("--------");
      System.out.println(("00000000" + binaryc).substring(binaryc.length()));
      c = a>>2;  //left shift two bits
      System.out.println("Right shift two bits of "+a+" is:"+c );
      System.out.println(("00000000" + binarya).substring(binarya.length()));
      System.out.println("--------");
      System.out.println(("00000000" + binaryc).substring(binaryc.length()));

    } //printDataTypeConversions


    private void printMathOperations() {
        double gfloat = -4.5;
        System.out.println(gfloat+" ab value is:"+Math.abs(gfloat) );
        System.out.println(myfloat+" ceiling value is:"+Math.ceil(myfloat) );
        System.out.println(myfloat+" rounded:"+(int)myfloat );
	System.out.println("2 to the power of 18 is: "+ Math.pow(2,18));
        System.out.println("Square root of 25: "+Math.sqrt(25));

    }

	public final static void main(String[] args)
	{
	    DataPlay mydataplay = new DataPlay();
	    //mydataplay.printInitialValues(;
	    mydataplay.printAssignedValues(false);
	    //mydataplay.printSimpleMathOperations();
	    //mydataplay.printLiterals();
	    //mydataplay.printBitWiseOperators();
	    mydataplay.printMathOperations();


        }

} // DataPlay
