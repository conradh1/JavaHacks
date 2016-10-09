import java.util.*;
import java.io.*;
import java.math.*;

/*
http://www.programcreek.com/2015/03/rotate-array-in-java/
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
How many different ways do you know to solve this problem?


*/
class RotateArray {

 private static int[] rotate(int[] arr, int k ) {
  int[] rot = new int[arr.length];

  for ( int i = 0; i < rot.length; i++ ) {
    int pos;
    if ( (i + k) < rot.length )
      pos = i + k;
    else
      pos = Math.abs(i + k - rot.length);

    rot[pos] = arr[i];

  }
  return rot;

 }
 public final static void main(String[] args)  {

      int[] a1 = { 1,2,3,4,5,6,7 };
      int k = 3;
      int[] s1 = rotate( a1, k);

      for ( int i = 0; i < s1.length; i++ ) {
	System.out.print( s1[i]+" ");
      }
      System.out.println();
} //main

}
