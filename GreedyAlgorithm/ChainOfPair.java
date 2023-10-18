import java.util.*;
public class ChainOfPair {
    public static void main(String[] args) {
        int[][] pairs = {
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40},
            {50, 90}
        };

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int totalChain = 1;
        int PairEnd = pairs[0][1];

        for (int i=1;i<pairs.length;i++) {
            if(pairs[i][0] >= PairEnd){
                totalChain+=1;
                PairEnd = pairs[i][1];
            }
        }

        System.out.println(totalChain);
        
    }
}