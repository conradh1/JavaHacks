public class TreeInOrderTraversal {

  public static void main(String[] args) {
    new TreeInOrderTraversal().run();
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
    Inorder(root);
    System.out.println("");
  }

  public void Inorder(Node node) {
    if (node.left != null) 
        Inorder(node.left);    
    System.out.print(node.data+" ");         
    if (node.right != null )              
        Inorder(node.right);   
            
  }

}
