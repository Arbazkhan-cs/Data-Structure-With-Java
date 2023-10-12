import java.util.ArrayList;
public class StackByArrayList{
    static class Stack{
        private int top = -1;
        private ArrayList<Integer> stack = new ArrayList<>();
        
        // isEmpty
        public boolean isEmpty(){
            return top == -1;
        }

        // push
        public void push(int data){
            stack.add(data);
            top++;
        }

        // pop
        public int pop(){
            if(top == -1){
                System.out.println("Stack Is Empty");
                return Integer.MIN_VALUE;
            }
            int val = stack.get(top);
            top--;
            return val;
        }

        //peek
        public int peek(){
            if(top == -1){
                System.out.println("Stack Is Empty");
                return Integer.MIN_VALUE;
            }
            return stack.get(top);
        }

        //display
        public void display(){
            if(top == -1){
                System.out.println("Stack Is Empty");
                return;
            }
            System.out.print("Stack = [ ");
            for(int i = top; i>=0; i--){
                System.out.print(stack.get(i)+" ");
            }
            System.out.println("]");
        }
    }
    public static void main(String args[]){
        // System.out.println("Hello World");
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(4);
        st.push(5);
        st.push(6);

        st.display();
        System.out.println("Peek Data = "+st.peek()); 
        st.pop();
        st.display();
        System.out.println("Peek Data = "+st.peek()); 

        System.out.println("Loop => ");
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
        System.out.println("Stack Is Now Empty!!!");
    }
}