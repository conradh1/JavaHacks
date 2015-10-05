//Comp308 Assignment 1 Question 3
//Conrad Holmberg
// id# 9403987
//This program sorts an array of 100 numbers asks the user for a number and finds the
//closest two index integers 

import java.io.*;
import java.text.DecimalFormat;

public class SortNumbers {

public static void sort(float[] nums) {
	for (int i = 0; i < nums.length; i++) {
		int min= i;

		for (int j= i; j < nums.length; j++) {
			if (nums[j] < nums[min])
				min = j;
		} //for		
		float tmp;
		tmp= nums[i];
		nums[i] = nums[min];
		nums[min]= tmp;
	} //for
} //sort

public static void sortInput(float finput, float[] nums) {
	DecimalFormat precision3 = new DecimalFormat("0.000");  //3 significant digits output 

	for (int i = 0; i < nums.length; i++) {
		if (nums[i] > finput) {
			System.out.println("Lower number: " +precision3.format((float)nums[i - 1]) +" at index " +(i - 1));
			System.out.println("Input number: " +precision3.format((float)finput));
			System.out.println("Higher number: " +precision3.format((float)nums[i]) +" at index " +i);
			break;
		} //if
	} //for		
} //sortInput

public static void main(String[] args)	throws IOException {
	float[] nums = new float[100];
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	DecimalFormat precision3 = new DecimalFormat("0.000");
		
	for (int i = 0; i < nums.length; i++) {
		double ran_num= Math.random() * 100;
		nums[i]= (float)ran_num;
	}
	sort(nums);		
	for(int i = 0; i < nums.length; i++)  System.out.println(precision3.format((float)nums[i]));
	String numberout;
	
	for(;;)	{
		System.out.println("Enter a number and I will tell which which closest");
		System.out.println("index number is higher and lower.  Type 'quit' to exit.");
		String line = in.readLine();
		//reach eof or user types quit then loop breaks
		if ((line == null) || line.equals("quit")) break;

		//Try to parse the user's input into a float
		try {
			float finput= Float.valueOf(line).floatValue();
			if (nums[nums.length - 1] < finput) 
				throw new Exception("Input number greater than largest index value");
			if (nums[0] > finput) 
				throw new Exception("Input number lower than smallest index value");
			sortInput(finput, nums);
		}  //try

		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());			
			System.out.println("Invalid input.  Try again");
		} //catch
		
	} //for
} //main
} //Sortnumbers