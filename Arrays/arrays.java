import java.util.*;
public class arrays{
    public static void display(int arr[]){
        System.out.print("Array = [");
        for(int i=0; i<arr.length; i++){  // array.length function is used to find the length of the array.
            System.out.print(" "+ arr[i]);
        }
        System.out.println("]");
    }

    public static void main(String args[]){
        // Array declaration
        // int arr[] = new int[20];  // Method 1
        // int arr[] = {1, 2, 3};   // Method 2
        // String arr[] = {"arbaz", "khan", "imran"};
    


        // // Array Input, Output and update. ===========================================================================
        // int arr[] = new int[100];  // Array declaration
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter Your Maths Marks = ");
        // arr[0] = sc.nextInt();   // Input
        // System.out.print("Enter Your Physics Marks = ");
        // arr[1] = sc.nextInt();
        // System.out.print("Enter Your Chemestry Marks = ");
        // arr[2] = sc.nextInt();

        // System.out.println("Maths Marks = "+arr[0]);   // Output
        // System.out.println("Physics Marks = "+arr[1]);
        // System.out.println("Chemestry Marks = "+arr[2]);

        // arr[0] = arr[0]+5; // Update
        // System.out.println("Maths Marks After Update = "+arr[0]);



        // Passing the array to the function.==============================================================================
        int arr[] = {1, 2, 3, 4, 5};
        display(arr);  // Passing the array, the array are always pass by reference.
    }
}