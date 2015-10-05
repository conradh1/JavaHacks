//: Cat.java
// Demonstrates object serialization in Java
import java.io.*;
import java.util.*;

public class Cat implements Serializable {
  // Generate a random int value:
  //a list of cat names
  private String[] cat_names= {
  	"Garfield",
	"Eek",
	"Eddie",
	"Heathcliff",
	"Kibi",
	"Eric",
	"Felix",
	"Fritz",
	"Puss-in-Boots",
  };
  //the state of a cat
  private String[] cat_state= { "eating", "sleeping" };
  //variables used for appending objects
  private Cat next_cat;
  private int cat_num,state_num;
  
  //cat constructor
  Cat(int name, int state) {
    System.out.println(" New Cat : "+cat_names[name]+" and is currently "+cat_state[state]+".");
    cat_num= name;
    state_num= state;
    //change state
    if (state == 0) state= 1;
    else if (state == 1) state= 0; 
    if(--name > 0)
      next_cat = new Cat(name, state);
  }
  //display the attributes of a cat
  public String displayCats() {
    String s = "My cat's name is "+cat_names[cat_num]+" and is currently "+cat_state[state_num]+"\n";
    if(next_cat != null)
      s += next_cat.displayCats();
    return s;
  }
  public static void main(String[] args) {
 	//make 9 new cats with the first cat in a eating state
	Cat my_cats = new Cat(8, 0);
	
	try {
	//save the new cat object
	ObjectOutputStream out =
		new ObjectOutputStream(
		new FileOutputStream("cat.out"));
	out.writeObject("Cat storage");
	out.writeObject(my_cats);
	out.close(); // Also flushes output
	//open the cat.out and obtain the cat objects
	ObjectInputStream in =
		new ObjectInputStream(
		new FileInputStream("Cat.out"));
	String s = (String)in.readObject();
	Cat my_serialized_cats = (Cat)in.readObject();
	System.out.println(s + ", Serialized Cats below:\n" + my_serialized_cats.displayCats());
	} catch(Exception e) {
	e.printStackTrace();
	}
  }
} ///:~
