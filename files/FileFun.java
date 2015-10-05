import java.io.*;
import java.util.*;
import java.text.*;

class FileFun {

 /**
  * Open and read a file, and return the lines in the file as a list
  * of Strings.
  * (Demonstrates Java FileReader, BufferedReader, and Java5.)
  */
  private static List<String> readFile(String filename)
  {
  	System.out.println("Opening "+filename);
  	List<String> records = new ArrayList<String>();
  	try  {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line;
	    while ((line = reader.readLine()) != null)    {
	      records.add(line);
	    }
	    reader.close();
	    return records;
	  }
	  catch (Exception e) {
	    System.err.format("Exception occurred trying to read '%s'.", filename);
	    e.printStackTrace();
	    return null;
	  }
  }
  
  /*
    Searches for entries of a specific date within the log entries.
  
  */
  private static void searchLog (List<String> logList, String startDateStr, String endDateStr ) {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    try {
      Date startDate = dateFormat.parse(startDateStr);
      Date endDate = dateFormat.parse(endDateStr);
      for (String line : logList ) {
        //System.out.println(line);
        String[] entries = line.split(" ", 3); // get the line
        Date logDate =  dateFormat.parse(entries[0]+" "+entries[1]);
        if ( logDate.compareTo(startDate) >= 0 && logDate.compareTo(endDate) <= 0 ) 
          System.out.println(line);
      }              
    }
    catch ( ParseException ex ) {
      ex.printStackTrace();
    }
         
  }
  public final static void main(String[] args)  {
  
    FileFun myLogger = new FileFun();
    String logFile = args[0];
    List<String> mylogs = FileFun.readFile( logFile );    
    FileFun.searchLog( mylogs, "2015-09-02 15:42:00,000", "2015-09-02 15:43:00,000");
  }


}
