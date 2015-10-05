import java.util.*;

public class TwoSum  {


static int[] testArray = {2, 7, 11, 15};


public void findTwoSum( int[] array, int sum) {
      System.out.println("Array: "+Arrays.toString(array));
        for(int i=0; i < array.length; i++){
            for(int j=i+1; j < array.length; j++){
	      if ( array[i] + array[j] == sum ) {
		System.out.println("Sum of "+sum+" is indexs "+(i+1)+","+(j+1));
	      }
            }
        }
}

public int[] betterTwoSum(int[] numbers, int target) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int[] result = new int[2];

	for (int i = 0; i < numbers.length; i++) {
		if (map.containsKey(numbers[i])) {
			int index = map.get(numbers[i]);
			result[0] = index+1 ;
			result[1] = i+1;
			break;
		} else {
			map.put(target - numbers[i], i);
		}
	}

	return result;
    }


public static void main(String args[]) {

  TwoSum ts = new TwoSum();
  int sum = 18;
  ts.findTwoSum( testArray, sum );

}

}