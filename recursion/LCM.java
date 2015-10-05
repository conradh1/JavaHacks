import java.util.*;
import java.io.*;

class LCM {


// easy fibonacci sequence
public int getLCM(int x, int y) {

  // should only be a first case
  if ( y > x ) {
    //swap
    int t = x;
    x = y;
    y = t;
  }

  // assume x > y
  if ( x%y == 0 ) {
    return x;
  }
  else {
    return getLCM(x+x,y);
  }
}


 public final static void main(String[] args)  {
    LCM lcm = new LCM();
    System.out.println(lcm.getLCM(30,5));
 } //main

}
