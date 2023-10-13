import java.util.*;
public class queueUsing2Stacks {

    static class Queue{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }

        public void add(int data){  // O(n)
            if(isEmpty()){
                s1.push(data);
                return;
            }

            // step1 - Transfer s1 to s2
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            // step2 - add the data
            s1.push(data);

            // step3 - again transfer s2 to s1
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }  

        public int remove(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return Integer.MIN_VALUE;
            }
            int val = s1.pop();
            return val;
        }

        public int peek(){ // O(1)
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return Integer.MIN_VALUE;
            }

            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
