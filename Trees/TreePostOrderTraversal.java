public class TreePostOrderTraversal {

  public static void main(String[] args) {
    new TreePostOrderTraversal().run();
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
    Postorder(root);
    System.out.println("");
  }

  public void Postorder(Node node) {
    if (node != null) {
      Postorder(node.left);
      Postorder(node.right);
      System.out.print(node.data+" ");
    }
  }

}
