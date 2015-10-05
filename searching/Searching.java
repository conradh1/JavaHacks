import java.util.*;
import java.io.*;

class Searching {

final static int ARRAYSIZE  = 10;
static int array[] = new int[ARRAYSIZE];


public void setRandomArray(boolean allowDuplicates) {
  int r = 0;
  boolean duplicate = false;
  Random randomGenerator = new Random();

  // reset array
  for ( int i = 0; i < this.array.length; i++ ) {
    array[i] = 0;
  }
  for ( int i = 0; i < this.array.length; i++ ) {
    duplicate = false;
    r = randomGenerator.nextInt(ARRAYSIZE) + 1;  // generate number beteween 1 and 100
    if ( !allowDuplicates ) {
      int j = 0;
      //check for duplicates in the previous positions
      while ( j < i ) {
	if ( this.array[j] == r) {
	  duplicate = true;
	  break;
	}
	j++;
      }
      if ( duplicate ) { --i; }  //rollback and try again.
      else this.array[i] = r;
    }
    else {
      this.array[i] = r;
    }
  }
}

 // recursion quick sort best case log(n) and worst case n^2
 private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
 }
 private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
}

 private int getSearchNumber() {
    Random randomGenerator = new Random();
    int r = randomGenerator.nextInt(array.length);
    return array[r];

 }

// prints 10 entries per row
public void printArray() {
  for ( int i = 0; i < this.array.length; i++ ) {
    System.out.print(this.array[i]);
     if ( (i+1) % 10 == 0 ) { System.out.println(); }
     else { System.out.print(","); }
  }
}


// searching through an array for a number best case O(1) worst O(n)
public int linearSearch(int key) {
  for ( int i = 0; i < this.array.length; i++ ) {
     if ( key == array[i] ) {
      return i;  //return the index of the match
     }
  }
  return -1; // not found
}

// Quick select search for both the smallest or largest element best case(0)n worst N^2
public int quickSelectSearch(int key) {
  for ( int i = 0; i < this.array.length; i++ ) {
     if ( key == array[i] ) {
      return i;  //return the index of the match
     }
  }
  return -1; // not found
}


public static int recursiveBinarySearch(int[] sortedArray, int start, int end, int key) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            if (key < sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, start, mid-1, key);

            } else if (key > sortedArray[mid]) {
                return recursiveBinarySearch(sortedArray, mid+1, end , key);

            } else {
                return mid;
            }
        }
        return -1;  //not found
    }

public int binarySearch(int key) {
    int start = 0;
    int end = array.length-1;
    int mid = 0;
    while ( start <= end ) {

      mid = (start+end)/2;

      if ( key == array[mid] ) {
        return mid;
      }
      else if ( key > array[mid] ) {
	start = mid+1;
      }
      else if ( key < array[mid] ) {
	end = mid-1;
      }
    }
    return -1;
}

public int binarySearchCount(int key, boolean searchFirst) {
    int low = 0;
    int high = array.length-1;
    int mid = 0;
    int result = -1;
    while ( low <= high ) {

      mid = (low+high)/2;

      if ( key == array[mid] ) {
        result = mid;
        if ( searchFirst ) {
         high = mid-1;
        }
        else {
         low = mid+1;
        }
      }
      else if ( key > array[mid] ) {
	low = mid+1;
      }
      else if ( key < array[mid] ) {
	high = mid-1;
      }
    }
    return result;
}

public final static void main(String[] args)  {
    Searching searcher = new Searching();
    boolean allowDuplicates = true;
    boolean isSorted = true;
    char searchType= 'c';  // default is linear search
    int position = -1; // index of position found.
    long startTime, endTime, duration;

    searcher.setRandomArray(allowDuplicates);
    int searchNum = searcher.getSearchNumber();

    if ( isSorted ) {
      searcher.quickSort(0, array.length - 1);
    }

    System.out.println("Array Below:");
    searcher.printArray();

    // perform a specific search type.

    switch (searchType) {

      case 'l':
	      System.out.println("Peforming linear search.");
	      startTime = System.nanoTime();
 	      position = searcher.linearSearch(searchNum);
              endTime = System.nanoTime();
              duration = (endTime - startTime);
              System.out.println("Found "+searchNum+" at index): "+position+". Execution Time (nanoseconads): "+duration);
	      break;

      case 'b': System.out.println("Peforming divide and conquer binary search.");
		startTime = System.nanoTime();
		position = searcher.binarySearch(searchNum);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Found "+searchNum+" at index: "+position+". Execution Time (nanoseconads): "+duration);
		break;

      case 'r': System.out.println("Peforming recusive binary search.");
		startTime = System.nanoTime();
		position = searcher.recursiveBinarySearch( array,0, array.length-1, searchNum);
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Found "+searchNum+" at index: "+position+". Execution Time (nanoseconads): "+duration);
		break;

      case 'c': System.out.println("Count occurances via Binary Search");
		startTime = System.nanoTime();
		int firstIndex = searcher.binarySearchCount(searchNum,true);
		if (firstIndex == -1 ) {
		  System.out.println("Count of "+searchNum+" is 0.");
		}
		else {
		  int lastIndex = searcher.binarySearchCount(searchNum,false);
		  int count = lastIndex - firstIndex + 1;
		  System.out.println("Count of "+searchNum+" is "+count+".");
		}
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		break;
      default:  System.out.println("Unkown search type: l - lineary, b - divide and conquer binary, r - recursion binary, etc.");
                break;

    }
 } //main

}
