import java.util.*;
import java.util.LinkedList;
public class basics {
    static class Node{
        int data;
        Node leftChild;
        Node rightChild;
        public Node(int data){
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.leftChild = buildTree(nodes);
            newNode.rightChild = buildTree(nodes);

            return newNode;
        }
        public static void preorderTraverse(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorderTraverse(root.leftChild);
            preorderTraverse(root.rightChild);
        }
        public static int heightOfTree(Node root){
            if(root == null){
                return 0;
            }
            int leftHight = heightOfTree(root.leftChild);
            int rightHight = heightOfTree(root.rightChild);
            return Integer.max(leftHight, rightHight)+1;
        }
        public static int calculateDiameter(Node root){ // O(n^2)
            if(root == null){
                return 0;
            }
            int leftDiameter = calculateDiameter(root.leftChild);
            int leftHeight = heightOfTree(root.leftChild);
            int rightDiameter= calculateDiameter(root.rightChild);
            int rightHeight = heightOfTree(root.rightChild);

            int selfDiameter = leftHeight + rightHeight + 1;
            return Integer.max(Integer.max(leftDiameter, rightDiameter), selfDiameter);
        }
        
        static class Info{
            int diam;
            int ht;
            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static Info calculateDiameter2(Node root){ // O(n)
            if(root == null){
                return new Info(0, 0);
            }

            Info leftInfo = calculateDiameter2(root.leftChild);
            Info rightInfo = calculateDiameter2(root.rightChild);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }
    }

    public static void main(String args[]){
        // System.out.println("Hello World");
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root Node Data = " + root.data);

        System.out.print("Preorder Traverse = ");
        tree.preorderTraverse(root);

        System.out.println("\nDiameter [Longest Number of nodes between 2 leaf] = "+tree.calculateDiameter(root));
        System.out.println("Height = " + tree.calculateDiameter2(root).ht);
        System.out.println("Diameter = " + tree.calculateDiameter2(root).diam);
    }
}
