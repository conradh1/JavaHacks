import java.util.*;

public class MergeSortedArray  {


public int[] mergeSortedArrays( int[] array1, int[]array2) {
      int[] merge = new int[array1.length+array2.length];
      
      int i = 0;
      int j = 0;
      int n = 0;
      
      while ( i < array1.length && j < array2.length ) {
        if ( array1[i] < array2[j] ) {
          merge[n] = array1[i];
          n++;
          i++;
        }
        else {
          merge[n] = array2[j];
          n++;
          j++;        
        }      
      }
      while ( i < array1.length ) {
          merge[n] = array1[i];
          n++;
          i++;
      }
      while ( j < array2.length ) {
          merge[n] = array2[j];
          n++;
          j++;
      }
      return merge;
}




public static void main(String args[]) {

  MergeSortedArray m = new MergeSortedArray();
  int[] array1 = {1,4,6,8};
  int[] array2= {2,3,9};
  int[] newArray = m.mergeSortedArrays(array1, array2);
  for ( int i =0; i < newArray.length; i++ ) {
    System.out.print(newArray[i]+" ");
  }
  System.out.println();
}

}