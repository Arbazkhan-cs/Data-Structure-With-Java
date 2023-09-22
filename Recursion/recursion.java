import java.util.*;

import javax.swing.plaf.OptionPaneUI;
public interface recursion {
    public static void PrintDecrease(int n){
        if(n == 0){
            return;
        }
        System.out.print(n+" ");
        PrintDecrease(n-1);
    }

    public static void PrintIncrease(int n){
        if(n == 0){
            return;
        }
        PrintIncrease(n-1);
        System.out.print(n+" ");
    }

    public static int Factorial(int n){
        if(n == 0){
            return 1;
        }
        int n_minus_1 = Factorial(n-1);
        int Facto = n * n_minus_1;
        return Facto;
    }

    public static int Sum_N(int n){
        if(n == 0){
            return 0;
        }
        int nM1 = Sum_N(n-1);
        int sum = n + nM1;
        return sum;
    }
    public static int Fibo(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        int nM1 = Fibo(n-1);
        int nM2 = Fibo(n-2);
        int Sum = nM1+nM2;
        return Sum;
    }


    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int searchKFirst(int arr[], int i, int k){
        if(arr[i] == k){
            return i;
        }
        if(i == arr.length-1){
            return -1;
        }
        return searchKFirst(arr, i+1, k);
    }

    public static int searchKLast(int arr[], int i, int k){
        if(i == arr.length){
            return -1;
        }
        int isFound = searchKLast(arr, i+1, k);

        if(isFound == -1 && arr[i] == k){
            return i;
        }
        return isFound;
    }

    public static int powXtoN(int x, int n){
        if(n == 0){
            return 1;
        }
        int xNm1 = powXtoN(x, n-1);
        int XtoN = x * xNm1;
        return XtoN;
    }

    public static int OptipowXtoN(int x, int n){
        if(n == 0){
            return 1;
        }
        int nby2 = OptipowXtoN(x, n/2);

        if(n%2 != 0){
            return x * nby2 *nby2;
        }

        return nby2 * nby2;
        
    }

    public static int tileproblem(int m, int n){
        // base case
        if(n == 0 || n == 1){
            return 1;
        }

        // kaam
        // Verticaly place tiles
        int fnm1 = tileproblem(m, n-1);

        // Hrizontaly place tiles
        int fnm2 = tileproblem(m, n-2);

        return fnm1+fnm2;

    }

    public static void strUnique(String str, StringBuilder newStr, int i, boolean map[]){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }

        // kaam
        char ch = str.charAt(i);
        if(map[ch - 'a']){
            strUnique(str, newStr, i+1, map);
        } 
        else{
            map[ch - 'a'] = true;
            strUnique(str, newStr.append(ch), i+1, map);
        }
    }

    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        // kaam
        // Single 
        int singleWays = friendsPairing(n-1);

        // Pairing
        int pairWays = (n-1) * friendsPairing(n-2);


        // Total Number Of Ways
        return singleWays + pairWays;

        // SortMethod
        // return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void binaryString(int n, int lastPlace, String str){
        // base case
        if(n == 0){
            System.out.println(str);
            return;
        }
        
        //kaam
        binaryString(n-1, 0, str+"0");
        if(lastPlace == 0){
            binaryString(n-1, 1, str+"1");
        }
    }
    public static void main(String args[]){
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter The Number: ");
        // int n = sc.nextInt();

        // 1). Print Numbers in Decreasing order
        // PrintDecrease(n);

        // 2). Print Numbers in Increasing Order
        // PrintIncrease(n);

        // 3). Factorial
        // int facto = Factorial(n);
        // System.out.println(facto);

        // 4). Sum of first natural number
        // System.out.println(Sum_N(n));

        // 5). Fibonacci
        // System.out.println(Fibo(n));

        // // 6).Is array sorted;
        // int arr[] = {1, 2, 3, 4, 6, 5};
        // System.out.println(isSorted(arr, 0));

        // 7). Search k in first occurence
        // int arr[] = {1, 2, 3, 4, 5, 6, 7};
        // System.out.println(searchKFirst(arr, 0, 7));
        
        // // 8). Search k in last occurence
        // int arr[] = {7, 2, 5, 4, 3, 0, 5};
        // System.out.println(searchKLast(arr, 0, 7));

        // // 9). x^n O(n)
        // int x = 2;
        // int n = 4;
        // System.out.println(powXtoN(x, n));

        // // 10). optimise x^n O(log n)
        // int x = 2;
        // int n = 10;
        // System.out.println(OptipowXtoN(x, n));

        // //11). Tilling Problem
        // int totalWays = tileproblem(2, 5);
        // System.out.println(totalWays);

        // // 12). remove duplicates
        // boolean arr[] = new boolean[26];
        // String str = "appnnacollege";
        // StringBuilder newStr = new StringBuilder();
        // strUnique(str, newStr, 0, arr);

        // // 13). Friends Pairing 
        // int TotalWays = friendsPairing(3);
        // System.out.println(TotalWays);

        // 14). Binary String
        binaryString(3, 0, "");
    }
}
