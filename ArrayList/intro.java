import java.util.ArrayList;
import java.util.Collections;
public class intro {
    public static void swapIndex(ArrayList <Integer> list, int indx1, int indx2){
        int temp = list.get(indx1);
        list.set(indx1, list.get(indx2));
        list.set(indx2, temp);
    }
    public static void main(String args[]){
        // Integer | String | Float
        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<String> list2 = new ArrayList<>();
        // ArrayList<Boolean> list3 = new ArrayList<>();
        // ArrayList<Float> list4 = new ArrayList<>();

        // Operations performed on ArrayList with it's time complexity
        // add element              O(1)
        // get element              O(1)
        // Remove element           O(n)
        // Set Element At Index     O(n)
        // contains element         O(n)

        // Add operation - O(1)
        list.add(1); 
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list); // [1, 2, 3, 4]

        // Get operation - O(1)
        int element = list.get(2);
        System.out.println(element); // 3
        element = list.get(3);
        System.out.println(element); // 4

        // Remove operation - O(n)
        list.remove(2); // remove the element at index 2
        System.out.println(list); // [1, 2, 4]

        // Set Element At Index - O(n)
        list.set(1, 5); // set element 5 at index 1
        System.out.println(list); // [1, 5, 4]

        // Contains Element in ArrayList? - O(n)
        System.out.println(list.contains(4));  // true
        System.out.println(list.contains(2));  // false

        // Another Add method - O(n)
        list.add(1, 10);  // this will add 10 at index 1
        list.add(2, 7);  // this will add 7 at index 2
        System.out.println(list); // [1, 10, 7, 5, 4]

        
        // Size Method || Same as length function
        System.out.println(list.size()); // 5
        // print the ArrayList
        for(int i = 0; i< list.size(); i++){
            System.out.println("Element = "+list.get(i));
        }

        // find maximum in arrayList
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++){
            if(max < list.get(i)){
                max = list.get(i);
            }
        }
        System.out.println("Max Value = "+max);

        // Swap 2 numbers
        int indx1 = 1, indx2 = 3;
        swapIndex(list, indx1, indx2);
        System.out.println(list);

        // Sorting
        System.out.println(list);
        Collections.sort(list); // ascending order
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // Multi Dimenstional ArrayList
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); 
        list1.add(2);
        mainList.add(list1);
        System.out.println(mainList);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3); 
        list2.add(4);
        mainList.add(list2);
        System.out.println(mainList);
        
        // printinf the mainList manualy
        for(int i = 0; i < mainList.size(); i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0; j < currList.size(); j++){
                System.out.println("MainList Element At List "+i+" = "+currList.get(j));
            }
    
        }  
    }
}
