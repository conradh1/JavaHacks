public class TreeHeight {

  public static void main(String[] args) {
    new TreeHeight().run();
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
    root.right.left.left = new Node(7);

    System.out.println("Finding height of Tree");
    height(root);
    System.out.println("");
  }

  public void height(Node node) {
        
    if ( node == null ) {
      return 0;
    }
    if ( node.left != null)
      return 1 + height ( node.left );
  }

}
