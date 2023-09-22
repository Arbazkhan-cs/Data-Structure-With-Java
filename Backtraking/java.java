public class java {
    public static void Printsubset(String str, String subStr, int i){
        // basecase
        if(i == str.length()){
            if(subStr.length() == 0){
                System.out.println("null");
            }
            else{
                System.out.println(subStr);
            }
            return;
        }

        // recursion calls
        // yes
        Printsubset(str, subStr+str.charAt(i), i+1);

        // no ---- Backtracking
        Printsubset(str, subStr, i+1);
    }
    public static void PrintPermutation(String str, String newStr){
        // basecase
        if(str.length() == 0){
            System.out.print(newStr+" ");
            return;
        }

        // kaam
        for(int i=0; i<str.length(); i++){
            // current char
            char ch = str.charAt(i);

            // Removing the current char from the string
            String newS = str.substring(0, i) + str.substring(i+1);

            // recursion call
            PrintPermutation(newS, newStr+ch);
        }
    }

    public static void printBoard(char board[][]){
        System.out.println("-----------Chess Board---------");
        for(int i=0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        // vertical safe
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // upper left diagonal safe
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // upper right diagonal safe
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][], int row){
        if(row == board.length){
            printBoard(board);
            return;
        }

        // kaam
        for(int j = 0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
        }
    }
    public static int gridWays(int i, int j, int m, int n){
        // basecase
        if(i == m-1 && j == n-1){
            return 1;
        }
        else if(i == m || j == n){
            return 0;
        }
        

        // kaam
        int way1 = gridWays(i+1, j, m, n);
        int way2 = gridWays(i, j+1, m, n);
        return way1+way2;
    }
    public static void main(String args[]){
        String str = "abc";
        Printsubset(str, "", 0);
        PrintPermutation(str, "");


        // nQueens Question-------------------------
        // int n = 4;
        // char board[][] = new char[n][n];
        // for(int i=0; i<board.length; i++){
        //     for(int j = 0; j<board[0].length; j++){
        //         board[i][j] = 'x';
        //     }
        // }
        // nQueens(board, 0);


        // grid ways ----------------------
        // int m = 3, n = 3;
        // int total_ways = gridWays(0, 0, m, n);
        // System.out.println(total_ways);
    }
}
