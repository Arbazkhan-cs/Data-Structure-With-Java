public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head; // this will point head -> null
    public static Node tail; // this will also point tail - > null
    public static int Size = 0;

    // ================================INSERTING=============================================
    // Add at the end
    public void insertAtBegin(int data){
        // step 1 - creating New Node
        Node newNode = new Node(data);

        // step 2 - if head is null
        if(head == null){
            head = tail = newNode;

        } else{
            // step 3 - linking newnode -> head
            newNode.next = head;
    
            // step 4 - linking head -> newnode
            head = newNode;
        }
        Size++;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        Size++;
    }
    public void insertAtMiddle(int data, int pos){
        Node newNode = new Node(data);
        int llSize = Size;
        if(pos > llSize){
            System.out.println("Invalid Position");
        }
        else if(head == null && pos == 0){
            head = tail = newNode;
            Size++;
        }
        else if(pos == 0){
            insertAtBegin(data);
        }
        else if(pos == llSize){
            insertAtEnd(data);
        }
        else{
            Node temp = head;
            int i = 0;
            while(i < pos-1){
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            Size++;
        }
    }
    // ======================================REMOVING=================================================
    public int DeleteFromBegin(){
        if(head == null){
            System.out.println("Linked List Is Empty");
            return Integer.MIN_VALUE;
        }
        else if(head.next == null){
            int val = head.data;
            head = tail = null;
            Size--;
            return val;
        }
        else{
            int val = head.data;
            head = head.next;
            Size--;
            return val;
        }
    }
    public int DeleteFromEnd(){
        if(tail == null){
            System.out.println("Linked List Is Empty");
            return Integer.MIN_VALUE;
        }
        else if(head.next == null){
            int val = head.data;
            head = tail = null;
            Size--;
            return val;
        }
        else{
            int val = tail.data;
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            Size--;
            return val;
        }
    }
    public int DeleteFromMiddle(int pos){
        if(pos >= Size){
            System.out.println("Invalid Position");
            return Integer.MIN_VALUE;
        }
        else if(head == null){
            System.out.println("Linked List Is Empty");
            return Integer.MIN_VALUE;
        }
        else if(pos == 0){
            int val = DeleteFromBegin();
            return val;
        }
        else if(pos == Size-1){
            int val = DeleteFromEnd();
            return val;
        }
        else{
            Node temp = head;
            int i = 0;
            while(i < pos-1){
                temp = temp.next;
                i++;
            }
            int val = temp.next.data;
            temp.next = temp.next.next;
            Size--;
            return val;
        }
    }
    // ==================================SEARCHING==============================================
    public int IterativeSearch(int data){
        int i = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.data == data){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int RecursiveSearch(Node temp, int data, int index){
        if(temp == null){
            return -1;
        }
        else if(temp.data == data){
            return index;
        }
        else{
            return RecursiveSearch(temp.next, data, index+1);
        }

    }
    // ====================================REVERSE LINKEDLIST=========================================
    public void Reverse(){
        if(Size == 0 || Size == 1){
            return;
        }
        Node current = tail = head;
        Node prev = null;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    // ===================================REMOVE ITH NODE FROM END==============================
    public int RemoveIthNodeFromEnd(int FromEndPos){
        int FromFrontPos = Size - FromEndPos;
        if (FromEndPos < 0 || FromEndPos > Size) {
            System.out.println("Invalid position");
            return Integer.MIN_VALUE;
        }
        else if(head.next == null && FromFrontPos == 0){
            int val = head.data;
            head = tail = null;
            Size--;
            return val;
        }
        else if(FromFrontPos == 0){
            return DeleteFromBegin();
        }
        else if(FromFrontPos == Size-1){
            return DeleteFromEnd();
        }
        else{
            Node temp = head;
            int i = 0;
            while(i < FromFrontPos - 1){
                temp = temp.next;
                i++;
            }
            int val = temp.next.data;
            temp.next = temp.next.next;
            Size--;
            return val;
        }
    }
    // ==========================================PALINDROME=====================================
    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        // step 1 - Find Mid
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2 - Reverse the second half
        Node prevNode = null;
        Node currNode = slow;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        // step 3 - Comparing both halves
        Node tempNode = head;
        Node temp2Node = prevNode;
        while(tempNode != null && tempNode.next != null){
            if(tempNode.data != temp2Node.data) {
                return false;
            }
            tempNode = tempNode.next;
            temp2Node = temp2Node.next;
        }
        return true;
    }
    // ==========================================IS CYCLE============================================
    public static boolean isCycle(){ // Floyd's Cycle Finding Algorithm
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
    // =========================================REMOVING CYCLE=====================================
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }

        if(isCycle == false){
            return;
        }

        slow = head;
        Node prev = null;
        while(slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }
    // ========================================DISPLAY===============================================
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null: Size = "+Size);
    }
    public static void main(String args[]){
        // LinkedList ll = new LinkedList();
        // // Insertion ========================================================================
        // ll.display();
        // ll.insertAtBegin(0);
        // ll.insertAtBegin(1);
        // ll.insertAtBegin(2);
        // ll.display();
        // ll.insertAtEnd(5);
        // ll.insertAtEnd(6);
        // ll.insertAtEnd(7);
        // ll.display();
        // ll.insertAtMiddle(9, 0);
        // ll.display();
        // ll.insertAtMiddle(9, 7);
        // ll.display();
        // ll.insertAtMiddle(10, 3);
        // ll.display();

        // // Deletion ====================================================================
        // ll.DeleteFromBegin();
        // ll.display();
        // ll.DeleteFromEnd();
        // ll.display();
        // ll.DeleteFromMiddle(2);
        // ll.display();

        // // Iterative Searching ====================================================
        // System.out.println("Iterative Search For 6 = "+ll.IterativeSearch(6));
        // System.out.println("Iterative Search For 3 = "+ll.IterativeSearch(3));

        // // Recursive Search =============================================================
        // System.out.println("Recursive Search For 6 = "+ll.RecursiveSearch(head, 6, 0));
        // System.out.println("Recursive Search For 3 = "+ll.RecursiveSearch(head, 3, 0));

        // // Reverse A Linked List ===================================================
        // ll.Reverse();
        // ll.display();

        // // Remove From Ith Node From The End =========================================
        // int val = ll.RemoveIthNodeFromEnd(3);
        // ll.display();        

        // // IsPalindrome ===============================================================
        // LinkedList ll2 = new LinkedList();
        // ll2.insertAtEnd(1);
        // ll2.insertAtEnd(2);
        // ll2.insertAtEnd(3);
        // ll2.insertAtEnd(2);
        // ll2.insertAtEnd(1);

        // ll2.insertAtEnd(1);
        // ll2.insertAtEnd(2);
        // ll2.insertAtEnd(2);
        // ll2.insertAtEnd(1);
        // ll2.display();
        // System.out.println(ll2.isPalindrome());  // true

        // // Is Cycle ====================================================================
        // head = new Node(3);
        // head.next = new Node(2);
        // head.next.next = new Node(1);
        // System.out.println(isCycle()); // false
        // head.next.next.next = head;
        // System.out.println(isCycle()); // true
        
        // // Removing Cycle ============================================================
        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = head.next;
        System.out.println(isCycle()); // 3->2->1->2
        removeCycle();
        System.out.println(isCycle()); // 3->2->1->null
    }
}
