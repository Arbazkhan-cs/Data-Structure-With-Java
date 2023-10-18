import java.util.*;
public class MinAbsoluteDiffernece {
    public static void main(String[] args) {
        // System.out.println("hello");
        int nums1[] = {4, 1, 8, 7};
        int nums2[] = {2, 3, 6, 5};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int res = 0;
        for(int i = 0; i<nums1.length; i++){
            int absValue = Math.abs(nums1[i] - nums2[i]);
            res += absValue;
        }
        System.out.println(res);
    }
}