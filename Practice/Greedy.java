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

    // fractional Knapsak Problem
    public static int fractionalKnapsack(int[] values, int[] weights, int W){
        int n = weights.length;
        double[][] ratio = new double[n][2];
        for(int i = 0; i<n; i++){
            ratio[i][0] = i;
            ratio[i][1] = values[i]/(double)weights[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(a->a[1]));

        int ans = 0;
        int capacity = W;
        for(int i = n-1; i>=0; i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weights[idx]){
                capacity -= weights[idx];
                ans += values[idx];
            } else{
                ans += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        return ans;
    }
    
    public static int sumOfMaximumDifference(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int sumAbsDiff = 0;
        for(int i=0; i<A.length; i++){
            sumAbsDiff+=Math.abs(A[i]-B[i]);
        }

        return sumAbsDiff;
    }

    public static int longestChainPair(int[][] pairs){
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int count = 1;
        int endPair = pairs[0][1];
        System.err.print("Pairs = (" + pairs[0][0] + ", " +pairs[0][1] + ") ");
        for(int i = 1; i<pairs.length; i++) {
            int tempPair = pairs[i][0];
            if(tempPair >= endPair){
                count++;
                endPair = pairs[i][1];
                System.err.print("(" + pairs[i][0] + ", " + pairs[i][1] +") ");
            }
        }
        System.err.println();
        return count;
    }

    public static int indianCoins(int Value){
        int[] notes = {2000, 500, 100, 50, 20, 10, 5, 2, 1};
        int numNotes = 0;
        int idx = 0;
        while(Value > 0) {
            while(idx<notes.length){
                if(Value >= notes[idx]){
                    numNotes++;
                    Value -= notes[idx];
                    System.err.print(notes[idx] + " ");
                    break;
                }
                idx++;
            }
        }
        System.err.println();

        return numNotes;
    }

    public static int jobSequencingProblem(int[][] jobs){
        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1])); // sort by profit
        int maxJob = 1;
        int startTime = jobs[0][0];
        System.err.print("jobs done = (" + jobs[0][0] + ", " + jobs[0][1] + ") ");
        for(int i=jobs.length-1; i>=0; i--){
            if(jobs[i][0] > startTime){
                maxJob++;
                startTime = jobs[i][0];
                System.err.print("(" + jobs[i][0] + ", " + jobs[i][1] + ") ");
            }
        }
        System.err.println();
        return maxJob;
    }
    public static int chocolaProblem(Integer[] verticalCost, Integer[] horizontalCost){
        int m = verticalCost.length;
        int n = horizontalCost.length;

        Arrays.sort(verticalCost, Comparator.reverseOrder());
        Arrays.sort(horizontalCost, Comparator.reverseOrder());

        int hc = 0, vc = 0;
        int hp = 1, vp = 1;
        int totalCost = 0;
        while(hc < n && vc < m) { // n = horizontal.length, m = vertical.length
            if(verticalCost[vc] <= horizontalCost[hc]){ // horizontal cut
                totalCost += horizontalCost[hc]*vp;
                hp++;
                hc++;
            } else{ // vertical cut
                totalCost += verticalCost[vc]*hp;
                vp++;
                vc++;
            }
        }
        while(hc < n) {
            totalCost += horizontalCost[hc]*vp;
            hp++;
            hc++;
        }
        while(vc < m){
            totalCost += verticalCost[vc]*hp;
            vp++;
            vc++;
        }
        return totalCost;
    }
    public static void main(String[] args) {
        // System.out.println("Hello");
        // int[] start = {1, 3, 0, 5, 8, 5};
        // int[] end = {2, 4, 6, 7, 9, 9};
        // System.out.println("Max Activities = "+maxActivitySelection(start,end));

        // int[] values = {60, 100, 120};
        // int[] weights= {10, 20, 30};
        // int W = 50;
        // System.out.println("Total Amount = " + fractionalKnapsack(values, weights, W));


        // int[] A = {4, 1, 8, 7};
        // int[] B = {2, 3, 6, 5};
        // System.err.println("Sum of Absolute Difference = "+ sumOfMaximumDifference(A, B));


        // int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        // System.err.println("Longest Chain Can Form = " + longestChainPair(pairs));


        // int price = 590;
        // System.err.println("Total Notes Required: " + indianCoins(price));

        // int[][] jobs = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        // System.err.println("Maximum job done = " + jobSequencingProblem(jobs));


        Integer[] verticalCost = {2, 1, 3, 1, 4};
        Integer[] horizontalCost = {4, 1, 2};

        System.err.println("Total Cost = "+chocolaProblem(verticalCost, horizontalCost));
    }
}