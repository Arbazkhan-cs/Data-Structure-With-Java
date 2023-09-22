public class merging {
    public static void mergesort(int arr[], int low, int heigh){
        if(low < heigh){
            int mid = low + (heigh - low)/2;
            mergesort(arr, low, mid);
            mergesort(arr, mid+1, heigh);
            merge(arr, low, mid, heigh);
        }
    }

    public static void merge(int arr[], int low, int mid, int heigh){
        int n1 = mid - low + 1;
        int n2 = heigh - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];

        int i, k, j;
        for(i = 0; i<n1; i++){
            L[i] = arr[low+i];
        }
        for(j = 0; j<n2; j++){
            R[j] = arr[mid+j+1];
        }

        i = 0;
        j = 0;
        k = low;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void display(int arr[]){
        System.out.print("Array = [ ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        int arr[] = {19, 6, 82, 8, 9, 3, 5};
        int n = arr.length - 1;
        display(arr);
        mergesort(arr, 0, n);
        display(arr);
    } 
}
