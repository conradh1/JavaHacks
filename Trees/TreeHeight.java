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
    root.right = new Node(10);
    root.right = new Node(11);
   
    root.left.left = new Node(1);
    root.left.right = new Node(4);
    root.right.left = new Node(6);
    root.right.left.left = new Node(7);
    

    System.out.println("Finding height of Tree");   
    System.out.println(findHeight(root));
  }

  int findHeight(Node node) {
    if (node == null) return 0;
    return 1 + Math.max(findHeight(node.left), findHeight(node.right));
  }

}
