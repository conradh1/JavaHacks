import java.util.*;

/*

*/
public class Node {
  public int value; //Hold node value
  public Node left; //branches
  public Node right;

  // constructor
  public Node(int value)
  {
      this.value = value;
  }

  static public void printTree(Node root) {
      Queue<Node> currentLevel = new LinkedList<Node>();  //Use a linked list to transverse down the tree.
       Queue<Node> nextLevel = new LinkedList<Node>();



        // Go through the Linked List starting at the root until reaching the last node
        // in terms of Big 0 search, it's juts O(n) going through each branch.
        while (!currentLevel.isEmpty()) {
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

  // Main will make a tree which is hard coded to the example
  public static void main(String ar[])
    {

        // Creating the three example provided.
        Node root = new Node(5);

    }

}