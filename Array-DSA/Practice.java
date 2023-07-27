import java.util.*;

public class Practice {
    public static int WaterTraped(int height[], int width){
        int n = height.length;

        // Left Bar
        int leftBar[] = new int[n];
        leftBar[0] = height[0];
        for(int i=1; i<n; i++){
            leftBar[i] = Math.max(height[i], leftBar[i-1]);
        }

        // Right Bar
        int RightBar[] = new int[n];
        RightBar[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            RightBar[i] = Math.max(height[i], RightBar[i+1]);
        }

        // Now Traped Water = 
        int trapedWater = 0;
        for(int i = 0; i<n; i++){
            int waterLevel = Math.min(leftBar[i], RightBar[i]);
            trapedWater += (waterLevel - height[i]) * width;
        }

        return trapedWater;
    }
    public static void main(String args[]){
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        int TrapedWater = WaterTraped(height, 1);
        System.out.println(TrapedWater); 
    }
}
