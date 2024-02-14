import java.util.*;
import java.util.LinkedList;
public class BinaryTreePart1 {
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
        public static void inorderTraverse(Node root){
            if(root == null){
                return;
            }
            preorderTraverse(root.leftChild);
            System.out.print(root.data + " ");
            preorderTraverse(root.rightChild);
        }
        public static void postorderTraverse(Node root){
            if(root == null){
                return;
            }
            postorderTraverse(root.leftChild);
            postorderTraverse(root.rightChild);
            System.out.print(root.data + " ");
        }
        public static void levelOrderTraverse(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }
                } else{
                    System.out.print(currNode.data + " ");
                    if(currNode.leftChild != null){
                        q.add(currNode.leftChild);
                    }
                    if(currNode.rightChild != null){
                        q.add(currNode.rightChild);
                    }
                }
            }
        }
        public static int heightOfTree(Node root){
            if(root == null){
                return 0;
            }
            int leftHight = heightOfTree(root.leftChild);
            int rightHight = heightOfTree(root.rightChild);
            return Integer.max(leftHight, rightHight)+1;
        }
        public static int NumberOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftCount = NumberOfNodes(root.leftChild);
            int rightCount = NumberOfNodes(root.rightChild);
            return leftCount+rightCount+1;
        }
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = sumOfNodes(root.leftChild);
            int rightSum = sumOfNodes(root.rightChild);
            return leftSum + rightSum + root.data;
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
    }

    public static void main(String args[]){
        // System.out.println("Hello World");
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root Node Data = " + root.data);

        System.out.print("Preorder Traverse = ");
        tree.preorderTraverse(root);
        System.out.print("\nInorder Traverse = ");
        tree.inorderTraverse(root);
        System.out.print("\nPostorder Traverse = ");
        tree.postorderTraverse(root);
        System.out.println("\nLevelorder Traverse = ");
        tree.levelOrderTraverse(root);

        System.out.println("Hight of the tree = "+tree.heightOfTree(root));
        System.out.println("Number of Nodes in tree = "+tree.NumberOfNodes(root));
        System.out.println("Sum of Nodes in tree = "+tree.sumOfNodes(root));

        System.out.println("Diameter [Longest Number of nodes between 2 leaf] = "+tree.calculateDiameter(root));
    }
}
