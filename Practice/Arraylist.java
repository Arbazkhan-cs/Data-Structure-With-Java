import java.util.ArrayList;
import java.util.Collections;
public class Arraylist {
    public static void Swap(ArrayList<Integer> list, int idx1, int idx2){
        Integer temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static int containerWithMaxWater(ArrayList<Integer> height){
        int low = 0;
        int high = height.size()-1;
        int maxWater = 0;
        while(low<high){
            int currWater = 0;
            if(height.get(low) < height.get(high)){
                // left bar is small
                currWater = (high-low) *  height.get(low);
                low++;
            } else {
                // right bar is smaller
                currWater = (high-low) * height.get(high);
                high--;
            }
            maxWater = Math.max(maxWater, currWater);
        }
        System.out.println("Maximum Water Container Can Contains = "+maxWater);
        return maxWater;
    }
    public static boolean paiSum(ArrayList<Integer> list, int target){
        int low = 0;
        int high = list.size()-1;
        while(low<high){
            int sum = list.get(low)+list.get(high);
            if(sum == target){
                System.out.println("Pair: (" + list.get(low) + ", " + list.get(high)+ ")");
                return true;
            }
            if(sum>target){
                high--;
            } else{
                low++;
            }
        }
        System.out.println("Pair does not exist");
        return false;
    }
    // pair sum 2 sorted and rotated array search
    public static int pivot(ArrayList<Integer> list){
        for(int i = 1; i<list.size(); i++){
            if(list.get(i-1) > list.get(i)){
                return i;
            }
        }
        return -1;
    }
    public static boolean pairSum2SortRotatedArray(ArrayList<Integer> list, int target){
        int low = pivot(list);
        int high = low-1;
        int n = list.size();

        while(low != high){
            int sum = list.get(low) + list.get(high);
            if(sum == target){
                System.out.println("Pair: ("+list.get(low)+", "+list.get(high)+")");
                return true;
            } else if(sum > target){
                high = (n+high-1) % n;
            } else{
                low = (low+1)%n;
            }
        }
        System.out.println("Pair does not exist");
        return false;
    }
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // // add - O(1)
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(5);
        // System.out.println(list);

        // // get - O(1)
        // int elem = list.get(3);
        // System.out.println("Element at index 3: " + elem);
        
        // // remove - O(n)
        // elem = list.remove(2);
        // System.out.println("Removed element: " + elem);

        // // insert - O(n)
        // list.add(2, 4);
        // System.out.println(list);

        // // change element (set) - O(n)
        // list.set(0, 9);
        // System.out.println("Changed the first element to 9: " + list);

        // // contains element - O(n)
        // System.err.println(list.contains(3) + " " + list.contains(4));

        // // Swap elements
        // int idx1 = 0;
        // int idx2 = 2;
        // Swap(list, idx1, idx2);
        // System.out.println(list);

        // // Sorting
        // System.out.println("List Before Sorting: "+list);
        // Collections.sort(list);
        // System.out.println("List After Sorting: "+list);

        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);


        // Multi Dimentional Array List - 2D ArrayList
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> List1 = new ArrayList<>();
        // ArrayList<Integer> List2 = new ArrayList<>();
        // ArrayList<Integer> List3 = new ArrayList<>();
        // for(int i = 1; i<=5; i++){
        //     List1.add(i);
        //     List2.add(i+5);
        //     List3.add(i-1);
        // }
        // mainList.add(List1);
        // mainList.add(List2);
        // mainList.add(List3);
        // System.out.println(mainList);

        // for(int i = 0; i<mainList.size(); i++){
        //     System.out.print("[");
        //     for(int j = 0; j<mainList.get(i).size(); j++){
        //         int elem = mainList.get(i).get(j);
        //         System.out.print(elem+ " ");
        //     }
        //     System.out.println("]");
        // }



        // // Container With Max Water
        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // containerWithMaxWater(height);



        // Pair Sum 1
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // Collections.sort(list);

        // paiSum(list, 5);


        // pair sum 2
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        
        pairSum2SortRotatedArray(list, 16);
    }
}
