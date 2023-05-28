import java.util.*;
public class javaProg{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The number of rows: ");
        int n = sc.nextInt();
        
        // // Right Trangular Pattern (Default)
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<=i; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }



        // Inverse of Right triangular pattern
        // for(int i=n; i>0; i--){   // Method 1
        //     for(int j=0; j<i; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // for(int i=0; i<n; i++){  // Method 2
        //     for(int j=0; j<n-i; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }



        // Right triangular pattern with number
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }



        // Right triangular pattern with alphabets
        // char alpha = 'A';
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<=n; j++){
        //         System.out.print(alpha+" ");
        //         alpha++;
        //     }
        //     System.out.println();
        // }




        // // Advane Square Pattern (Frame)
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         if(i==0 || i==n-1){
        //             System.out.print("* ");
        //         }else if(j==n-1||j==0){
        //             System.out.print("* ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }
    }
}