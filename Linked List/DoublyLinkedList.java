public class DoublyLinkedList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int Size = 0;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        Size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        Size++;
    }
    public int removeFirst(){
        if(Size == 0){
            return Integer.MIN_VALUE;
        } else if (Size == 1){
            int val = head.data;
            head = tail = null;
            Size--;
            return val;
        } else{
            int val = head.data;
            head = head.next;
            head.prev = null;
            Size--;
            return val;
        }
    }
    public int removeLast(){
        if(Size == 0){
            return Integer.MIN_VALUE;
        } else if (Size == 1){
            int val = tail.data;
            head = tail = null;
            Size--;
            return val;
        } else{
            int val = tail.data;
            tail = tail.prev;
            tail.next = null;
            Size--;
            return val;
        }
    } 
    public void reverse(){
        Node prev = null;
        Node current = head;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void displayFromHead(){
        Node temp = head;
        System.out.print("Form Head => ");
        while(temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.next;
        }
        System.out.println("null: Size = "+Size);
    }
    
    public void displayFromTail(){
        Node temp = tail;
        System.out.print("Form Tail => ");
        while(temp != null){
            System.out.print(temp.data+" <-> ");
            temp = temp.prev;
        }
        System.out.println("null: Size = "+Size);
    }

    
    public static void main(String args[]){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(5);
        dll.addFirst(3);
        dll.addLast(7);
        dll.addLast(8);
        dll.displayFromHead();
        // dll.displayFromTail();

        dll.reverse();
        dll.displayFromHead();

        // dll.removeLast();
        // dll.removeFirst();
        // dll.displayFromHead();
        // dll.displayFromTail();
    }
}
