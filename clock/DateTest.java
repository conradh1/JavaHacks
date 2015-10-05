import java.util.*;

public class DateTest
{
	public final static void main(String S[])
	{
	   Calendar today = Calendar.getInstance();
           int year = today.get(Calendar.YEAR);
           int month =  (today.get(Calendar.MONTH) + 1);
           int day = today.get(Calendar.DAY_OF_MONTH); 
           String birthdate= S[0];
           int DOBDay = Integer.parseInt(birthdate.substring(0,2));
           int DOBMonth = Integer.parseInt(birthdate.substring(3,5));
           int DOBYear = Integer.parseInt(birthdate.substring(6,10));

           System.out.println("Test Dates");

           //System.out.println("Today is "+today);
           System.out.println("The year is: "+year);
           System.out.println("The month is: "+month);
           System.out.println("The day is: "+day);
           System.out.println("Your DOB day is: "+DOBDay);
           System.out.println("Your DOB month is:"+DOBMonth);
           System.out.println("Your DOB Year is: "+DOBYear);

        }
}
