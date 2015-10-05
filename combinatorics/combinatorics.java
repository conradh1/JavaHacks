import java.io.*;
import java.util.*;

class Combinatorics {
    int value;
    List next;
    final static int ARRAYSIZE  = 3;
    //static int array[] = new int[ARRAYSIZE];

   private void printArrayWithSwap( int array[], int x, int y ) {
      for (int i = 0; i < array.length; i++ ) {
         if ( i == x ) {
	   System.out.print(array[y]+"");
         }
         else if ( i == y ) {
	   System.out.print(array[x]+"");
         }
         else {
           System.out.print(array[i]+"");
         }
         if ( i < array.length - 1 ) {
	    System.out.print(", ");
         }
      }

   }

   private void swap (int array[], int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
   }

   // The main function that prints all combinations of size r
  // in arr[] of size n. This function mainly uses combinationUtil()
  public void printCombination(int arr[], int n, int r) {
    // A temporary array to store all combination one by one
    int data[] = new int[r];

    // Print all combination using temprary array 'data[]'
    combinationUtil(arr, data, 0, n-1, 0, r);
  }

  /* arr[]  ---> Input Array
   data[] ---> Temporary array to store current combination
   start & end ---> Staring and Ending indexes in arr[]
   index  ---> Current index in data[]
   r ---> Size of a combination to be printed */
   public void combinationUtil(int arr[], int data[], int start, int end, int index, int r)
   {
    // Current combination is ready to be printed, print it
      if (index == r)
      {
        for (int j=0; j<r; j++)
            System.out.print(""+data[j]);
        System.out.println();
        return;
      }

      // replace index with all possible elements. The condition
      // "end-i+1 >= r-index" makes sure that including one element
      // at index will make a combination with remaining elements
      // at remaining positions
      for (int i=start; i<=end && end-i+1 >= r-index; i++)
      {
        data[index] = arr[i];
        combinationUtil(arr, data, i+1, end, index+1, r);
      }
  }

  /* Function to print permutations of string
   This function takes three parameters:
   1. String
   2. Starting index of the string
   3. Ending index of the string. */
   public void permute(int array[], int i, int n) {
   int j;
   if (i == n-1)
     printArray( array );
   else
   {
        for (j = i; j < n; j++)
       {
          swap(array,i, j);
          permute(array, i+1, n);
          swap(array,i, j); //backtrack
       }
   }
}
   //n! / (n - r)!  C(n,r) = n! / ( r! (n - r)! )
   public void doShitPurmutation(int array[]) {
     // basically show N! bruteforce
     int combo = 0;
     for (int i = 0; i < array.length; i++ ) {
       for (int j = 0; j < array.length; j++ ) {
          if ( i != j ) {
             System.out.print("Combo "+(++combo)+": [");
             printArrayWithSwap(array, i,j);
             System.out.println("]");
          }
       }
     }
   }

   public void printArray(int array[]) {
      System.out.print("[");
      for (int i = 0; i < array.length; i++ ) {
	System.out.print(array[i]+"");
	if ( i < array.length - 1 ) {
	    System.out.print(", ");
	}
      }
      System.out.println("]");
   }

    public static void main(String[] args) {
      int array[] = {1,2,3,4};
      Combinatorics com = new Combinatorics();
      //com.printArray(array);
      //com.doShitPurmutation(array);
      int r = 3;
      int n = array.length;
      com.permute(array, 0, n);
      com.printCombination( array, n, r );
    }
}


