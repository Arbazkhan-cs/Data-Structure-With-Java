import java.util.*;
import java.util.LinkedList;

public class BinaryTreePart3{
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
        public Node buildPreorderTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.leftChild = buildPreorderTree(nodes);
            newNode.rightChild = buildPreorderTree(nodes);

            return newNode;
        }

        public void printPreorder(Node root){
            if(root == null){
                return;
            }
            printPreorder(root.leftChild);
            System.err.print(root.data + " ");
            printPreorder(root.rightChild);
        }

        public void printKthLevel(Node root, int k){
            Queue<Node> q = new LinkedList<>();
            ArrayList<Integer> res = new ArrayList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    k--;
                    if(k == 0){
                        break;
                    }
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(k == 1) {
                        res.add(curr.data);
                    }
                    if(curr.leftChild != null){
                        q.add(curr.leftChild);
                    }
                    if(curr.rightChild != null){
                        q.add(curr.rightChild);
                    }
                }
            }
            for (int i : res) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        public void printKthLevelRecurrsively(Node root, int k){
            if(root == null){
                return;
            }
            if(k == 1){
                System.out.print(root.data + " ");
                return;
            }
            printKthLevel(root.leftChild, k-1);
            printKthLevel(root.rightChild, k-1);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};

        Node root = tree.buildPreorderTree(nodes);
        tree.printPreorder(root);
        System.err.println("\n");

        System.err.println("print kth level by Recurrsion: ");
        tree.printKthLevelRecurrsively(root, 3);
        System.err.println("\nprint kth level by iterator: ");
        tree.printKthLevel(root, 3);

    }
}