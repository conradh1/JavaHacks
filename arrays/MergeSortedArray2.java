/*

*/

import java.util.*;
import java.io.*;

public class MergeSortedArray2 {

  public static void main(String[] args) {

  int[] a1 = {1,2,4};
  int[] a2 = {3,5,6};
  int[] merge = mergeArray(a1,a2);

  for ( int i = 0; i < merge.length; i++ ) {
    System.out.print( merge [i]+", ");
  }
  System.out.println("");
  }


  public static int[] mergeArray(int[] a1, int[] a2) {

    int[] merge = new int[a1.length+a2.length];
    int i = 0, j = 0, n = 0;

    if ( a1.length == 0 ) return a2;
    if ( a2.length == 0 ) return a1;


     while ( i < a1.length && j < a2.length ) {
       if ( a1[i] < a2[j] ) {
	merge[n] = a1[i];
	n++;
	i++;
       }
       else {
	merge[n] = a2[j];
	n++;
	j++;
       }
     }

     if ( i < a1.length ) {
	while ( i < a1.length ) {
	  merge[n] = a1[i];
	  n++;
	  i++;
	}
     }

     if ( j < a2.length ) {
	while ( j < a2.length ) {
	  merge[n] = a2[j];
	  n++;
	  j++;
	}
     }

    return merge;
  }

}