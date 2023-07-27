import java.util.*;

public class BuyAndSellStock {
    public static int MaximizeProfit(int prices[]){
        // Buy Price insitialising with the maximum value;
        int BuyPrice = Integer.MAX_VALUE;

        // Firstly profit will be equals to 0
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            // Comparing Buy Price with Selling price
            if(BuyPrice < prices[i]){  // prices[i] = selling price
                int profit = prices[i] - BuyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else{
                BuyPrice = prices[i];
            }
        }

        return maxProfit;
    }
    public static void main(String args[]){
        int prices[] = {7, 1, 5, 3, 6, 4};
        int Profit = MaximizeProfit(prices);
        System.out.println(Profit);
    }
}
