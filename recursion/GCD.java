import java.util.*;
import java.io.*;

class GCD {


// easy gcd sequence
public int getGCD(int x, int y) {

  // should only be a first case
  if ( x < y ) {
    //swap
    int t = x;
    x = y;
    y = t;
  }


  if ( y == 0 ) {
    return x;
  }
  // assume x > y
  else {
    return getGCD(y,x%y);
  }
}


 public final static void main(String[] args)  {
    GCD GCD = new GCD();
    //System.out.println(recur.fib(5));
    System.out.println(GCD.getGCD(10,45));
 } //main

}
