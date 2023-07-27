import java.util.*;

public class TrapingRainWater {
    public static int trapingRainWater(int height[], int width){
        // Numbers of bar in the height arrray
        int n = height.length;

        // Create Left Max Bar
        int leftMaxBar[] = new int[n];

        leftMaxBar[0] = height[0];  // As first bar is a heighest max bar.
        for(int i=1; i<n; i++){
            // Checking the Max of current bar with it's previous Left bar And then string the max from them.
            leftMaxBar[i] = Math.max(height[i], leftMaxBar[i-1]);  
        }

        // Create Right Max Bar
        int rightMaxBar[] = new int[n];

        rightMaxBar[n-1] = height[n-1];  // As Last bar will be the right max bar
        for(int i=n-2; i>=0; i--){
            // Checking the Max of current bar with it's previous Right bar And then string the max from them.
            rightMaxBar[i] = Math.max(height[i], rightMaxBar[i+1]);
        }

        // Finding the total Water Stored
        int totalWater = 0;
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(leftMaxBar[i], rightMaxBar[i]);  // Finding the water level Bar for each bar
            totalWater += (waterLevel - height[i]) * width;  // Now finding the waterlevel and adding in the totalWater.
        }

        return totalWater;
    }

    public static void main(String args[]){
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int totalWaterLevel = trapingRainWater(height, 1);
        System.out.println(totalWaterLevel);
    }
}
