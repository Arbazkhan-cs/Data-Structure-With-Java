public class insertionsort {
    public static void InsertionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int temp = arr[i+1];
            int j = i;

            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
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
        InsertionSort(arr);
        display(arr);
    }
    
    
}
