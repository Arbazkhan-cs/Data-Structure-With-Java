class DivideAndQuanqer{
    // =============================== Merge Sort ===============================================
    public static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = low + (high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            } else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=high){
            temp[k++] = arr[j++];
        }

        for(k = 0, i=low; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }
    // ========================================== Quick Sort =======================================
    public static void QuickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low , high);
            QuickSort(arr, low, pivotIndex-1);
            QuickSort(arr, pivotIndex+1, high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // last element as pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, high, i);
        return i;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // ========================================== Search in Rotated and Sorted array=======================
    public static int searchInRotatedSortedArray(int[] arr, int low, int high, int target){
        if(low>high){
            return -1;
        }
        int mid = low + (high-low)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[low] <= arr[mid]){ // line 1
            if(target >= arr[low] && target <= arr[mid]){
                return searchInRotatedSortedArray(arr, low, mid-1, target);
            } else{
                return searchInRotatedSortedArray(arr, mid+1, high, target);
            }
        } else{
            if(target > arr[mid] && target<=arr[high]){
                return searchInRotatedSortedArray(arr, mid+1, high, target);
            } else{
                return searchInRotatedSortedArray(arr, low, mid-1, target);
            }
        }
    }
    public static void display(int[] arr){
        System.err.print("Array = [");
        for(int i = 0; i<arr.length; i++){
            System.err.print(arr[i]+" ");
        }
        System.err.println("]");
    }
    public static void main(String[] args) {
        System.err.println("Hello World");
        int[] arr = {5, 9, 3, 1, 2, 4};
        display(arr);
        mergeSort(arr, 0, arr.length-1);
        display(arr);
        
        int[] arr2 = {5, 9, 3, 1, 2, 4};
        display(arr2);
        QuickSort(arr2, 0, arr2.length-1);
        display(arr2);

        int[] arr3 = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int res = searchInRotatedSortedArray(arr3, 0, arr3.length, target);
        System.err.println(res);
    }
}