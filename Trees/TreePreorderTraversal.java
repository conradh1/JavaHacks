public class TreePreorderTraversal {

  public static void main(String[] args) {
    new TreePreorderTraversal().run();
  }

  static class Node {
    Node left;
    Node right;

    int data;

    public Node(int data) {
      this.data = data;
    }
  }

  public void run() {
    // build the simple tree from chapter 11.

    Node root = new Node(3);
    root.left = new Node(5);
    root.right = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(4);
    root.right.left = new Node(6);

    System.out.println("Traversing tree in order");
    //printInOrder(root);
    Preorder2(root);
    System.out.println("");
  }

  public void Preorder(Node node) {
    if (node != null) {
      System.out.print(node.data+" ");
      Preorder(node.left);
      Preorder(node.right);
    }
  }
  public void Preorder2(Node root) {
    Node tmpNode = root;

    if ( tmpNode == null )
      return;

    Node prevNode = tmpNode;
    while ( tmpNode != null ) {
      System.out.print(prevNode.data+" ");
      if ( tmpNode.left != null ) {
        prevNode = tmpNode;
	tmpNode = tmpNode.left;
      }
      else if ( tmpNode.right != null ) {
        prevNode = tmpNode;
	tmpNode = tmpNode.right;
      }
    }
  }
}
