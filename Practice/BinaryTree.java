import java.util.*;
public class BinaryTree{
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
    static class binaryTree{
        int idx = -1;
        public Node buildTreePreorder(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.leftChild = buildTreePreorder(nodes);
            newNode.rightChild = buildTreePreorder(nodes);
            return newNode;
        }
        public void printPreorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            printPreorder(root.leftChild);
            printPreorder(root.rightChild);
        }
        public void printInorder(Node root){
            if(root == null){
                return;
            }
            printInorder(root.leftChild);
            System.err.print(root.data + " ");
            printInorder(root.rightChild);
        }
        public void printPostorder(Node root){
            if(root == null){
                return;
            }
            printPostorder(root.leftChild);
            printPostorder(root.rightChild);
            System.err.print(root.data + " ");
        }
        public void printLevelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.err.println();
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }
                } else{
                    System.err.print(currNode.data + " ");
                    if(currNode.leftChild != null){
                        q.add(currNode.leftChild);
                    } 
                    if(currNode.rightChild != null){
                        q.add(currNode.rightChild);
                    }
                }
            }
        }
        public int heightOfTree(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = heightOfTree(root.leftChild);
            int rightChild = heightOfTree(root.rightChild);

            return Math.max(leftHeight, rightChild) + 1;
        }
        public int countNodes(Node root){
            if(root == null){
                return 0;
            }

            int countLeft = countNodes(root.leftChild);
            int countRight = countNodes(root.rightChild);

            return countLeft + countRight + 1;
        }
        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int sumLeft = sumOfNodes(root.leftChild);
            int sumRight = sumOfNodes(root.rightChild);

            return sumLeft + sumRight + root.data;
        }
        // ======= Diameter of the tree ==========================
        public int heightForDiameter(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = heightForDiameter(root.leftChild);
            int rightHeight = heightForDiameter(root.rightChild);

            return Math.max(leftHeight, rightHeight) + 1;
        }
        public int calculateDiameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDiameter = calculateDiameter(root.leftChild);
            int leftHeight = heightForDiameter(root.leftChild);
            int rightDiameter = calculateDiameter(root.rightChild);
            int rightHeight = heightForDiameter(root.rightChild) ;

            int selfDiameter = leftHeight + rightHeight + 1;
            return Integer.max(selfDiameter, Integer.max(leftDiameter, rightDiameter));
        }
        static class Info{
            int ht;
            int dim;
            public Info(int ht, int dim){
                this.ht = ht;
                this.dim = dim;
            }
        }
        public Info calculateDiameter2(Node root){
            if(root == null){
                return new Info(0, 0);
            }
            
            Info leftInfo = calculateDiameter2(root.leftChild);
            Info rightInfo = calculateDiameter2(root.rightChild);

            int dim = Math.max(Math.max(leftInfo.dim, rightInfo.dim), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

            return new Info(ht, dim);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6,-1, 7, -1, -1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildTreePreorder(nodes);
        System.err.print("Preorder = [ ");
        tree.printPreorder(root);
        System.err.println("]");

        System.err.print("Inorder = [ ");
        tree.printInorder(root);
        System.err.println("]");

        System.err.print("Postorder = [ ");
        tree.printPostorder(root);
        System.err.println("]");

        System.err.println("Levelorder = [ ");
        tree.printLevelOrder(root);
        System.err.println("]");

        System.err.println("Height of the tree = "+ tree.heightOfTree(root));
        System.err.println("Number of nodes = "+ tree.countNodes(root));
        System.err.println("Sum of nodes = "+ tree.sumOfNodes(root));
        System.out.println("Diameter of the tree (Approach-1) = "+ tree.calculateDiameter(root));
        System.out.println("Diameter of the tree (Approach-2) = "+ tree.calculateDiameter2(root).dim);

    }
}