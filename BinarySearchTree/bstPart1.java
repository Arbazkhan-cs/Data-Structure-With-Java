import org.w3c.dom.Node;

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
    }
    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
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
        root = tree.deleteNode(root, 14);
        System.err.print("Root = ");
        tree.printInorder(root);
        System.err.println();

        // case 3
        root = tree.deleteNode(root, 5);
        System.err.print("Root = ");
        tree.printInorder(root);
        System.err.println();
    }
}
