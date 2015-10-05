import java.util.*;

public class LuhnSIN
{


	public final static void main(String S[])
	{
	    System.out.println("Test SIN with Luhn Algorithm");
	    boolean sin= isValidSin(S[0]);
	    System.out.println("SIN number is: " +sin);
        }
  private static boolean isValidSin(String sin)
  {  //BEGIN isSin
     //   This function checks if the social insurance number
     //   entered passes the checksum, using the LUHN algorithm
     //   Given a SIN: 123456789
     //   Check that [1 + 2*2 + 3 + 2*4 + 5 + 2*6 + 7 + 2*8 + 9] mod 10 = 0
     //   Note that if 2*x is greater than 9, we add the two digits together.
     //   ie: 2*7 = 14, yeilds 1+4 = 5
     boolean bSinFormat= true;
     String tmpString= "";
     
     //SIN number is not enough digits
     if ( sin.length() != 9 ||
          !sin.matches("^\\d{9}$"))  {
       bSinFormat= false;
     }
     else
     {
        int digit1 = Integer.parseInt(sin.substring(0,1));
        int digit2 = Integer.parseInt(sin.substring(1,2)) * 2;
        int digit3 = Integer.parseInt(sin.substring(2,3));
        int digit4 = Integer.parseInt(sin.substring(3,4)) * 2;
        int digit5 = Integer.parseInt(sin.substring(4,5));
        int digit6 = Integer.parseInt(sin.substring(5,6)) * 2;
        int digit7 = Integer.parseInt(sin.substring(6,7));
        int digit8 = Integer.parseInt(sin.substring(7,8)) * 2;
        int digit9 = Integer.parseInt(sin.substring(8,9));
 
        if (digit2 > 9)
        {
            tmpString = Integer.toString(digit2);
            digit2 = Integer.parseInt(tmpString.substring(0,1)) + Integer.parseInt(tmpString.substring(1,2));
        }
        if (digit4 > 9)
        {
           tmpString = Integer.toString(digit4);
           digit4 = Integer.parseInt(tmpString.substring(0,1)) + Integer.parseInt(tmpString.substring(1,2));
        }
        if (digit6 > 9)
        {
           tmpString = Integer.toString(digit6);
           digit6 = Integer.parseInt(tmpString.substring(0,1)) + Integer.parseInt(tmpString.substring(1,2));
        }
        if (digit8 > 9)
        {
           tmpString = Integer.toString(digit8);
           digit8 = Integer.parseInt(tmpString.substring(0,1)) + Integer.parseInt(tmpString.substring(1,2));
        }        
        double tempNumber = digit1 + digit2 + digit3 + digit4 + 
                            digit5 + digit6 + digit7 + digit8 + digit9;
       
        tempNumber = (tempNumber/10) - (Math.floor(tempNumber/10)); 
      
        if (tempNumber % 10 != 0) {
          bSinFormat= false;
        }
     }
     return(bSinFormat);
  } // END isSin
}
