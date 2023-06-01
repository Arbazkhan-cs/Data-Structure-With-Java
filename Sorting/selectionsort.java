public class selectionsort {
    public static void SelectionSort(int arr[]){
        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }

            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            // display(arr);
        }
    }

    public static void display(int arr[]){
        System.out.print("Array = [ ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        int arr[] = {84, 94, 38, 75, 02, 1, 88};
        display(arr);
        SelectionSort(arr);
        display(arr);
    }
}
