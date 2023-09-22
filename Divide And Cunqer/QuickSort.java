public class QuickSort{
    public static void quickSort(int arr[], int si, int ei){
        // if(si >= ei){   
        //     return;
        // }
        // int pivot = arr[ei];
        // int i = si-1;
        // int j;
        // for(j = si; j<ei; j++){
        //     if(arr[j] <= pivot){
        //         i++;
        //         swap(arr, j, i);
        //     }
        // } 
        // i++;
        // swap(arr, j, i);
        // pivot = i;

        // quickSort(arr, si, pivot-1);
        // quickSort(arr, pivot+1, ei);


        // Let's create another function for the partition and than sort
        if(si>=ei){
            return;
        }
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx-1);
        quickSort(arr, pIdx+1, ei);
    }
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si - 1;

        for(int j = si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, j, i);
            }
        }
        i++;
        swap(arr, ei, i);

        return i;
    }
    public static void swap(int arr[], int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void display(int arr[]){
        System.out.print("Array = [ ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        int arr[] = {6, 3, 9, 8, 2, 5};
        display(arr);
        quickSort(arr, 0, arr.length-1);
        display(arr);
    }

}