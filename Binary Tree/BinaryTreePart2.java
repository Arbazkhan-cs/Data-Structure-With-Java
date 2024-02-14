import java.util.*;
import java.util.LinkedList;
public class BinaryTreePart2 {
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

        public boolean helper(Node root1, Node root2){
            if (root1 == null && root2 == null) {
                return true;
            }
            
            if((root1 != null && root2 != null)&&(root1.data == root2.data)){
                boolean res1 = helper(root1.leftChild, root2.leftChild);
                boolean res2 = helper(root1.rightChild, root2.rightChild);

                return res1 && res2;
            }
            return false;
        }
        public boolean isSubtree(Node root1, Node root2){
            if(root1 == null){
                return false;
            }
            if(helper(root1, root2)){
                return true;
            }else{
                return isSubtree(root1.leftChild, root2) || isSubtree(root1.rightChild, root2);
            }
        }

        static class InfoTop{
            Node node;
            int hd;
            public InfoTop(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        public void topViewOfTree(Node root) {
            if(root == null){
                return;
            }

            Queue<InfoTop> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;

            q.add(new InfoTop(root, 0));
            q.add(null);
            while(!q.isEmpty()){
                InfoTop curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    } else{
                        q.add(null);
                    }
                } else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }
    
                    if(curr.node.leftChild != null){
                        q.add(new InfoTop(curr.node.leftChild, curr.hd - 1));
                        min = Math.min(min, curr.hd-1);
                    }
    
                    if(curr.node.rightChild != null){
                        q.add(new InfoTop(curr.node.rightChild, curr.hd + 1));
                        max = Math.max(max, curr.hd+1);
                    }
                }

            }

            for(int i = min; i<=max; i++){
                System.err.print(map.get(i).data+" ");
            }
            System.err.println();
        }
    }

    public static void main(String args[]){
        // System.out.println("Hello World");
        // int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println("Root Node Data = " + root.data);

        // System.out.print("Preorder Traverse = ");
        // tree.preorderTraverse(root);

        // System.out.println("\nDiameter [Longest Number of nodes between 2 leaf] = "+tree.calculateDiameter(root));
        // System.out.println("Height = " + tree.calculateDiameter2(root).ht);
        // System.out.println("Diameter = " + tree.calculateDiameter2(root).diam);

        int[] nodes1 = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        int[] nodes2 = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree tree = new BinaryTree();
        tree.idx = -1;
        Node root1 = tree.buildTree(nodes1);
        tree.idx = -1;
        Node root2 = tree.buildTree(nodes2);


        tree.preorderTraverse(root1);
        System.err.println();
        tree.preorderTraverse(root2);
        System.err.println("\n\nIs Subtree? "+tree.isSubtree(root1, root2));

        System.err.print("\nTop View Of The tree: ");
        tree.topViewOfTree(root1);
    }

}
