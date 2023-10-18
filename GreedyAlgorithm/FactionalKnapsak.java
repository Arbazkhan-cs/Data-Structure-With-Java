import java.util.*;
public class FactionalKnapsak {
    public static void main(String[] args) {
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};

        double[][] ratio = new double[values.length][2]; // 0=>idx, 1=>ratio
        for(int i = 0; i<values.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = values[i]/(double)weights[i];
        }

        // Sort According To Their Ratio: ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int res = 0;
        for(int i = ratio.length-1; i >= 0; i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weights[idx]){ // include full item
                res+=values[idx];
                capacity -= weights[idx];
            } else{
                // include fraction item
                res += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final Value = "+res);

    }
}
