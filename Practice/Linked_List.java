import java.util.LinkedList;
public class Linked_List {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.err.print(temp.data + " ");
            temp = temp.next;
        }
        System.err.println();
    }

    public void addFirst(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
        } else{
            newnode.next = head;
            head = newnode;
        }
        size++;
    }

    public void addLast(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
        } else{
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }

    public void add(int index, int data){
        if(index < 0 || index > size-1){
            System.err.println("Index Out Of Range!");
            return;
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        Node temp = head;
        index--;
        while(index != 0){
            temp = temp.next;
            index--;
        }

        Node newnode = new Node(data);
        newnode.next = temp.next;
        temp.next = newnode;

        size++;
        return;
    }

    public int removeFirst(){
        if(isEmpty()){
            System.err.println("Linked List is Empty!");
            return Integer.MIN_VALUE;
        }
        if(head.next == null){
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int removeLast(){
        if(isEmpty()){
            System.err.println("Linked List Is Empty!");
            return Integer.MIN_VALUE;
        }
        if(head.next == null){
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        tail = head;
        while(tail.next.next != null){
            tail = tail.next;
        }
        int data = tail.next.data;
        tail.next = null;
        size--;
        return data;
    }

    public int iterativeSearch(int key){
        Node temp = head;
        int idx = 0;
        while(temp != null){
            if(temp.data == key){
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }
    
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }
    public int recusiveSearch(int key){
        return helper(head, key);
    }

    public void reverseList(){
        if(size == 0 || size == 1){
            return;
        }
        Node currNode = tail = head;
        Node prevNode = null;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        };
        head = prevNode;
        return;
    }
    public int removeFromEnd(int idx){
        // calculating Size of the linked list
        int Size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            Size++;
        }

        // if index is less than 0 or more than the ll size
        if(idx <= 0 || idx > Size){
            System.err.println("Node Out Of Range!");
            return Integer.MIN_VALUE;
        }

        // if idx is equal to size (1st Node from head)
        if(idx == Size){
            int data = head.data;
            head = head.next;
            return data;
        }

        //  Main Logic to remove from midle
        temp = head;
        int idxFromStart = Size - idx - 1; // -1 , temp to the previous node, which we want to delete
        while(idxFromStart != 0){
            temp = temp.next;
            idxFromStart--;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        if(idx == 1){
            tail = temp;
        }
        size--;
        return data;
    }

    public boolean isPalindromeByString(){ // O(n) - time, O(n) - space
        if(head == null || head.next == null){
            return true;
        }
        StringBuilder st = new StringBuilder();
        Node temp = head;
        while(temp != null){
            st.append(temp.data);
            temp = temp.next;
        }

        int low = 0;
        int high = st.length()-1;
        while(low <=  high){
            if(st.charAt(low) != st.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public boolean isPalindrome(){ // O(n) - time, O(1) - space
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node middleNode = slow;
        Node prevNode = null;
        while(middleNode != null){
            Node nextNode = middleNode.next;
            middleNode.next = prevNode;
            prevNode = middleNode;
            middleNode = nextNode;
        }

        Node temp1 = head;
        Node temp2 = prevNode;
        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public boolean detectCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        return;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node RightHalf = slow.next;
        slow.next = null;
        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(RightHalf);

        return Merge(leftHead, rightHead);
    }
    public Node Merge(Node leftHead, Node rightHead){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(leftHead != null && rightHead != null){
            if(leftHead.data <= rightHead.data){
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        while(leftHead != null){
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        
        while(rightHead != null){
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public void convertToZigZac(){
        // Finding Mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse
        Node midNode = slow;
        Node prev = null;
        while(midNode!=null){
            Node next = midNode.next;
            midNode.next = prev;
            prev = midNode;
            midNode = next;
        }

        // Converting to zig-zac
        Node rightHead = prev;
        Node leftHead = head;

        Node nextLeft = null;
        Node nextRight = null;
        while(leftHead != null && rightHead != null){
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            leftHead = nextLeft;
            rightHead = nextRight;
        }

        if(leftHead != null){
            leftHead.next = null;
            leftHead = leftHead.next;
        }
    }
    public static void main(String[] args) {
        // Linked_List ll = new Linked_List();
        // ll.head = new Node(10);
        // ll.tail = ll.head;
        // ll.head.data = 15;
        // System.err.println(ll.head.data + " " + ll.tail.data);

        // ll.head.next = new Node(16);
        // ll.head.next.next = new Node(17);
        // System.err.println(ll.head.data);
        // System.err.println(ll.head.next.data);
        // System.err.println(ll.head.next.next.data);

        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.display();

        // ll.removeFirst();
        // ll.display();
        // ll.removeLast();
        // ll.display();

        // ll.add(0, 7);
        // ll.add(1, 8);
        // ll.add(3, 9);
        // ll.add(6, 0);
        // ll.display();
        // System.err.println("LinkedList Size = "+ll.size);
        // System.err.println("1 is at Index = " + ll.iterativeSearch(1));
        // System.err.println("1 is at Index = " + ll.recusiveSearch(1));

        // ll.reverseList();
        // ll.display();
        // System.err.println("Head = "+ll.head.data + ", Tail = "+ll.tail.data);
        

        // ll.removeFromEnd(ll.size-1);
        // ll.display();
        // System.err.println("Head = "+ll.head.data + ", Tail = "+ll.tail.data);


        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // System.err.println("Is Palindorme: "  + ll.isPalindromeByString());
        // System.err.println("Is Palindorme: "  + ll.isPalindrome());


        // Node newnode1 = new Node(1);
        // Node newnode2 = new Node(2);
        // Node newnode3 = new Node(3);
        // Node newnode4 = new Node(4);
        // Node newnode5 = new Node(5);
        // Node newnode6 = new Node(6);
        // ll.head = newnode1;
        // newnode1.next = newnode2;
        // newnode2.next = newnode3;
        // newnode3.next = newnode4;
        // newnode4.next = newnode5;
        // newnode5.next = newnode6;
        // newnode6.next = newnode3;


        // System.err.println("Detect Cycle: "  + ll.detectCycle());
        // ll.removeCycle();
        // System.err.println("Detect Cycle: "  + ll.detectCycle());
        // ll.display();


        // Java Collection Framework - Linked List======================================
        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // System.err.println(ll);

        Linked_List ll = new Linked_List();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.display();
        ll.head = ll.mergeSort(ll.head);
        ll.display();

        ll.convertToZigZac();
        ll.display();
        
    }
}   
