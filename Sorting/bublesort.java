public class bublesort {

    public static void BubleSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int swaps = 0;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swaps++;
                }
            }

            if(swaps == 0){
                break;
            }
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
        int arr[] = {5, 4, 3, 2, 1};
        display(arr);
        BubleSort(arr);
        display(arr);
    }
}
