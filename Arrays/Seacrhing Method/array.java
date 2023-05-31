import java.util.*;
public class array {
    public static void display(int arr[]){
        System.out.print("Array = [");
        for(int i=0; i<arr.length; i++){
            System.out.print(" "+ arr[i]);
        }
        System.out.println(" ]");
    }

    public static int linearSeacrh(int arr[], int k){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int k){
        int low = 0;
        int heigh = arr.length-1;
        while(low<=heigh){
            int mid = low+(heigh-low)/2;
            if(arr[mid] == k){
                return mid;
            }
            else if(arr[mid] > k){
                heigh = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }

    public static void reverseArr(int arr[]){
        int low = 0;
        int heigh = arr.length-1;
        while(low<heigh){
            int temp = arr[low];
            arr[low] = arr[heigh];
            arr[heigh] = temp;
            low++;
            heigh--;
        }
        display(arr);
    }

    public static void printPairs(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("("+arr[i]+", "+arr[j]+") ");
            }
            System.out.println();
        }
        System.out.println("Total Pairs = "+(arr.length*(arr.length-1))/2);
    }

    public static void printSubArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void maxSumSubArr_bruto(int arr[]){
        int max_sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");
                    sum += arr[k];
                }
                if(max_sum < sum){
                    max_sum = sum;
                }
                System.out.print("Sum = "+sum);
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total Sub Arrays = "+(arr.length*(arr.length+1))/2);
        System.out.println("Maximum Sum of the Sub Array = "+max_sum);
    }

    public static void optiMaxSumSubArr_kadans(int arr[], int start, int end){
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=start; i<=end; i++){
            sum += arr[i];

            if(sum < 0){
                sum = 0;
                continue;
            }
            
            if(max_sum < sum){
                max_sum = sum;
            }
        }
        System.out.println("Max Sum  = "+max_sum);
    }
    public static void main(String args[]){
        // int arr[] = {2, 4, 6, 8, 10, 12, 14};
        // int k = 10;
        
        // int index = linearSeacrh(arr, k);
        // if(index == -1){
        //     System.out.println("Number not found");
        // } else {
        //     System.out.println("Number is at index = "+index);
        // }


        // Problem Question: Find the largest number in an array.
        // int arr[] = {2, 9, 37, 28, 12, 34};
        // int max = arr[0];
        // for(int i=0; i<arr.length; i++){
        //     if(arr[i]>max){
        //         max = arr[i];
        //     }
        // }
        // display(arr);
        // System.out.println("Largest Number in the array is = "+max);




        // Binary Search.
        // int arr[] = {2, 4, 6, 8, 10, 12, 14};
        // int k=10;

        // int index = binarySearch(arr, k);
        // if(index == -1){
        //     System.out.println("Number Not Found!!!");
        // } else {
        //     System.out.println("Number Found At Index = "+index);
        // }



        // // Reverse Of An Array.
        // int arr[] = {1, 2, 3, 4, 5, 6};
        // display(arr);
        // reverseArr(arr);



        int arr[] = {1, -2, 6, -1, 3};  
        // printPairs(arr);  // Array Pairs
        // printSubArr(arr);  // Sub Arrays
        // maxSumSubArr_bruto(arr);  // Maximum Sum Of Sub Array.
        display(arr);
        optiMaxSumSubArr_kadans(arr, 0, 4);
    }   

    
}
