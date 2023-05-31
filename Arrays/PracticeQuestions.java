public class PracticeQuestions {
    public static Boolean isDistinctArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static int SearchTarget(int arr[], int target){
        // Finding the minimum value in the arr
        int minValue = searchMin(arr);

        // Search Sorted Left
        if(arr[minValue] <= target && target <= arr[arr.length-1]){
            return searchingTarget(arr, minValue, arr.length-1, target);
        } 
        // Search Sorted Right
        else {
            return searchingTarget(arr, 0, minValue, target);
        }
    }

    // Here we are search our tareget based on above situation.
    public static int searchingTarget(int arr[], int left, int right, int target){
        int low = left;
        int heigh = right;
        while(low<=heigh){
            int mid = low + (heigh-low)/2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] > target){
                heigh = mid-1;
            } else{
                low = mid+1;
            }
        }

        return -1;
    }

    // Here we finding the minimum
    public static int searchMin(int arr[]){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(mid>0 && arr[mid-1] > arr[mid]){
                return mid;
            } else if(arr[left] <= arr[mid] && arr[mid] > right){
                left = mid+1;
            } else{
                right = mid-1;
            }
        }
        return left;
    }
    public static void main(String args[]){
        // Question 1: Is all elements are distinct?
        // int arr[] = {1, 2, 3, 1};
        // boolean result = isDistinctArr(arr);
        // System.out.println(result);


        // Question 2: Search the target with O(logn) time complexity.
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        System.out.println(SearchTarget(arr, target));
    }   
}
