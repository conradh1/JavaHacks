import java.util.*;
import java.io.*;
import java.math.*;

/*
http://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/


Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?


*/
class ReverseString {

 private static String reverse(String str ) {
  char[] words  = str.toCharArray();
  String rev = "";
  String tmp = "";
  for ( int i = 0; i < words.length; i++ ) {

    if ( (words[i] >= 'a' && words[i] <= 'z') || (words[i] >= 'A' && words[i] <= 'Z')) {
      tmp += words[i];
    }
    else if ( words[i] == ' ' || (i + 1) == words.length)  {
      char[] word  = tmp.toCharArray();
      for ( int j = word.length-1; j >= 0; j-- ) {
	rev += word[j];
      }
      rev += ' ';
      tmp = "";
    }
  }
  return rev;
 }

 public final static void main(String[] args)  {

      String sentence = "This is a sentence.";

      System.out.println(reverse(sentence));
} //main

}
