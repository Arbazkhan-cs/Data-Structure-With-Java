public class bitsOperations {
    public static boolean isEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){  // from n & 1 we will gona have only the LSB.
            return true;
        } else {
            return false;
        }
    }

    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        } 
        return 1;
    }

    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int setorclear){
        // old Metod
        // if(setorclear == 0){
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        // new method
        n = clearIthBit(n, i);
        int bitMask = setorclear<<i;
        return n | bitMask;
    }

    public static int clearLastIthBit(int n, int i){
        int bitMask = ~(0)<<i;
        return n & bitMask; 
    }

    public static int clearRangeIthBit(int n, int i, int j){
        int bitMask = ~(0)<<(j+1);
        int bitMask2 = (1<<i)-1;

        bitMask = bitMask | bitMask2;
        return n & bitMask;
    }
    public static void main(String args[]){
        // int n = 4;
        // System.out.println("isEven = "+(isEven(n)));


        // 1). Get Ith Bit
        // int n = 5;
        // int IthBit = getIthBit(n, 2);
        // System.out.println("IthBit = " + IthBit);

        // 2). Set Ith Bit
        // int n = 5;
        // System.out.println(setIthBit(n, 1));


        // 3). Clear Ith Bit
        // int n = 10;
        // System.out.println(clearIthBit(n, 1));


        // 4). Update Ith Bit (clear or set)
        // int n = 5;
        // System.out.println(updateIthBit(n, 1, 1));


        //  5). Clear Last Ith Bit
        // int  n = 7;
        // System.out.println(clearLastIthBit(n, 2));

        // 6). Clear in a range
        int  n = 10;
        System.out.println(clearRangeIthBit(n, 2, 4));
        

    }
}
