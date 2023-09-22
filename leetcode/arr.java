import java.util.*;
public class arr {
    public static void main(String[] args) {
        int nums[] = {3, 2, 3};
        int target = 6;
        int arr[] = {0, 0};
        for(int i = 0, j=0; i<arr.length; i++){
            int val = target - nums[i];
            int low = 0;
            int heigh = nums.length - 1;


            if(nums[i] == val && i == j){
                continue;
            }

            while(low<=heigh){
                int mid = low + (heigh-low)/2;
                if(nums[mid] == val){
                    arr[0] = i;
                    arr[1] = mid;
                    break;
                } else if(nums[mid] > val){
                    heigh = mid-1;
                } else{
                    low = mid+1;
                }
            }
        }
        System.out.println(arr[0] + " " + arr[1]);
    }
}
