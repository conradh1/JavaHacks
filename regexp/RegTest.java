/*
* Checks for invalid characters
* in email addresses
*/

import java.util.regex.*;

public class RegTest {
   public static void main(String[] args)
   	throws Exception {
		String input = "bob@bbc.co.uk";
                String email_regex = "^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,3}|[0-9]{1,3})(\\]?)$";
                String email_regex2 = "^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,3}|INFO|NAME|info|name|[0-9]{1,3})(\\]?)$";
		//Pattern p = Pattern.compile("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
                //input.matches();
		//Pattern p = Pattern.compile("Windows");
		//Matcher m = p.matcher(input);
		if (input.matches(email_regex) || input.matches(email_regex2)) {
			System.out.println("pattern match: "+input);
		}
		else {
			System.out.println("pattern not matched.");
		}
   }
}

