/*
Program HTMLParse
simple regular expression manipulation
*/

import java.util.regex.*; //import regular expression class

public class HTMLParse {
   public static void main(String[] args)
   	throws Exception {
		String html_str= "<html><head><body>"+
				"This is some text."+
				"</body></head></body>";
		System.out.println("The string before html parsing: "+html_str);
		Pattern p = Pattern.compile("(<[^>]+>)");
		String tags= "";
		Matcher m = p.matcher(html_str); //new instance of Matcher object
		//while there are still html tags in html_str
		while (m.find(0)) {
			tags+= m.group(1); //find the first matching tag
			html_str = m.replaceFirst(""); //replace the tags with blank string
			m.reset(html_str); //reset the Matcher object to the modified string
		}
		System.out.println("The string after html parsing: "+html_str);
		System.out.println("The html tags that were parsed out: "+tags);
   	}
}
