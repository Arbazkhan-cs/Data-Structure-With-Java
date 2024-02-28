import org.w3c.dom.Node;
import java.util.*;
public class bstPart1 {
    public static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        public Node(int data){
            this.data=data;
            this.leftChild=null;
            this.rightChild=null;
        }
    }
    public static class BST{
        public Node insert(Node root, int val){
            if(root == null) 
                return new Node(val);

            if(root.data > val) 
                root.leftChild = insert(root.leftChild, val); 
            else  
                root.rightChild = insert(root.rightChild, val); 
              
            return root; 
        }

        public void printInorder(Node root){
            if(root == null){
                return;
            }
            printInorder(root.leftChild);
            System.err.print(root.data + " ");
            printInorder(root.rightChild);
        }

        public boolean search(Node root, int key){
            if(root == null){
                return false;
            }

            if(root.data == key){
                return true; 
            }

            if(root.data > key){
                return search(root.leftChild, key);
            } else{
                return search(root.rightChild, key);
            }
        }

        public Node deleteNode(Node root, int val) {
            if (root == null) return root;
        
            if (val < root.data) {
                root.leftChild = deleteNode(root.leftChild, val);
            } else if (val > root.data) {
                root.rightChild = deleteNode(root.rightChild, val);
            } else {
                // Node to delete found
        
                // Case 1 & 2: Node with only one child or no child
                if (root.leftChild == null) {
                    return root.rightChild;
                } else if (root.rightChild == null) {
                    return root.leftChild;
                }
        
                // Case 3: Node with two children
                // Find inorder successor (smallest node in the right subtree)
                Node IS = findInorderSuccessor(root.rightChild);
                root.data = IS.data;
        
                // Delete the inorder successor
                root.rightChild = deleteNode(root.rightChild, IS.data);
            }
            return root;
        }
        
        public Node findInorderSuccessor(Node root) {
            while (root.leftChild != null) {
                root = root.leftChild;
            }
            return root;
        }     
        
        public void printInRange(Node root, int k1, int k2){
            if(root == null){
                return;
            }
            // case 1
            if(root.data >= k1 && root.data <= k2){
                printInRange(root.leftChild, k1, k2);
                System.out.print(root.data + " ");
                printInRange(root.rightChild, k1, k2);
            }
            // case 2
            else if(root.data < k1){
                printInRange(root.leftChild, k1, k2);
            } else{
                printInRange(root.rightChild, k1, k2);
            }
        }

        public void printRootToLeaf(Node root, ArrayList<Integer> paths){
            if(root == null){
                return;
            }
            paths.add(root.data);
            if(root.leftChild == null && root.rightChild == null){
                System.out.println("Path: " + paths);
            }
            printRootToLeaf(root.leftChild, paths);
            printRootToLeaf(root.rightChild, paths);
            paths.remove(paths.size()-1);
        }
        public boolean isValidBST(Node root, Integer min, Integer max){
            if(root == null){
                return true;
            }
            if((min != null && root.data <= min) || (max != null && root.data>=max)){
                return false;
            }

            return isValidBST(root.leftChild, min, root.data) && 
                            isValidBST(root.rightChild, root.data, max);
        }
    }
    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;
        int[] values = {8, 5, 3, 6, 10, 11, 14};
        for(int val: values){
            root = tree.insert(root, val);
        }

        System.err.print("Root = ");
        tree.printInorder(root);
        System.err.println();
        // System.err.println("\n\nKey = "+tree.search(root, 6));
        // System.err.println("Key = "+tree.search(root, 1));
        
        // root = tree.deleteNode(root, 7);
        // tree.printInorder(root);
        
        // case 1 or 2
        // root = tree.deleteNode(root, 14);
        // System.err.print("Root = ");
        // tree.printInorder(root);
        // System.err.println();

        // // case 3
        // root = tree.deleteNode(root, 5);
        // System.err.print("Root = ");
        // tree.printInorder(root);
        // System.err.println();

        tree.printInRange(root, 5, 11);

        System.out.println("\nPath from root to leafes are: ");
        tree.printRootToLeaf(root, new ArrayList<Integer>());

        System.out.println("Is Valid BST: "+ tree.isValidBST(root, null, null));
    }
}
