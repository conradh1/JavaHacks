public class BinaryTreeTest {

  public static void main(String[] args) {
    new BinaryTreeTest().run();
  }

  static class Node {
    Node left;
    Node right;

    int value;

    public Node(int value) {
      this.value = value;
    }
  }

  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(5);
    System.out.println("Binary Tree Example");
    System.out.println("Building tree with root value " + root.value);
//     insertRecursion(root, 1);
//     insertRecursion(root, 8);
//     insertRecursion(root, 6);
//     insertRecursion(root, 3);
//     insertRecursion(root, 9);
    insert(root, 1);
    insert(root, 8);
    insert(root, 6);
    insert(root, 3);
    insert(root, 9);
    System.out.println("Traversing tree in order");
    printInOrder(root);
    System.out.println("Traversing tree front-to-back from location 7");
    printFrontToBack(root, 7);
  }
  
  public void insert(Node node, int value) {
     Node newNode = new Node(value);
     Node tmpNode = node;
     Node parent = null;
     
     if ( node == null ) {
      node = newNode;
      return;
     }
               
     while ( tmpNode != null ) {
      parent = tmpNode;
      if ( value < tmpNode.value ) {
        tmpNode = tmpNode.left;
      }     
      else {        
        tmpNode = tmpNode.right;      
      }
     }
     if ( value < parent.value )
      parent.left = newNode;
     else 
      parent.right = newNode;
  }

  public void insertRecursion(Node node, int value) {
    if (value < node.value) {
      if (node.left != null) {
        insertRecursion(node.left, value);
      } 
      else {        
        node.left = new Node(value);
      }
    } 
    else if (value > node.value) {
      if (node.right != null) {
        insertRecursion(node.right, value);
      } 
      else {      
        node.right = new Node(value);
      }
    }
  }

  public void printTree( Node node ) {
    Node current = node;
    Node previous = null;
    
  
  }
  public void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.println("  Traversed " + node.value);
      printInOrder(node.right);
    }
  }

  /**
   * uses in-order traversal when the origin is less than the node's value
   * 
   * uses reverse-order traversal when the origin is greater than the node's
   * order
   */
  public void printFrontToBack(Node node, int camera) {
    if (node == null)
      return;
    if (node.value > camera) {
      // print in order
      printFrontToBack(node.left, camera);
      System.out.println("  Traversed " + node.value);
      printFrontToBack(node.right, camera);
    } else if (node.value < camera) {
      // print reverse order
      printFrontToBack(node.right, camera);
      System.out.println("  Traversed " + node.value);
      printFrontToBack(node.left, camera);
    } else {
      // order doesn't matter
      printFrontToBack(node.left, camera);
      printFrontToBack(node.right, camera);
    }
  }

}
