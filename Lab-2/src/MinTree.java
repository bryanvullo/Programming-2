import uk.ac.soton.ecs.comp1206.labtestlibrary.datastructure.Tree;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.MinimumInTree;

public class MinTree implements MinimumInTree {

  public static void main(String[] args){
    Tree tree = new Tree( 24,
        new Tree( 45,
            null ,
            new Tree(8, null , null) ) ,
        new Tree ( 17,
            new Tree (74 , null , null ) ,
            null ) );
    MinTree minTree = new MinTree();
    System.out.println("Minimum is: " + minTree.findMin(tree));
  }

  public int findMin(Tree tree) {
		if (tree.left() == null && tree.right() == null) { //this is a leaf node
      return tree.getVal();
    } else if (tree.left() == null) { //has a child node on it's right
      return Math.min(tree.getVal(), findMin(tree.right()));
    } else if (tree.right() == null) { //has a child node to the left
      return Math.min(tree.getVal(), findMin(tree.left()));
    } else { //this node has two children
      int minChild = Math.min(findMin(tree.left()), findMin(tree.right()));
      return Math.min(tree.getVal(), minChild);
    }
  }
}