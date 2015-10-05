//Comp308 Assignment 1 Question 2
//Author: Conrad Holmberg
//id #9403987
//This program splits a string from position x to position y in a string
//The main program takes three arguments: string, int, int. Example SplitString HelloThere 5 9

import java.awt.*;
import java.util.*;

public class ReplaceString {
  public final static void main(String S[]) {
        String field= "Hello \"There\" People";
        String new_field= "";

        for(int i= 0; i < field.length(); i++) {
          if (field.charAt(i) == '"' ) {
            new_field+= "\\"+field.charAt(i);
          }
          else {
            new_field+= field.charAt(i);
          }
        }

        System.out.println("Original Field with quotes: "+field);
        System.out.println("Field with escape characters added: "+new_field);
	} //main
} //ReplaceString



