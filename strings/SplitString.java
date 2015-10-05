//Comp308 Assignment 1 Question 2
//Author: Conrad Holmberg 
//id #9403987
//This program splits a string from position x to position y in a string
//The main program takes three arguments: string, int, int. Example SplitString HelloThere 5 9

import java.awt.*;
import java.util.*;

public class SplitString {
	public static void main(String[] args) {
		try {
			if (args.length != 3) //case there is not three argument 
				throw new Exception("Too few arguments in Split String- 3.");
			int string_length= args[0].length();
			if (!(args[1].charAt(0) >= '0' && args[1].charAt(0) <= '9')) 
				throw new Exception("Argument 2 is not an positive Integer.");
			if (!(args[2].charAt(0) >= '0' && args[2].charAt(0) <= '9')) 
				throw new Exception("Argument 3 is not an positive Integer.");
			//Get the starting point and finishing point of the parse
			int start= Integer.parseInt(args[1]);
			int finish = Integer.parseInt(args[2]);
			if (start > finish)
				throw new Exception("Finishing point of Split String in argument 2 must be greater than the Start point in argument 3.");
			else if (start > string_length)
				throw new Exception("Starting point of Split String in argument 2 is greater than word in argument 1.");
			else if (finish  > string_length)
				throw new Exception("Finishing point of Split String in argument 3 is greater than word in argument 1.");
			
			//parse out string
			for(int i= start; i <= finish; i++)  System.out.print(args[0].charAt(i) + " ");
			System.out.println();	
		} //try

		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	} //main
} //SplitString


