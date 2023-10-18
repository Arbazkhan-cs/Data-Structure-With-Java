import java.util.ArrayList;
import java.util.*;
public class ActivitySelection {
    public static ArrayList maximumActivity(int[] start, int[] end){
        // Approach: 1). Sort according to the end time
        //           2). Always Select The First Activity A0
        //           3). non-overlaping (start time >= last choosen time)

        // If our start time was sorted than we have to sort it again according to the End Time
        int[][] Activities = new int[start.length][3]; // index start end
        for(int i=0; i<start.length; i++) {
            Activities[i][0] = i;
            Activities[i][1] = start[i];
            Activities[i][2] = end[i];
        }
        // Sort by end time
        // Lambda Function: Same as python
        Arrays.sort(Activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        int lastActivity = Activities[0][2];
        ans.add(Activities[0][0]);
        for(int i = 1; i<start.length; i++){
            if(Activities[i][1] >= lastActivity){
                lastActivity = Activities[i][2];
                ans.add(Activities[i][0]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        // Activity Selection (End time is sorted)
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        

        System.out.println("Maximum Activities = "+maximumActivity(start, end));

        // System.out.println("Hello");
    }    
}
