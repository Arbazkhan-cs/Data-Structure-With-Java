import java.util.*;
import java.util.LinkedList;

import org.w3c.dom.Node;

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
        public boolean getPath(Node root, Node node, ArrayList<Node> arr){
            if(root == null){
                return false;
            }
            if(root.data == node.data){
                return true;
            }

            boolean path1 = getPath(root.leftChild, node, arr);
            boolean path2 = getPath(root.rightChild, node, arr);
            if(path1 || path2){
                arr.add(root);
                return true;
            }else{
                return false;
            }
        }
        public Node LowestComanAncester(Node root, Node n1, Node n2) {
            ArrayList<Node> arr1 = new ArrayList<Node>();
            ArrayList<Node> arr2 = new ArrayList<Node>();
            getPath(root, n1, arr1);
            getPath(root, n2, arr2);
            int l = 0, r = 0;
            while (l < arr1.size() && r < arr2.size()) {
                if(arr1.get(l) == arr2.get(r)){
                    return arr1.get(l);
                }
                l++;
                r++;
            }

            return new Node(-1);
        }

        public Node LowestComanAncesterApproac2(Node root, Node n1, Node n2) {
            if(root == null || root.data == n1.data || root.data == n2.data){
                return root;
            }
            Node leftAncester = LowestComanAncesterApproac2(root.leftChild, n1, n2);
            Node rightAncester = LowestComanAncesterApproac2(root.rightChild, n1, n2);

            // left but not right
            if(rightAncester == null){
                return leftAncester;
            } // right but not left
            if(leftAncester == null){
                return rightAncester;
            }
            
            return root;
        }
        // =========================== Distance Between Two Nodes ========================================
        public int DistanceBtwAncestorAndNodeN(Node root, Node n){
            if (root == null) {
                return -1;
            }
            if (root.data == n.data) {
                return 0;
            }
            int ld = DistanceBtwAncestorAndNodeN(root.leftChild, n);
            int rd = DistanceBtwAncestorAndNodeN(root.rightChild, n);

            if (ld == -1 && rd == -1) {
                return -1; // Node not found in either subtree
            } else if (ld == -1) {
                return rd + 1; // Node found in the right subtree
            } else {
                return ld + 1; // Node found in the left subtree
            }
        }
        public Node findLCA(Node root, Node n1, Node n2) {
            if(root == null || root.data == n1.data || root.data == n2.data){
                return root;
            }

            Node leftAncestor = findLCA(root.leftChild, n1, n2);
            Node rightAncestor = findLCA(root.rightChild, n1, n2);

            if(leftAncestor != null && rightAncestor != null){
                return root;
            }

            return (leftAncestor != null) ? leftAncestor : rightAncestor;
        }
        public int minDistBtwNodes(Node root, Node n1, Node n2) {
            Node ancestor = findLCA(root, n1, n2);
            return DistanceBtwAncestorAndNodeN(ancestor, n1) + DistanceBtwAncestorAndNodeN(ancestor, n2);
        }

        public int KthAncester(Node root, int n, int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int leftDist = KthAncester(root.leftChild, n, k);
            int rightDist = KthAncester(root.rightChild, n, k);

            if(leftDist == -1 && rightDist == -1){
                return -1;
            }
            
            int maxDist = Math.max(leftDist, rightDist);

            if(maxDist+1 == k){
                System.out.println("K-th Ancestor is " + root.data);
            }

            return maxDist+1;
        }

        public int toSumTree(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = toSumTree(root.leftChild);
            int rightSum = toSumTree(root.rightChild);
            int data = root.data;
            if(root.leftChild == null || root.rightChild == null){
                root.data =  leftSum + rightSum;
            } else{
                root.data = root.leftChild.data + leftSum + root.rightChild.data + rightSum;
            }

            return data;
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        /* 
                        1
                      /  \
                     /    \
                    /      \
                   2        3
                  / \      / \
                 /   \    /   \
                4     5  6     7
        */

        Node root = tree.buildPreorderTree(nodes);
        tree.printPreorder(root);
        System.err.println("\n");

        System.err.println("print kth level by Recurrsion: ");
        tree.printKthLevelRecurrsively(root, 3);
        System.err.println("\nprint kth level by iterator: ");
        tree.printKthLevel(root, 3);


        Node lca = tree.LowestComanAncesterApproac2(root, new Node(4), new Node(5));
        System.err.println("LCA = "+lca.data);

        System.out.println("Minimum Difference = "+tree.minDistBtwNodes(root, new Node(4), new Node(6)));
        tree.KthAncester(root, 5, 1);
        tree.toSumTree(root);
        tree.printPreorder(root);
    }
}