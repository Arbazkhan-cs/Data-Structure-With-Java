import java.util.LinkedList;

public class InbuiltLinkedList {
    public static void main(String args[]){
        // Creating
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.add(1, 5);
        ll.add(3, 6);

        // Display
        System.out.println(ll);

        // remove
        ll.removeFirst();
        ll.removeLast();
        ll.remove(1);

        System.out.println(ll);
    }
}
