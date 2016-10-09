import java.util.*;

public class MergeArray  {


public int[] merge( int[] array1, int[]array2) {
      int[] merge = new int[array1.length+array2.length];
      int i =0;
      int j = 0;
      int k =0;

      while ( i < array1.length && j < array2.length ) {
	if (array1[i] < array2[j] ) {
	  merge[k] = array1[i];
	  i++;
	}
	else {
	  merge[k] = array2[j];
	  j++;
	}
	k++;
      }

      while (i < array1.length) {
        merge[k] = array1[i];
        i++;
        k++;
    }

    while (j < array2.length)
    {
        merge[k] = array2[j];
        j++;
        k++;
    }

      return merge;
}




public static void main(String args[]) {

  MergeArray m = new MergeArray();
  int[] array1 = {1,4,6,8};
  int[] array2= {2,3,9};
  int[] newArray = m.merge(array1, array2);
  System.out.println(Arrays.toString(newArray));

}

}