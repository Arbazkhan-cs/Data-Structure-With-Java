class Backtracking{
    public static void PrintSubSets(String str, int idx, String subset){
        if(idx == str.length()){
            if(subset.length() == 0){
                System.err.println("null");
            }
            else{
                System.out.print(subset+" ");
            }
            return;
        }

        // choice 1 - Yes
        PrintSubSets(str, idx+1, subset + str.charAt(idx));
        // choice 2 - No
        PrintSubSets(str, idx+1, subset);
    }
    public static void PrintPermutation(String str, String perm){
        if(str.length() == 0){
            System.out.print(perm+" ");
            return;
        }

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i+1);
            PrintPermutation(Newstr, perm+c);
        }
    }
    // ================================================= NQueens =====================================
    public static boolean isSafe(int[][] board, int row, int col){
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 1){
                return false;
            }
        }
        // left upper diagonal
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        // right upper diagonal
        for(int i = row-1, j = col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
    public static void NQueens(int[][] board, int row){
        if(row == board.length){
            printChess(board);
            return;
        }
        for(int j = 0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 1;
                NQueens(board, row+1);
                board[row][j] = 0;
            }
        }
    }
    public static void printChess(int[][] board){
        System.err.println("\n============= board =============");
        for(int i=0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.err.println();
        }
    } 
    // ==================================== Grid Ways =======================================
    public static int gridWays(int row, int col, int M, int N){
        // baseCase
        if(row == M-1 && col == N-1){
            return 1;
        }
        if(row == M || col == N){
            return 0;
        }

        // kaam
        int ways1 = gridWays(row, col+1, M, N);
        int ways2 = gridWays(row+1, col, M, N);

        return ways1 + ways2;
    } 
    // =========================================== Suduku Solver =====================================
    public static boolean isSafe(int[][] board, int row, int col, int digit){
        // vertical
        for(int i = 0; i<board.length; i++){
            if(board[i][col] == digit){
                return false;
            }
        }
        // horizontal
        for(int i = 0; i<board[0].length; i++){
            if(board[row][i] == digit){
                return false;
            }
        }
        //grid 3X3
        int stRow = (row/3)*3;
        int stCol = (col/3)*3;
        for(int i = stRow; i<stRow+3; i++){
            for(int j = stCol; j<stCol+3; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int[][] board, int row, int col){
    if(row == board.length){
        return true; // Sudoku solved completely
    }

    int newRow = row, newCol = col+1;
    if(col+1 == board[0].length) {
        newRow = row+1;
        newCol = 0;
    }

    // Check if the current cell already has a value
    if(board[row][col] != 0){
        return sudokuSolver(board, newRow, newCol);
    }

    // Try placing digits from 1 to 9
    for(int digit = 1; digit <= 9; digit++){
        if(isSafe(board, row, col, digit)){
            board[row][col] = digit; // Place the digit
            if(sudokuSolver(board, newRow, newCol)){
                return true; // If placing this digit leads to a solution, return true
            }
            board[row][col] = 0; // Backtrack if placing this digit didn't lead to a solution
        }
    }

    return false; // No valid digit found for this cell
}

    public static void printSudoku(int board[][]){
        System.out.println("==== Sudoku Board ======");
        for(int i = 0; i<board.length; i++){
            if((i)%3 == 0){
                System.err.println("---------------------");
            }
            for(int j = 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
                if((j+1) % 3 == 0)System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }  
    public static void main(String[] args) {
        // System.err.println("Hello World");
        // PrintSubSets("abc", 0, "");
        // PrintPermutation("abc", "");

        // int N = 4;
        // int[][] board = new int[N][N];
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board[0].length; j++){
        //         board[i][j] = 0;
        //     }
        // }
        // NQueens(board, 0);
        // System.err.println("\nDone");

        // int m = 3, n = 3;
        // System.err.println(gridWays(0, 0, m, n));

        int[][] board = {
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

        if(sudokuSolver(board, 0, 0)){
            printSudoku(board);
        } else{
            System.err.println("Cannot Solve");
        }
    }
}