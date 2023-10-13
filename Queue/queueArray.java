public class queueArray {
    static class Queue{
        private int rear = -1;
        private int size;
        private int[] queue;
        public Queue(int size){
            this.queue = new int[size];   
            this.size = size;         
        }

        public boolean isEmpty(){
            return rear == -1;
        }
        public boolean isFull(){
            return rear == size-1;
        }

        public void enque(int data){ // O(1)
            if(isFull()){
                System.out.println("Queue Is Full");
                return;
            }
            rear += 1;
            queue[rear] = data;
        }

        public int dequeue(){ // O(n)
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return Integer.MIN_VALUE;
            }

            int front = queue[0];
            for(int i = 0; i<rear; i++){
                queue[i] = queue[i+1];
            }
            rear -= 1;
            return front;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return Integer.MIN_VALUE;
            }

            return queue[0];
        }

        public void display(){
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return;
            }
            System.out.print("Queue = [ ");
            for(int i = 0; i<= rear; i++){
                System.out.print(queue[i] + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String args[]){
        Queue q = new Queue(5);
        q.enque(1);
        q.enque(2);
        q.enque(3);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }

        
    }
}
