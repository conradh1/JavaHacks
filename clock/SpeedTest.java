import java.lang.*;
import java.io.*;
/* This program tests the speed 
 of various operations in Java.
*/
public class SpeedTest {
  public SpeedTest next;
  public static void main (String args[]) {
	
	long before,after,strtest,looptest,stdouttest,mathtest,objtest;
	SpeedTest myspeedtest= new SpeedTest();
	//String Test
	System.out.println("Performing String Test...");
	before= System.currentTimeMillis(); //time before test
	myspeedtest.strAppendingTest(1000);
	after= System.currentTimeMillis(); //time after test
	strtest= after-before;
	
	//loop test
	System.out.println("Performing Loop Test...");
	before= System.currentTimeMillis(); //time before test
	myspeedtest.loopTest(10000);
	after= System.currentTimeMillis(); //time after test
	looptest= after-before;
	
	//stdout test
	System.out.println("Performing Standard Output Test...");
	before= System.currentTimeMillis(); //time before test
	myspeedtest.stdoutTest(1000);
	after= System.currentTimeMillis(); //time after test
	stdouttest= after-before;
	
	//math test
	System.out.println("Performing Math Test...");
	before= System.currentTimeMillis(); //time before test
	myspeedtest.mathTest(10000);
	after= System.currentTimeMillis(); //time after test
	mathtest= after-before;
	
	//object generation test
	System.out.println("Performing Object Test...");
	before= System.currentTimeMillis(); //time before test
	myspeedtest.objTest(10000);
	after= System.currentTimeMillis(); //time after test
	objtest= after-before;
	
	//Print Results
	System.out.println ("##########################################################");
	System.out.println ("############ Time Results For Each Test in Java ##########");
	System.out.println ("##########################################################");
	System.out.println ("String appending test= "+strtest+" milliseconds.");
	System.out.println ("Loop test= "+looptest+" milliseconds.");
	System.out.println ("Standard Output test= "+stdouttest+" milliseconds.");
	System.out.println ("Math test= "+mathtest+" milliseconds.");
	System.out.println ("Object generation test= "+objtest+" milliseconds.");
  } //main
  
  private void strAppendingTest(int limit) {
	//method appends a string multiple times
	String tmp= "";
 	
	for (int i= 0; i < limit; i++) {
		tmp+= "Appending a String"+i+"\n";
    	}
  } //strAppending
  
  private void loopTest(int limit) {
	//performs a loop test
	for (int i = 0; i < limit; i++);
  }//loopTest
  
  private void stdoutTest(int limit) {
  	//prints several message to stdout
	for (int i = 0; i < limit; i++) {
		System.out.println("Printing to stdout.");
	}
  }
  private void mathTest(int limit) {
  	//appends several a set of random numbers (1-10)
	long sum= 0;
	for (int i = 0; i < limit; i++) {
		sum+= (long)(Math.random()*10); 
	}
  }
  private void objTest(int limit) {
  	for (int i = 0; i < limit; i++) {
		SpeedTest test = new SpeedTest();
		for (int j = 0; j < limit; j++) {
			test.next=new SpeedTest();
			test=test.next;
            	}
  	}
  } //ObjTest
} //SpeedTest