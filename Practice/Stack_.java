import java.util.*;

import org.w3c.dom.Node;
public class Stack_ {
    static class StackByArrayList{
        ArrayList<Integer> st = new ArrayList<>();

        public boolean isEmpty(){
            return st.size() == 0;
        }
        public void push(int data){
            st.add(data);
        }
        public int pop(){
            if(isEmpty()){
                System.err.println("Stack is Empty!");
                return  Integer.MIN_VALUE; // Return a special value for empty stack.
            }
            return st.remove(st.size()-1);
        }
        public int peek(){
            if(isEmpty()){
                System.err.println("Stack is Empty!");
                return  Integer.MIN_VALUE; // Return a special value for empty stack.
            }
            return st.get(st.size() - 1);
        }
        public void display(){
            System.err.print("Stack = [ ");
            for(int i=st.size()-1; i>=0; i--){
                System.err.print(st.get(i) + " ");
            }
            System.err.println("]");
        }
        public void pushAtBottom(int data){
            Stack<Integer> st2 = new Stack<>();
            int i = st.size()-1;
            while(!isEmpty()){
                st2.push(st.remove(i));
                i--;
            }
            st.add(data);
            while(!st2.isEmpty()){
                st.add(st2.pop());
            }
        }
    }
    static class StackByLinkedList{
        class Node{
            int data;
            Node next;
            Node(int d){
                this.data = d;
                next = null;
            }
        }
        static Node head = null;
        static int size = 0;
        public boolean isEmpty(){
            return size == 0;
        }
        public void push(int data){
            Node newnode = new Node(data);
            newnode.next = head;
            head = newnode;
            size++;
        }
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty!");
                return  Integer.MIN_VALUE; // Throw an exception here.
            }
            int data = head.data;
            head = head.next;
            size--;
            return data;
        }
        public int peek(){
            return head.data;
        }
        public void display(){
            Node temp = head;
            System.err.print("Stack = [ ");
            while (temp != null){
                System.err.print(temp.data + " ");
                temp = temp.next;
            }
            System.err.println("]");
        }
    }
    
    public static void pushAtBottom(Stack<Integer> st, int data){
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int val = st.pop();
        pushAtBottom(st, data);
        st.push(val);
    }

    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            st.push(ch);
        }
        StringBuilder newStr = new StringBuilder();
        while(!st.isEmpty()){
            newStr.append(st.pop());
        }
        return newStr.toString();
    }

    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int val = st.pop();
        reverseStack(st);
        pushAtBottom(st, val);
    }
    public static int[] stockSpan(int[] price) {
        Stack<Integer> st = new Stack<>();
        int[] span = new int[price.length];
        for (int i = 0; i < price.length; i++) {
            while (!st.isEmpty() && price[i] >= price[st.peek()]) {
                st.pop();
            }
            span[i] = (st.isEmpty()) ? i + 1 : i - st.peek();
            st.push(i);
        }
        return span;
    }
    
    public static void displayArray(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.err.print(arr[i] + " ");
        }
        System.err.println();
    }
    public static void main(String[] args) {
        // StackByArrayList st = new StackByArrayList();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.display();

        // st.pop();
        // st.display();

        // StackByLinkedList st = new StackByLinkedList();
        // st.push(1);
        // st.push(2);
        // st.push(3);

        // st.display();

        
        // // By java collection framework ===============================================
        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.push(4);
        
        // System.err.print("Stack = [ ");
        // while(!st.isEmpty()){
        //     System.err.print(st.peek() + " ");
        //     st.pop();
        // }
        // System.err.println("]");


        // StackByArrayList st = new StackByArrayList();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // st.pushAtBottom(4);
        // st.display();

        // Stack<Integer> st2 = new Stack<>();
        // st2.push(1);
        // st2.push(2);
        // st2.push(3);
        // pushAtBottom(st2, 4);
        // System.err.println(st2);


        // String str = "ArbazKhan";
        // String newStr = reverseString(str);
        // System.err.println(newStr);


        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // System.err.println(st);
        // reverseStack(st);
        // System.err.println(st);
        
        int[] price = {100, 80, 60, 70, 60, 85, 100};
        displayArray(price);
        int[] span = stockSpan(price);
        displayArray(span);
        

    }
}