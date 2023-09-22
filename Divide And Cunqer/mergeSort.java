public class mergeSort {
    public static void mergedSort(int arr[], int low, int heigh){
        if(low >= heigh){
            return;
        }
        int mid = low + (heigh - low)/2;
        mergedSort(arr, low, mid);
        mergedSort(arr, mid+1, heigh);
        merge(arr, low, mid, heigh);
    }
    public static void merge(int arr[], int low, int mid, int heigh){
        // Old code....
        // int n1 = mid - low +1;
        // int n2 = heigh - mid;

        // int L[] = new int[n1];
        // int R[] = new int[n2];

        // int i, j, k;

        // for(i = 0;  i < n1; i++){
        //     L[i] = arr[low + i];
        // }
        // for(j = 0; j < n2; j++){
        //     R[j] = arr[mid+1+j];
        // }

        // i = 0;
        // j = 0;
        // k = low;

        // while(i < n1 && j < n2){
        //     if(L[i] < R[j]){
        //         arr[k] = L[i];
        //         i++;
        //     }
        //     else{
        //         arr[k] = R[j];
        //         j++;
        //     }
        //     k++;
        // }

        // while(i < n1){
        //     arr[k] = L[i];
        //     i++;
        //     k++;
        // }

        // while(j < n2){
        //     arr[k] = R[j];
        //     j++;
        //     k++;
        // }



        // More efficient Code
        int temp[] = new int[heigh - low + 1];
        int i = low; // iterator for left part
        int j = mid + 1;  // iterator for right part
        int k = 0;  // iterator for temp array

        
        while(i <= mid && j <= heigh){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else{
                temp[k++] = arr[j++];
            }
        }



        // Left part
        while(i <= mid){
            temp[k++] = arr[i++];
        } 
        // Right Part
        while(j <= heigh){
            temp[k++] = arr[j++];
        }


        // copy temp array to original array
        for(k = 0, i = low; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void display(int arr[]){
        System.out.print("Array = [ ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        int arr[] = {5, 2, 3, 1, 4, 6, 7};
        display(arr);
        mergedSort(arr, 0, arr.length - 1);
        display(arr);
    }
}
