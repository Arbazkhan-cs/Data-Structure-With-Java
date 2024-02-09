import java.util.*;

public class Greedy{
    public static int maxActivitySelection(int[] start, int[] end){
        // if array is not sorted according to the ending time
        int[][] activities = new int[start.length][3];
        for (int i=0;i<start.length;i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // labda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));


        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(activities[0][0]);
        int maxCount = 1; // Atleast 1 activity will be there in the selection

        int startTime = 1; // first Activity is already Selected
        int endTime = 0; // end time of first activity
        while(startTime < activities.length){
            if(activities[startTime][1] >= activities[endTime][2]){
                ans.add(activities[startTime][0]);
                endTime = startTime;
                maxCount++;
            }
            startTime++;
        }

        System.out.print("Activities Selected = ");
        for(int i = 0; i<maxCount; i++){
            System.err.print("A"+ans.get(i)+" ");
        }
        System.out.println();
        return maxCount;
    }
    public static void main(String[] args) {
        // System.out.println("Hello");
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println("Max Activities = "+maxActivitySelection(start,end));

    }
}