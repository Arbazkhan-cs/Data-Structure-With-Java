class Recurssion{
    public static void printDec(int num){
        // Base Case
        if(num <= 0){
            return;
        }
        // Kaam
        System.out.print(num + " ");
        // inner call
        printDec(num-1);
    }
    public static void printInc(int num){
        // Base Case
        if(num <= 0){
            return;
        }
        // Kaam
        printInc(num-1);
        // inner call
        System.out.print(num + " ");
    }
    public static int facto(int num){
        // base case
        if(num == 0 || num == 1){
            return 1;
        }
        // kaam and inner call
        return num * facto(num-1);
    }
    public static int sumNnatural(int num){
        // base case
        if(num == 1){
            return 1;
        }
        // kaam and inner call
        return num + sumNnatural(num-1);
    }
    public static int fiboOfN(int num){
        // base case
        if(num == 0 || num == 1){
            return num;
        }

        return fiboOfN(num-1) + fiboOfN(num-2);
    }
    public static boolean isSorted(int[] arr,int start,int idx){
        if(start != arr[idx]){
            return false;
        }
        if(idx == arr.length-1){
            return true;
        }
        return isSorted(arr, start + 1, idx + 1);
        
    }
    public static boolean isSorted2(int[] arr, int idx){
        if(idx == arr.length-1){
            return true;
        }
        if(arr[idx] > arr[idx+1]){
            return false;
        }
        
        return isSorted2(arr, idx + 1);
        
    }
    public static int firstOccur(int[] arr, int idx, int num){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx] == num){
            return idx;
        }

        return firstOccur(arr, idx+1, num);
    }
    public static int lastOccur(int[] arr, int idx, int num){
        if(idx < 0){
            return -1;
        }
        if(arr[idx] == num){
            return idx;
        }

        return lastOccur(arr, idx-1, num);
    }
    public static int lastOccur2(int[] arr, int idx, int num){
        if(idx == arr.length){
            return -1;
        }
        int isFound = lastOccur2(arr, idx+1, num);

        if(isFound == -1 && arr[idx] == num){
            return idx;
        }
        return isFound;
    }
    public static int pow(int num, int p){
        if(p == 0){
            return 1;
        }
        return num * pow(num, p-1);
    }
    public static int powOpti(int num, int p){
        if(p == 0){
            return 1;
        }
        int halfP = powOpti(num, p/2);
        if(num%2 == 0){
            return halfP*halfP;
        } else{
            return num * halfP * halfP;
        }
    }
    public static int tillingWays(int n){ //  2 X n floor with 2 X 1 tile
        if(n == 0 || n == 1){
            return 1;
        }
    
        // work
        int way1 = tillingWays(n-1);
        int way2 = tillingWays(n-2);

        return way1 + way2;
    }
    public static void UniqueStr(String str, StringBuilder newStr, int idx, boolean[] arr){
        if(idx == str.length()){
            System.err.println(newStr);
            return;
        }
        char ch = str.charAt(idx);
        if(arr[ch - 'a']){
            UniqueStr(str,newStr,idx+1,arr);
        } else{
            arr[ch - 'a'] = true;
            UniqueStr(str, newStr.append(ch), idx+1, arr);
        }
    }
    public static int friendsPearing(int n){
        if(n == 1 || n == 2){
            return n;
        }
        // single
        int way1 = friendsPearing(n-1);
        // pair
        int way2 = n-1 * friendsPearing(n-2);

        return way1 + way2;
    }
    public static void BinaryString(int n, int lastplace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        BinaryString(n-1, 0, str+"0");
        if(lastplace == 0){
            BinaryString(n-1, 1, str+"1");
        }

    }

    public static void main(String[] args) {
        // System.err.println("Hello World");
        // int num = 5;
        // printDec(num);
        // System.err.println("");
        // printInc(num);
        // int factorial = facto(num);
        // System.err.println("\n"+factorial);
        // int sum = sumNnatural(num);
        // System.err.println(sum);
        // int fibo = fiboOfN(num);
        // System.err.println(fibo);

        // int[] arr = {1, 2, 3, 3, 4, 5};
        // System.err.println(isSorted2(arr, 0));
        // int firstindex = firstOccur(arr, 0, 3);
        // System.err.println(firstindex);
        // int lastindex = lastOccur(arr, arr.length-1, 3);
        // System.err.println(lastindex);
        // int lastindex2 = lastOccur2(arr, 0, 3);
        // System.out.println(lastindex2);

        // System.err.println(pow(num, 3));
        // System.err.println(powOpti(num, 3));

        // System.err.println(tillingWays(4));


        // boolean[] map = new boolean[26];
        // String str = "appnnacollege";
        // StringBuilder sb = new StringBuilder("");
        // UniqueStr(str,sb,0,map);
        // System.err.println(sb);

        // System.out.println(friendsPearing(5));

        BinaryString(3, 0, "");
    }
}