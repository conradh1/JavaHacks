import java.util.*;

/*
 Binary Tree Structure
*/
public class TreeFun {

  class Node {
  // reference to the next node in the chain,
  // or null if there isn't one.
    public int value; //Hold node value
    public Node left; //branches
    public Node right;


    // Node constructor
    public Node(int value) {
  	  this.value = value;
	  left = null;
	  right = null;
    }

} //Node

  private static Node root;

  // sets the root value
  public void addNode(int value) {
    Node newNode = new Node(value);
    if ( root == null ) {
      root = newNode;
    }
    else {
      Node currentNode = root;
      Node parent;
      while ( true )  {
        parent = currentNode;
	if ( value < currentNode.value ) {
	  currentNode = currentNode.left;
	  if ( currentNode == null ) {
	    parent.left = newNode;
	    return;
	  }
	}
	else if ( value > currentNode.value ) {
	  currentNode = currentNode.right;
	  if ( currentNode == null ) {
	    parent.right = newNode;
	    return;
	  }
	}
      }

    }
  }

  /* Prints the binary tree
  */
  public void printTree(Node root) {
      Queue<Node> currentLevel = new LinkedList<Node>();  //Use a linked list to transverse down the tree.
      Queue<Node> nextLevel = new LinkedList<Node>();

      if ( root == null )
	return;

      currentLevel.add(root);

      while ( !currentLevel.isEmpty() ) {
	Iterator<Node> iter = currentLevel.iterator();
	while (iter.hasNext()) {
          Node currentNode = iter.next();
          // add the next level to print
          if (currentNode.left != null) {
              nextLevel.add(currentNode.left);
          }
          if (currentNode.right != null) {
              nextLevel.add(currentNode.right);
          }
          System.out.print(currentNode.value + " ");
	}
	System.out.println(); //end of level so print new line
	currentLevel = nextLevel;
	nextLevel = new LinkedList<Node>();
      }
  }

  public void printPreOrderIt(Node root) {
    Stack<Node> s = new Stack<Node>();

    if ( root == null )
      return;

    s.push(root);

    while (!s.isEmpty()) {
      Node currentNode = s.pop();
      System.out.print(currentNode.value+" ");
      if ( currentNode.left != null )
	s.push(currentNode.left);
      if ( currentNode.right != null )
	s.push(currentNode.right);
    }
    System.out.println();
  }

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    Queue<Node> q = new LinkedList<Node>();
    List<Integer> current = new ArrayList<Integer>();
    if ( root == null )
      return result;

    q.add(root);
    q.add(null);

    while ( !q.isEmpty() ) {
      Node tmp = q.remove();
      if (tmp != null ) {
	current.add(tmp.value);
	if ( tmp.left != null ) {
	  q.add(tmp.left);
	}
	if ( tmp.right != null ) {
	  q.add(tmp.right);
	}
      }
      else {
        List<Integer> c = new ArrayList<Integer>(current);
	result.add(c);
	current.clear();
	if ( !q.isEmpty())
	  q.add(null);
      }
    } //while

    return result;

  }

  public List<List<Integer>> zigzagLevelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    Queue<Node> q = new LinkedList<Node>();
    List<Integer> current = new ArrayList<Integer>();
    if ( root == null )
      return result;

    boolean goLeft = false;

    q.add(root);
    q.add(null);

    while ( !q.isEmpty() ) {
      Node tmp = q.remove();
      if (tmp != null ) {
	current.add(tmp.value);
	if ( tmp.left != null ) {
	  q.add(tmp.left);

	}
	if ( tmp.right != null ) {
	  q.add(tmp.right);
	}
      }
      else {
	if ( goLeft ) {
	  List<Integer> c = new ArrayList<Integer>(current);
	  Collections.reverse(c);
	  result.add(c);
	  goLeft = false;
	}
	else {
	  List<Integer> c = new ArrayList<Integer>(current);
	  result.add(c);
	  goLeft = true;
	}
	current.clear();
	if ( !q.isEmpty())
	  q.add(null);
      }
    } //while

    return result;

  }

  public int findMinimum(Node currentNode) {
    if (currentNode == null)
        return -1;

    if (currentNode.left != null)
        return findMinimum(currentNode.left);

    return currentNode.value;

  }


  public int findMaximum(Node currentNode) {
    if (currentNode == null)
        return -1;

    if (currentNode.right != null)
        return findMaximum(currentNode.right);

    return currentNode.value;

  }
  // Main will make a tree which is hard coded to the example
  public static void main(String ar[]) {

    TreeFun b1 = new TreeFun();
    b1.addNode(5);
    b1.addNode(8);
    b1.addNode(9);
    b1.addNode(4);
    b1.addNode(2);
    b1.addNode(3);
    b1.addNode(7);
    System.out.println("Printing Tree");
    //b1.printTree(root);
    System.out.println("Find minimum value"+b1.findMinimum(root));
    System.out.println("Find minimum value"+b1.findMaximum(root));
    //b1.printPreOrderIt(root);
    List<List<Integer>> levelOrder = b1.levelOrder(root);
    for (List<Integer> level : levelOrder) {
      for (Integer i : level) {
	 System.out.print(i+" ");
      }
      System.out.println();
    }
    System.out.println("ZigZag Order");
    List<List<Integer>> zigzagOrder = b1.zigzagLevelOrder(root);
    for (List<Integer> level : levelOrder) {
      for (Integer i : level) {
	 System.out.print(i+" ");
      }
      System.out.println();
    }

  }
}





