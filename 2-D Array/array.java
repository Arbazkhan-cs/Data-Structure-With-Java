import java.util.*;
public class array{
    public static void display(int arr[][]){
        System.out.println("\nArray = [");
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    public static void searchMax(int arr[][]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(max<arr[i][j]){
                    max = arr[i][j];
                }
            }
        }

        System.out.println("Largest Number In The Array = "+max);
    }
    public static void main(String args[]){
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The 2-D Array Elements:");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        display(matrix);
        searchMax(matrix);
    }
}