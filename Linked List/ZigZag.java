public class ZigZag {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int Size = 0;

    public void addFront(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
        Size++;
    }
    public void addEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        Size++;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null: Size = "+Size);
    }

    public Node zig_zag(Node head){
        if (Size <= 2){
            return head;
        }
        // Finding Mid
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        Node prev = null;
        Node current = slow;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (head != prev && head != null && prev != null) {
            temp.next = head; // temp -> 1
            head = head.next; // 1-> head -> 2
            temp = temp.next; // 1-> temp -> head
            
            temp.next = prev; // 1-> temp -> 5
            prev = prev.next; // 5-> prev -> 4
            temp = temp.next; // 1-> 5-> temp -> prev
        }

        return dummy.next;
    }
    public static void main(String args[]){
        ZigZag ll = new ZigZag();
        ll.addEnd(1);
        ll.addEnd(2);
        ll.addEnd(3);
        ll.addEnd(4);
        // ll.addEnd(5);
        ll.display();

        ll.head = ll.zig_zag(ll.head);
        ll.display();
    }
}
