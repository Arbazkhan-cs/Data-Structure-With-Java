public class LinkedList {
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
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(10);
        // ll.tail = ll.head;
        // ll.head.data = 15;
        // System.err.println(ll.head.data + " " + ll.tail.data);

        // ll.head.next = new Node(16);
        // ll.head.next.next = new Node(17);
        // System.err.println(ll.head.data);
        // System.err.println(ll.head.next.data);
        // System.err.println(ll.head.next.next.data);

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.display();

        ll.removeFirst();
        ll.display();
        ll.removeLast();
        ll.display();

        ll.add(0, 7);
        ll.add(1, 8);
        ll.add(3, 9);
        ll.add(6, 0);
        ll.display();
        System.err.println("LinkedList Size = "+ll.size);
        System.err.println("1 is at Index = " + ll.iterativeSearch(1));
        System.err.println("1 is at Index = " + ll.recusiveSearch(1));

    }
}
