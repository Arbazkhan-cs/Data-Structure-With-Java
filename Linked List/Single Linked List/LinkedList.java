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
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void display(){
        if(head == null){
            System.out.println("Linked List is Empty!!!");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertAtMiddle(int data, int pos){
        Node newNode = new Node(data);
        int llSize = size();
        if(pos > llSize){
            System.out.println("Invalid Position");
        }
        else if(head == null && pos == 0){
            head = tail = newNode;
        }
        else if(pos == llSize){
            insertAtEnd(data);
        }
        else if(pos == 0){
            insertAtBegin(data);
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
        }

    }
    public int size(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.display();
        ll.insertAtBegin(0);
        ll.insertAtBegin(1);
        ll.insertAtBegin(2);
        ll.display();
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtEnd(7);
        ll.display();
        ll.insertAtMiddle(9, 0);
        ll.display();
        ll.insertAtMiddle(9, 7);
        ll.display();
        ll.insertAtMiddle(10, 3);
        ll.display();
    }
}
