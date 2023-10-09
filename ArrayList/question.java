import java.util.*;
public class question {
    public static int ContainerWithMostWater(ArrayList<Integer> container, int left, int right){
        int mostWater = Integer.MIN_VALUE;
        while(left<right){
            int width = right - left;
            int height = Math.min(container.get(left), container.get(right));
            int water = width * height;
            if(mostWater < water){
                mostWater = water;
            }

            if(container.get(left) < container.get(right)){
                left++;
            } else{
                right--;
            }
        }

        return mostWater;
    }
    public static void main(String args[]){
        // container with most water
        ArrayList<Integer> container = new ArrayList<>();
        container.add(1);
        container.add(8);
        container.add(6);
        container.add(2);
        container.add(5);
        container.add(4);
        container.add(8);
        container.add(3);
        container.add(7);

        System.out.println("Most Water = "+ContainerWithMostWater(container, 0, container.size()-1));
    }

}
