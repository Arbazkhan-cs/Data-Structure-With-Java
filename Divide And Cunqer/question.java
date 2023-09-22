public class question {
    public static void mergeSort(String arr[], int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(String[] arr, int left, int mid, int right){
        String[] temp = new String[right - left + 1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= right){
            if(arr[i].compareTo(arr[j]) <= 0){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
            temp[k++] = arr[j++];
        }

        for(k=0, i=left; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void display(String[] str){
        System.out.print("Array = [ ");
        for(int i = 0; i<str.length; i++){
            System.out.print(str[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String args[]){
        String[] str = {"sun", "mercury", "earth", "mars"};
        display(str);
        mergeSort(str, 0, str.length-1);
        display(str);
    }
}
