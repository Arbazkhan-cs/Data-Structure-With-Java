public class SortedRotetedArray{
    public static int searchInSortRotateArray(int arr[], int target, int si, int ei){
        if(si>ei){
            return -1;
        }

        int mid = si + (ei-si)/2;
        if(arr[mid] == target){
            return mid;
        }

        // Line 1
        if(arr[si] <= arr[mid]){
            // Case1: Left part
            if(arr[si] <= target && target <= arr[mid]){
                return searchInSortRotateArray(arr, target, si, mid-1);
            }
            // Case2: Right part
            else{
                return searchInSortRotateArray(arr, target, mid+1, ei);
            }
        }

        // Line 2
        else{
            // Case1: Right part
            if(arr[mid] <= target && target <= arr[ei]){
                return searchInSortRotateArray(arr, target, mid+1, ei);
            }
            // Case2: Left part
            else{
                return searchInSortRotateArray(arr, target, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int index = searchInSortRotateArray(arr, 0, 0, arr.length-1);
        System.out.println(index);
    }
}