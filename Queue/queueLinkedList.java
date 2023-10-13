public class queueLinkedList {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{
        private Node head;
        private Node tail; 
        private int size;
        
        public boolean isEmpty(){
            return head == null && tail == null;
        }

        public void enqueue(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
            } else{
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue Is Full");
                return Integer.MIN_VALUE;
            }
            int val = tail.data;
            if(size == 1){
                head = tail = null;
            } else{
                head = head.next;
            }
            size--;
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue Is Full");
                return Integer.MIN_VALUE;
            }

            return head.data;
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.dequeue();
        q.enqueue(4);
        q.dequeue();
        q.enqueue(5);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}
