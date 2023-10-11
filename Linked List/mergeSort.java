public class mergeSort{
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
    public void insertAtBegin(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;

        } else{
            newNode.next = head;
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
    // ========================================DISPLAY===============================================
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null: Size = "+Size);
    }

    // ===========================================MERGESORT CODE=========================================
    private Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node MergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = findMid(head);

        // left and right halfs
        Node head2 = mid.next;
        mid.next = null;
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(head2);

        // merge
        return merge(newLeft, newRight);
    }

    private Node merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            } else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String args[]){
        mergeSort ll = new mergeSort();
        ll.insertAtBegin(1);
        ll.insertAtBegin(2);
        ll.insertAtBegin(3);
        ll.insertAtEnd(6);
        ll.insertAtEnd(5);
        ll.display();

        ll.head = ll.MergeSort(ll.head);
        ll.display();
    }
}