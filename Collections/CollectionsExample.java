import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/pairs

public class CollectionsExample {
    public static void arrayListExample() {
      List<String> myList= new ArrayList<String>();   
      System.out.println("Doing ArrayList example.");
      myList.add("alpha");            // add() takes Object. String upcast to Object implicitly
      myList.add("beta");
      myList.add("charlie");
      System.out.println(myList);  
      System.out.println("size: "+myList.size());
      System.out.println("remove alpha");
      myList.remove("alpha");
      Iterator iter = myList.iterator();
      while (iter.hasNext()) {      // any more element
         // Retrieve the next element, explicitly downcast from Object back to String
         String str = (String)iter.next();
         System.out.println(str);
      }
      myList.clear();
    }
    
    public static void hashTableExample() {
     LinkedHashMap<Character,Integer> myhash = new LinkedHashMap<Character,Integer>();
     
     System.out.println("Doing HashTable example.");
     myhash.put('a', Character.getNumericValue('a'));
     myhash.put('b', Character.getNumericValue('b'));
     myhash.put('c', Character.getNumericValue('c'));
     
     if ( myhash.containsKey('c') ) {
       System.out.println("Contains leter c.");
     }
     Set<Character> keys = myhash.keySet();
     for (Character c : keys) {
      System.out.print(c);
      System.out.print(":");
      System.out.println(myhash.get(c));
     }
    }

    public static void stackExample() {
      Stack<Integer> mystack = new Stack<Integer>();

      System.out.println("Doing Stack example.");
      System.out.println("Pushing 1-4.");
      mystack.push(1);
      mystack.push(2);
      mystack.push(3);
      mystack.push(4);
      
      System.out.println("Popping "+mystack.pop());
      
      while ( !mystack.isEmpty() ) {
        System.out.println("Popping "+mystack.pop());
      }          
    }
    
    public static void queueExample() {
      Queue<Integer> queue = new ArrayDeque<Integer>();
      for (int i = 0; i < 5; i++)
            queue.offer(i);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    
    }
    public static void main(String[] args) {
        arrayListExample();
        hashTableExample();
        stackExample();
        queueExample();
    }
}
