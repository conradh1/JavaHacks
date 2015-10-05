import java.util.*;

public class Collections  {


static char[] testArray = {'a', 'b', 'c', 'c', 'c','d', 'e' };


public int countWithHashMap(char[] array, char key) {
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	for (int i = 0; i < array.length; i++) {
		if (map.containsKey(array[i])) {
		  if ( key == array[i] ) {
			int count = map.get(key);
			map.put(key, ++count);
		  }
		} else {
		        // initalize count
		    if ( key == array[i] ) {
		      map.put(array[i], 1);
		    }
		    else {
		      map.put(array[i], 0);
		    }
		}
	}
	// print the sorted array
	if ( !map.isEmpty() ) {
	  TreeMap<Character, Integer> sortedHashMap = new TreeMap<Character, Integer>(map);
	  System.out.println(sortedHashMap);
	}
	return map.get(key);
    }

public void printMapExample() {
  HashMap<Integer, String>  map = new HashMap<Integer, String>();
  map.put(21, "Twenty One");
  map.put(31, "Thirty One");
  map.put(42, "Forty Two");

  Iterator<Integer> keySetIterator = map.keySet().iterator();

  while(keySetIterator.hasNext()){
    Integer key = keySetIterator.next();
    System.out.println("key: " + key + " value: " + map.get(key));
  }
  map.clear();

}

static void stackDemo() {
  Stack<Character> st = new Stack<Character>();
  System.out.println("stack: " + st);
  showpush(st, 'a');
  showpush(st, 'b');
  showpush(st, 'c');
  showpop(st);
  showpop(st);
  showpop(st);
}

static void showpush(Stack<Character> st, char c) {
  st.push(c);
  System.out.println("push(" + c + ")");
  System.out.println("stack: " + st);
}

static void showpop(Stack<Character> st) {
  System.out.print("pop -> ");
  char c =  st.pop();
  System.out.println(c);
  System.out.println("stack: " + st);
}



public static void main(String args[]) {

  Collections c = new Collections();
  char key = 'c';
  int count = c.countWithHashMap( testArray, key );
  System.out.println("Count of: "+key+" is: "+count);
  c.printMapExample();
  try {
    stackDemo();
  }
  catch (EmptyStackException e) {
    System.out.println("empty stack");
  }

}

}