public class practice {
    // Simple Concept
    public static void setArray(int arr[], int i){
        if(i == arr.length){
            display(arr);
            return;
        }
        arr[i] = i+1;
        setArray(arr, i+1);
        arr[i] = arr[i] - 2;
    }

    // Subsets ========================================================================
    public static void printSubset(String str, String subStr, int i){
        // base case
        if(i == str.length()){
            if(subStr.length() == 0){
                System.out.print("null");
            } else{
                System.out.print(subStr+" ");
            }
            return;
        }

        // If char want to add into the substr
        printSubset(str, subStr + str.charAt(i), i+1);

        // If char not want to add into the substr
        printSubset(str, subStr, i+1);
    }

    // Permutation =====================================================================
    public static void stringPermutation(String str, String permStr){
        // base case
        if(str.length() == 0){
            System.out.println(permStr);
        }

        // calls
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);

            stringPermutation(newStr, permStr+ch);
        }
    }

    // nQueens ==========================================================
    public static boolean isSafe(char board[][], int row, int col){
        // vertical
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // left diagonal
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // right diagonal
        for(int i = row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][], int row){
        // base case
        if(board.length == row){
            printBoard(board);
            return;
        }

        // columns
        for(int j = 0; j< board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
        }
    }

    // grid ==============================================================
    public static int grid(int i, int j, int m, int n){
        if(i == m-1 && i == n-1){
            return 1;
        }
        else if(i == m || j == n){
            return 0;
        }

        int way1 = grid(i, j+1, m, n);
        int way2 = grid(i+1, j, m, n);
        return way1 + way2;
    }
    public static void printBoard(char board[][]){
        System.out.println("==== Chess Board ======");
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // sudoku solver
    public static boolean isSafeSudoku(int board[][], int row, int col, int digit){
        // vertical
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == digit){
                return false;
            }
        }
        // horizontal
        for(int j = 0; j<board.length; j++){
            if(board[row][j] == digit){
                return false;
            }
        }
        
        // 3X3 grid
        int stRow = (row/3)*3;
        int stCol = (col/3)*3;

        for(int i = stRow; i<stRow+3; i++){
            for(int j = stCol; j< stCol; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolver(int board[][], int row, int col){
        // basecase
        if(row == 9){
            return true;
        }

        // New Row And Col
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        // solving
        if(board[row][col] != 0){
            return sudokuSolver(board, nextRow, nextCol);
        }

        for(int digit = 1; digit<=9; digit++){
            if(isSafeSudoku(board, row, col, digit)){
                board[row][col] = digit;
                if(sudokuSolver(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = 0;
            } 
        }
        
        return false;
    }
    public static void printSudoku(int board[][]){
        System.out.println("==== Sudoku Board ======");
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // display ==================================================================
    public static void display(int arr[]){
        System.out.print("Array = [ ");
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String args[]){
        // int[] arr = new int[5];
        // setArray(arr, 0);
        // display(arr);

        // printSubset("abc", "", 0);

        // stringPermutation("abc", "");

        // nQueens
        // int n = 4;
        // char[][] board = new char[n][n];
        // // initializing the board
        // for(int i = 0; i< board.length; i++){
        //     for(int j = 0; j< board.length; j++){
        //         board[i][j] = 'x';
        //     }
        // }
        // nQueens(board, 0);

        // grid ways
        // System.out.println(grid(0, 0, 3, 3));

        // Sudoku Solver
        int[][] board1 = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if(sudokuSolver(board1, 0, 0)){
            printSudoku(board1);
        } else{
            System.out.println("Solution Not Exist");
        }
            
    }    
}
