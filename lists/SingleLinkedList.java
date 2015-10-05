import java.util.*;

public class SingleLinkedList  {

private Node head;
private int listCount;

public SingleLinkedList() {

  head = new Node(-1);
  listCount = 0;
}

public void addNode (int value) {
    Node node = new Node(value);
    Node currentNode = head;

    while ( currentNode.next != null ) {
      currentNode = currentNode.getNext();
    }
    currentNode.setNext(node);
    listCount++;
  }

public void addNode(int value, int index) {
    Node node = new Node(value);
    int i = 0;
    Node currentNode = head;
    while ( i < index && currentNode.next != null ) {
      currentNode = currentNode.getNext();
      i++;
    }
    node.setNext(currentNode.getNext());
    currentNode.setNext(node);
    listCount++;
}

public void updateNode (int value, int index) {
    int i = 0;
    Node currentNode = head;
    while ( i <= index && currentNode.next != null ) {
      currentNode = currentNode.getNext();
      i++;
    }
    currentNode.value = value;
}

public void deleteNode (int index) {
    int i = 0;
    Node currentNode = head;

    while ( i < index && currentNode.next != null ) {
      currentNode = currentNode.getNext();
      i++;
    }
    currentNode.setNext(currentNode.getNext().getNext());
}

public int size()
// post: returns the number of elements in this list.
{
  return listCount;
}

public void printNodes() {
  Node currentNode = head;
    while ( currentNode.next != null ) {
      currentNode = currentNode.getNext();
      System.out.print(currentNode.getValue()+", ");
    }
    System.out.println();
   System.out.println("Total Nodes:"+listCount);
}

private class Node {
  // reference to the next node in the chain,
  // or null if there isn't one.
  Node next;
  // data carried by this node.
  // could be of any type you need.
  int value;

  // Node constructor
  public Node(int value)
  {
  	  this.value = value;
	  next = null;

  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

} //Node



public static void main(String args[]) {
  SingleLinkedList sl = new SingleLinkedList();
  Random randomGenerator = new Random();

  sl.addNode(5);
  sl.addNode(7);
  sl.addNode(9);
  sl.addNode(12);
  //sl.addNode(randomGenerator.nextInt(100));
  sl.printNodes();
  sl.addNode(8,2); // should add to position 2.
  sl.printNodes();
  sl.updateNode(10,4);
  sl.printNodes();
  sl.deleteNode(2);
  sl.printNodes();
}

}