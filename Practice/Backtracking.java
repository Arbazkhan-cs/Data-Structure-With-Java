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
    public static void main(String[] args) {
        System.err.println("Hello World");
        PrintSubSets("abc", 0, "");
        PrintPermutation("abc", "");

        int N = 4;
        int[][] board = new int[N][N];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = 0;
            }
        }
        NQueens(board, 0);
        System.err.println("\nDone");
    }
}