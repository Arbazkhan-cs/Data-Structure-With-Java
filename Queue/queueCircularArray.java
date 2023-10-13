public class queueCircularArray {
    static class Queue{
        private int rear;
        private int front;
        private int size;
        private int[] queue;
        public Queue(int size){
            this.queue = new int[size];   
            this.size = size;  
            this.front = -1;
            this.rear = -1;       
        }

        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        public boolean isFull(){
            return (rear+1)%size == front;
        }

        public void enque(int data){ // O(1)
            if(isFull()){
                System.out.println("Queue Is Full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear+1)%size;
            queue[rear] = data;
        }

        public int dequeue(){  // O(1)
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return Integer.MIN_VALUE;
            }

            int val = queue[front];
            if(front == rear){
                front = rear = -1;
            } else{
                front = (front+1)%size;
            }
            return val;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue Is Empty");
                return Integer.MIN_VALUE;
            }

            return queue[front];
        }
    }

    public static void main(String args[]){
        Queue q = new Queue(3);
        q.enque(1);
        q.enque(2);
        q.enque(3);

        q.dequeue();
        q.enque(4);
        q.dequeue();
        q.enque(5);
        
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }

        
    }
}
