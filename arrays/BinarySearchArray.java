import java.util.*;

// Search a sorted array 

public class BinarySearchArray  {


// Returns index of the found element else -1
static public int binarySearch( int[] array, int key) {      
      if ( array == null )
        return -1;
                
      int first_index = 0;
      int last_index = array.length-1;
      int current_index = (first_index + last_index) / 2;
      
      while ( first_index <= last_index ) {        
        if ( key > array[current_index]   ) {
          first_index = current_index+1;          
        }        
        else if ( key < array[current_index]   ) {
         last_index = current_index-1;         
        }
        else// ( array[current_index] == key ) 
          return current_index;      
        current_index = (first_index + last_index) / 2;
      }
      if ( first_index > last_index )
       return -1;      
      return current_index;
}




public static void main(String args[]) {
  
  int[] array1 = {2,4,6,8,11,12,14,16,17};  
  int key = Integer.parseInt(args[0]);
  System.out.println("Found "+key+" in "+binarySearch(array1, key));
  

}

}