public class practice{
    public static void printKeys(int arr[], int i, int k){
        if(i == arr.length){
            return;
        }
        else if(arr[i] == k){
            System.out.print(i+" ");
        }
        
        printKeys(arr, i+1, k);
        
    }

    public static StringBuilder convertString(String arr[], StringBuilder str, int n, int i){
        if(n == 0){
            return str;
        }
        convertString(arr, str, n/10, i = n%10);
        str.append(arr[i]+" ");
        return str;
    }

    public static int strLen(String str, int i){
        if(i == str.length()){
            return 0;
        }
        return strLen(str, i+1) + 1;
        
    }

    public static int countSubStr(String str, int i, int j, int n){
        if(n == 1){
            return 1;
        }
        if(n <= 0){
            return 0;
        }

        int res = countSubStr(str, i+1, j, n-1) + countSubStr(str, i, j-1, n-1) - countSubStr(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)){
            res++;
        }
        return res;
    }

    public static void TowerOfHanoi(int n, String src, String helper, String des){
        if(n == 1){
            System.out.println("transfer disk "+n+" from "+src+" to "+des);
            return;
        }

        TowerOfHanoi(n-1, src, des, helper);

        System.out.println("transfer disk "+n+" from "+src+" to "+helper);

        TowerOfHanoi(n-1, helper, src, des);
    }
    public static void main(String args[]){
        // String arr[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // printKeys(arr, 0, 2);

        // StringBuilder str = convertString(arr, new StringBuilder(""), 1947, 0);
        // System.out.println(str);

        // System.out.println(strLen("abcd", 0));

        // String str = "abcabd";
        // int n = countSubStr(str, 0, str.length()-1, 5);
        // System.out.println(n);

        int n=3;
        TowerOfHanoi(n, "A", "B", "c");
    }
}