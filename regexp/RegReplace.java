/*
Program RegReplace
simple regular expression manipulation
*/

import java.util.regex.*; //import regular expression class

public class RegReplace {
   public static void main(String[] args)
   	throws Exception {
		String str= args[0]; 
		System.out.println("The string before html parsing: "+str);
		Pattern p = Pattern.compile("'");
		Matcher m = p.matcher(str); //new instance of Matcher object
		//while there are still html tags in html_str
		if (m.find()) {
			System.out.println("Matched pattern");
			str = m.replaceAll("\\\\'"); //replace the tags with blank string
		}
		System.out.println("The string after html parsing: "+str);
   	}
}
