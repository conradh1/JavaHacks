import java.util.*;
import java.io.*;

class Recursion {


// easy fibonacci sequence
public int fib(int n) {
  if ( n <= 1 ) {
    return n;
  }
  else {
    return fib(n - 1) + fib(n - 2);
  }
}

// c - count down.
public int fibLevel(int n, int l, List<int[]> levels) {
  //System.out.println("level: "+c+" num: "+n);
  levels.add(new int[] {l,n} );
  if ( n <= 1 ) {
    return n;
  }
  else {
    l++;
    return fibLevel(n - 1, l,levels) + fibLevel(n - 2, l,levels);
  }

}

public void printLevels(List<int[]> levels ) {
    int array[][] = new int[levels.size()][2];

    int i = 0;
    for (int[] level : levels) {
      //System.out.println(Arrays.toString(level));
      array[i][0] = level[0];
      array[i][1] = level[1];
      i++;
    }
    // sort the array
    int temp, temp2;
    for ( i = 1; i < array.length; i++) {
      for(int j = i ; j > 0 ; j--) {
	if(array[j][0] < array[j-1][0]){
	            temp = array[j][0];
                    temp2 = array[j][1];
                    array[j][0] = array[j-1][0];
                    array[j][1] = array[j-1][1];
                    array[j-1][0] = temp;
                    array[j-1][1] = temp2;
                }
      }
    }

  int max = 0;
  for ( i = 0; i < array.length-1; i++) {
    System.out.print(array[i][1]);  // print element

    if ( array[i+1][0] > max ) {
      max = array[i+1][0];
      System.out.println("");
    }
    else {
       System.out.print(","); //we know there is a next number coming.
    }
    //System.out.println(array[i][0]+"=>"+array[i][1]); //print value in the level
  }
  System.out.println(array[array.length-1][1]);
 }

 public final static void main(String[] args)  {
    List<int[]> levels = new ArrayList<int[]>();
    Recursion recur = new Recursion();
    //System.out.println(recur.fib(5));
    recur.fibLevel(5,0, levels);
    recur.printLevels(levels);
 } //main

}
