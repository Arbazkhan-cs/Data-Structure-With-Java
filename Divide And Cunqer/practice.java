
public class practice{
    // Merge Sort =================================================
    public static void mergeSort(int arr[], int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int arr[], int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while(i<=mid && j<=right){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=right){
            temp[k++] = arr[j++];
        }

        // Copying to original array
        for(k = 0, i = left; k < temp.length; i++, k++){
            arr[i] = temp[k];
        }
    }

    // Quick Sort =============================================\
    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pIdx = partition(arr, si , ei);
        quickSort(arr, si, pIdx-1); // left part
        quickSort(arr, pIdx+1, ei); // right part
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i=si-1;
        for(int j = si; j < ei; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp; 
    }

    // Sorted And Rotated Array
    public static int SortedAndRotated(int[] arr, int si, int ei, int target){
        if(si > ei){
            return -1;
        }

        int mid = si + (ei - si);
        if(arr[mid] == target){
            return mid;
        }

        // line 1
        if(arr[si] <= arr[mid]){
            if(arr[mid] >= target && arr[si] <= target){
                return SortedAndRotated(arr, si, mid-1, target);
            } else{
                return SortedAndRotated(arr, mid+1, ei, target);
            }
        }

        // line 2
        else{
            if(arr[mid] <= target && arr[ei] >= target){
                return SortedAndRotated(arr, mid+1, ei, target);
            }
            else{
                return SortedAndRotated(arr, si, mid-1, target);
            }
        }
    }


    public static void display(int arr[]){
        System.out.print("Array = [ ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        int arr[] = {7, 8, 9, 5, 4, 3};
        System.out.println(SortedAndRotated(arr, 0, arr.length-1, 8));
    }
}