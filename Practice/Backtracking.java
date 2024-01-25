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
    public static void main(String[] args) {
        System.err.println("Hello World");
        PrintSubSets("abc", 0, "");
        PrintPermutation("abc", "");
    }
}