import java.util.*;
public class IndianCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 590;

        int totalCoins = 0;
        int i = coins.length - 1;
        while(value > 0){
            if(value >= coins[i]){
                int numCoins = value / coins[i];
                totalCoins += numCoins;
                value -= numCoins * coins[i];
            }
            else{
                i--;
            }
        }

        System.out.println(totalCoins);
    }
}
