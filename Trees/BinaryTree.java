import java.util.*;

/*
 Binary Tree Structure
*/
public class BinaryTree {

  private static Node root; 
  
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
  
  public void add( int value ) {
    Node newNode = new Node( value);
    Node currentNode = root;
    Node parentNode = null;
    
    if ( root == null ) {
      root = newNode;
      return;
    }
    
    while ( currentNode != null ) {
      parentNode = currentNode;
      if ( value > currentNode.value ) {
        currentNode = currentNode.right;
      }
      else if ( value < currentNode.value ) {
        currentNode = currentNode.left;
      }
      else {
        currentNode.value = value; //duplicate
        return;
      }
    }
    if ( value > parentNode.value ) {
      parentNode.right= newNode;
    }
    else {
      parentNode.left = newNode;
    }     
  }
  
  public void remove( int value ) {
    Node currentNode = root;
    Node parentNode = null;
    boolean isFound = false;
        
    // case tree is empty
    if ( currentNode == null ) {     
      return;
    }
    
    // Find the value to remove
    while ( currentNode.value != value) {
      parentNode = currentNode;
      if ( currentNode.value == value ) {
        isFound = true;
        break;
      }
      else {        
        if ( currentNode.value > value ) {
          currentNode = currentNode.left;
        }
        else 
          currentNode = currentNode.right;              
      }     
      // not found
      if ( currentNode == null )
        return;
    }
       
    // Go through each case to delete the node
    
    // case both leaves are null
    if ( currentNode.left == null && currentNode.right == null ) {
      if ( currentNode == root ) {        
        root = null;        
      }
      // assign the parent node value to null
      if ( parentNode.left == currentNode ) {
        parentNode.left = null;
      }
      else 
      
        parentNode.right = null;
    }
    else if ( currentNode.right == null ) {
      // assign left side
      if ( currentNode == root ) {
        root = currentNode.left;
      }
      else if ( parentNode.value > currentNode.left.value ) 
        parentNode.left = currentNode.left;
      else if ( parentNode.value < currentNode.left.value ) 
        parentNode.right = currentNode.left;
    }
    else if ( currentNode.left == null ) {
      if ( currentNode == root ) {
        root = currentNode.right;
      }
      else if ( parentNode.value > currentNode.right.value ) 
        parentNode.left= currentNode.right;
      else if ( parentNode.value < currentNode.right.value ) 
        parentNode.right = currentNode.right;
    }
    else if ( currentNode.left != null && currentNode.right != null ) {
      //now we have found the minimum element in the right sub tree
      Node successorNode   = getSuccessor(currentNode);
      if (currentNode ==root ){
              root = successorNode;
      }
      else if( parentNode.left == currentNode ){
              parentNode.left = successorNode;
      }else{
              parentNode.right = successorNode;
      }                       
      successorNode.left = currentNode.left;
    }    
  }
  
  public Node getSuccessor(Node deleleNode ) {
      Node successsor =null;
      Node successsorParent =null;
      Node current = deleleNode.right;
      while(current!=null){
              successsorParent = successsor;
              successsor = current;
              current = current.left;
      }
      //check if successor has the right child, it cannot have left child for sure
      // if it does have the right child, add it to the left of successorParent.
      // successsorParent
      if(successsor!=deleleNode.right){
              successsorParent.left = successsor.right;
              successsor.right = deleleNode.right;
      }
      return successsor;
  }
  public void printPreOrderTransversal(Node node) {
    if ( node != null ) {
      System.out.print(node.value+" ");    
      printPreOrderTransversal(node.left);    
      printPreOrderTransversal(node.right);
   }     
  }
  
  public void printInOrderTransversal(Node node) {
    if ( node != null ) {      
      printPreOrderTransversal(node.left);    
      System.out.print(node.value+" ");    
      printPreOrderTransversal(node.right);
   }     
  }
  
  public void printPostOrderTransversal(Node node) {
    if ( node != null ) {      
      printPreOrderTransversal(node.left);          
      printPreOrderTransversal(node.right);
      System.out.print(node.value+" ");    
   }     
  }
  
  public int findHeight(Node node) {
    if ( node != null )
       return Math.max( findHeight(node.left), findHeight(node.right)) + 1;        
    return 0;
  }
  
  public boolean searchTree( Node node, int value ) {
    if ( node != null ) {
      if ( node.value == value )
        return true;    
      else if ( node.left != null )
        return searchTree(node.left,value);
      else if ( node.right != null )   
      return searchTree(node.right,value);            
    }    
    return false;   
  }
  
  public int findMaxValue(Node node) {
     int maxValue = Integer.MAX_VALUE;
     if (node.left == null && node.right == null)
        return node.value;
    else {
        maxValue = node.value;
        if (node.left != null)
            maxValue=Math.max(maxValue,findMaxValue(node.left));
        if (node.right != null)
            maxValue = Math.max(maxValue,findMaxValue(node.right));
    }   
    return maxValue;
  }
  
  
 
  // Main will make a tree which is hard coded to the example
  public static void main(String ar[]) {

    BinaryTree b = new BinaryTree();
    b.add(5);
    b.add(3);
    b.add(7);
    b.add(1);
    b.add(9);
    b.add(2);
    System.out.println("Printing PreOrder-Transversal");
    b.printPreOrderTransversal(root);
    System.out.println("");
//     System.out.println("Delete Node");    
//     b.remove(2);
//     b.printInOrderTransversal(root);
    System.out.println("Tree Height"+b.findHeight(root));
    System.out.println("Tree Max Value "+b.findMaxValue(root));
    System.out.println("Found 2 in Tree?: "+b.searchTree(root,2));
    
    
  }
}





