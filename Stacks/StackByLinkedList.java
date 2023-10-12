import java.util.LinkedList;
public class StackByLinkedList {
    // static class Stack{
    //     private LinkedList<Integer> list = new LinkedList<>();

    //     // isEmpty
    //     public boolean isEmpty(){
    //         return list.size() == 0;
    //     }

    //     // push
    //     public void push(int data){
    //         list.addFirst(data);
    //     }

    //     // pop
    //     public int pop(){
    //         if(list.size() == 0){
    //             System.out.println("Stack is Empty!!!");
    //             return Integer.MIN_VALUE;
    //         }
    //         return list.removeFirst();
    //     }

    //     // peek
    //     public int peek(){
    //         if(list.size() == 0){
    //             System.out.println("Stack is Empty!!!");
    //             return Integer.MIN_VALUE;
    //         }
    //         return list.peek();
    //     }

    //     // display
    //     public void display(){
    //         if(list.size() == 0){
    //             System.out.println("Stack is Empty!!!");
    //             return;
    //         }
    //         System.out.println("Stack = "+list);
    //     }
    // }
    
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
        private Node head;

        // isEmpty
        public boolean isEmpty(){
            return head == null;
        }

        // push
        public void push(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public int pop(){
            if(head == null){
                return -1;
            } 
            int val = head.data;
            if(head.next == null){
                head = null;
                return val;
            }
            head = head.next;
            return val;
        }

        // peek 
        public int peek(){
            if(head == null){
                return -1;
            }
            return head.data;
        }
        // display
        public void display(){
            Node temp = head;
            System.out.print("Stack = [ ");
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println("]");
        }
    }

    public static void main(String args[]){
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);

        st.display();
        System.out.println("Peek Data = "+st.peek()); 

        System.out.println("Loop => ");
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
        System.out.println("Stack Is Empty!!!");
    }
}
