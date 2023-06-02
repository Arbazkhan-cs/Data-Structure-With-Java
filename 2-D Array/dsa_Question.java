public class dsa_Question{
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

    public static void spiralMatrix(int arr[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = arr.length-1;
        int endCol = arr[0].length-1;

        // System.out.println(arr[0].length);
        while(startRow<=endRow && startCol<=endCol){
            // Top
            for(int j = startCol; j<=endCol; j++){
                System.out.print(arr[startRow][j] + " ");
            }

            // Right
            for(int i = startRow+1; i<=endRow; i++){
                System.out.print(arr[i][endCol] + " ");
            }

            // Bottom
            for(int j = endCol-1; j>=startRow; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(arr[endRow][j] + " ");
            }

            // Left
            for(int i = endRow-1; i>=startRow+1; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(arr[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void sumOfDiagonal(int arr[][]){
        int sum=0;
        // bruot force. timecomplexity O(n^2)
        // for(int i=0; i<arr.length; i++){
        //     for(int j=0; j<arr[0].length; j++){
        //         if(i==j){
        //             sum += arr[i][j];
        //         }
        //         else if(i+j == arr.length-1){
        //             sum+= arr[i][j];
        //         }
        //     }
        // }


        // O(n)
        for(int i=0; i<arr.length; i++){
            // primary diagonal
            sum += arr[i][i];

            // Secondary diagonal
            if(i != arr.length-i-1){
                sum += arr[i][arr.length-i-1];
            }
        }
        System.out.println(sum);
    }

    public static void staircaseSearch(int arr[][], int key){
        int top = arr.length-1, right = 0;
        while(top>=0 && right<arr[0].length){
            if(arr[top][right] == key){
                System.out.println(key+" Found at = ("+top+", "+right+")");
                return;
            } else if(arr[top][right] > key){
                top--;
            } else {
                right++;
            }
        }

        System.out.println("Not Found");
    }
    public static void main(String args[]){
        int arr[][] = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };

        // spiralMatrix(arr);
        // sumOfDiagonal(arr);


        // From My Point Of View
        // int n = arr.length;
        // int start = 0;
        // int end = arr[0].length-1;
        // int sum = 0;
        
        // int i=0;
        // while(i<n/2){
        //     sum += arr[i][start] + arr[i][end];
        //     start++;
        //     end--;
        //     i++;
        // }

        // int j = n/2;
        // while(j<n){
        //     sum += arr[j][start]+arr[j][end];
        //     start--;
        //     end++;
        //     j++;
        // }
        // System.out.println(sum);
        


        // Searchin in matrix by brutforce O(n^2)
        // int key = 12; 
        // for(int i = 0; i<arr.length; i++){
        //     for(int j = 0; j<arr[0].length; j++){
        //         if(arr[i][j] == key){
        //             System.out.println("Found At = ("+i+", "+j+")");
        //             break;
        //         }
        //     }
        // }

        // Best Algorithm
        int key = 30;
        staircaseSearch(arr, key);
        
    }
}