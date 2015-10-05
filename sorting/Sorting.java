import java.util.*;
import java.io.*;

class Sorting {

final static int ARRAYSIZE  = 10;
static int rand[] = new int[ARRAYSIZE];
// creates a random array.
static int[] tempMergArr;

public void setRandomArray(boolean allowDuplicates) {
  int r = 0;
  boolean duplicate = false;
  Random randomGenerator = new Random();

  // reset array
  for ( int i = 0; i < this.rand.length; i++ ) {
    rand[i] = 0;
  }
  for ( int i = 0; i < this.rand.length; i++ ) {
    duplicate = false;
    r = randomGenerator.nextInt(ARRAYSIZE) + 1;  // generate number beteween 1 and 100
    if ( !allowDuplicates ) {
      int j = 0;
      //check for duplicates
      while ( this.rand[j] != 0 ) {
	if ( this.rand[j] == r) { duplicate = true; }
	j++;
      }
      if ( duplicate ) { --i; }  //rollback and try again.
      else this.rand[i] = r;
    }
    else {
      this.rand[i] = r;
    }
  }
}

// like insertion sort but just swaps the one in front of it
public void customInsertionSort1() {
  boolean sorted = false;

  while (!sorted) {
    sorted = true;
    for ( int i = 0; i < rand.length - 1; i++ ) {
      if ( rand[i] > rand[i+1] ) {
        swap(i,i+1);
        sorted = false;
      }
    }
  }
}

// performs bubble sort based on swapping best 0(n) worst is  On^2
public void bubbleSort() {
    for (int m = rand.length; m >= 0; m--) {
      for (int i = 0; i < rand.length - 1; i++) {
	if (rand[i] > rand[i + 1]) {
	  swap(i, i+1);
	}
      }
      System.out.println(Arrays.toString(rand));
    }
}

// performs simple insertion sort best 0(n) worst is  On^2
public void selectionSort() {
  for ( int i = 1; i < rand.length; i++ ) {
    for ( int j = i; j > 0; j--) {
      if ( rand[j] < rand[j-1] ) {
        swap(j, j-1);
      }
    }
  }
}

// performs simple insertion sort always n^2
public void insertionSort() {
  int index;

  for ( int i = 0; i < rand.length - 1; i++ ) {
    index = i;
    for ( int j = i+1; j < rand.length; j++ ) {
      if ( rand[index] > rand[j] ) {
        index = j;
      }
    }
    swap(index,i);
    System.out.println(Arrays.toString(rand));
  }
}

 // recursion quick sort best case log(n) and worst case n^2
 private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = rand[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two rands
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (rand[i] < pivot) {
                i++;
            }
            while (rand[j] > pivot) {
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

 public void mergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            mergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            mergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
 }

  private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = rand[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                rand[k] = tempMergArr[i];
                i++;
            } else {
                rand[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            rand[k] = tempMergArr[i];
            k++;
            i++;
        }

  }

private void swap (int a, int b) {
        int temp = rand[a];
        rand[a] = rand[b];
        rand[b] = temp;
}

// prints 10 entries per row
public void printArray() {
  for ( int i = 0; i < this.rand.length; i++ ) {
    System.out.print(this.rand[i]);
     if ( (i+1) % 10 == 0 ) { System.out.println(); }
     else { System.out.print(","); }
  }
}

public final static void main(String[] args)  {
    Sorting sorter = new Sorting();
    boolean allowDuplicates = false;
    char sortType= 'm';  // default is selection sort.

    sorter.setRandomArray(false);
    System.out.println("Random Array");
    sorter.printArray();

    // perform a specific search type.
    switch (sortType) {

      case 's':
	      System.out.println("Peforming selection sort.");
	      sorter.selectionSort();
	      sorter.printArray();
	      break;

      case 'i':
	      System.out.println("Peforming insertion sort.");
	      sorter.insertionSort();
	      sorter.printArray();
	      break;
      case 'q':
              System.out.println("Performing quick sort.");
              sorter.quickSort(0,rand.length - 1);
              sorter.printArray();
              break;
      case 'b':
              System.out.println("Peforming bubble sort.");
              sorter.bubbleSort();
	      sorter.printArray();
	      break;
      case 'm':
              System.out.println("Peforming merge sort.");
              tempMergArr = new int[rand.length];
              sorter.mergeSort(0, rand.length - 1);
              sorter.printArray();
              break;
      case 'a':
              System.out.println("Peforming **custom** insertion sort");
              sorter.customInsertionSort1();
              sorter.printArray();
              break;
      default:  System.out.println("Unkown search type: s - selection, i - insertion, q-quick, b-bubble, m-merge, etc.");
                break;

    }
 } //main

}
