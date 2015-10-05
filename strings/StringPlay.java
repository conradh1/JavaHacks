import java.util.*;
import java.io.*;

class StringPlay {

public void printBasic() {
  String str = "Hello People!";
  int l = str.length();
  System.out.println("str length: "+l);
}

public boolean isFunny(String sentence) {
  char[] S = sentence.toCharArray();  
  char[] R = new char[S.length];
  boolean isFunny = false;
  int j = 0;
  for (int i = S.length-1; i >= 0; i-- ) {
    R[j] = S[i];
    j++;
  }
  for (int i = 1; i < S.length; i++ ) {
   if ( Math.abs(S[i]-S[i-1]) == Math.abs(R[i]-R[i-1]) ) {
     isFunny = true;
   }
   else {
     isFunny = false;
     break;
    }    
  } //for
  return isFunny;
}


 public final static void main(String[] args)  {
  String input;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  try {
         input = br.readLine();
         StringPlay mystrPlay = new StringPlay();
         if (mystrPlay.isFunny(input)) {
            System.out.println("Funny");
         }
         else {
            System.out.println("Not Funny");
         }
         
  } catch (IOException ioe) {
         System.out.println("IO error trying to get input!");
         System.exit(1);
      }
  
 
   
  
  //mystrPlay.printBasic(); 
 } //main

}
