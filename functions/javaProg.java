import java.util.*;
public class javaProg {
    public static int calcuProd(int a, int b){
        int product = a*b;
        return product;
    }


    public static int facto(int num){
        int facto=1;
        while(num>1){
            facto = facto * num;
            num -= 1;
        }
        return facto;
    }


    public static int nCr(int n, int r){
        int nfacto=1, rfacto=1, n_rfacto=1, n_r = (n-r);
        while(n>1){
            nfacto *= n;
            if(r>1){
                rfacto *= r;
            }
            if(n_r>1){
                n_rfacto *= n_r;
            }
            n--;
            r--;
            n_r--;
        }
        return (nfacto/(rfacto*n_rfacto));
    }



    public static String isPrime(int n){
        // Method 1: Not Optimized
        // if(n==2||n==3){
        //     return "It's Prime";
        // }
        // if(n==1){
        //     return "Not Prime";
        // }
        // for(int i=2; i<n; i++){
        //     if(n%i == 0){
        //         return "Not Prime";
        //     }
        // }
        // return "It's Prime";

        
        // Method 2: Optimized
        // Use this method every time
        if(n==2||n==3){
            return "It's Prime";
        }
        if(n==1){
            return "Not Prime";
        }
        for(int i=2; i<=Math.sqrt(n); i++){  // replace i<n to i<sqrt(n);
            if(n%i == 0){
                return "Not Prime";
            }
        }
        return "It's Prime";
    }


    public static void PrimeNums(int range){
        for(int i=2; i<range; i++){
            if(isPrime(i) == "It's Prime"){
                System.out.print(i+" ");
            }
        }
    }

    public static int binaryToDecimal(long binary){
        int decimal=0;
        int pow = 0;
        while(binary>0){
            int lastdigit = (int) (binary%10);
            decimal = (int) (decimal+lastdigit*Math.pow(2, pow));
            pow++;
            binary /= 10;
        }
        return decimal;
    }

    public static long decimalToBinary(int decimal){
        long binary = 0;
        int pow=0;
        while(decimal>0){
            int reminder = decimal%2;
            binary = binary+(reminder*(long)(Math.pow(10, pow)));
            pow++;
            decimal /= 2;
            // System.out.println("Remainder = "+reminder);  // For debugging
            // System.out.println("Binary = "+binary);
            // System.out.println("Decimal = "+decimal);
            // System.out.println("place = "+place);
            // System.out.println();
        }
        return binary;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Two Numbers: ");
        // int a = sc.nextInt();
        // int b = sc.nextInt();

        // int product = calcuProd(a, b);
        // System.out.println("a * b = "+product);



        // Find Factorial
        // System.out.println("Enter The Number for factorial: ");
        // int num = sc.nextInt();

        // int factorial = facto(num);
        // System.out.println("Factorial is = "+factorial);




        // Find the binomial cofficient
        // System.out.print("Enter N = ");
        // int n = sc.nextInt();
        
        // System.out.print("Enter R = ");
        // int r = sc.nextInt();

        // System.out.println("Binomial Cofficient = "+nCr(n, r));



        // // Find prime number
        // System.out.println("Enter The Number To See IsPrime: ");
        // int n = sc.nextInt();
        // System.out.println("IsPrime? = "+isPrime(n));



        // // Pint all prime in a range
        // System.out.println("Enter The Range: ");
        // int range = sc.nextInt();
        // PrimeNums(range);



        // Convert a number from binary to decimal
        // long binary = 101;
        // int decimal = binaryToDecimal(binary);
        // System.out.println("Decimal Of "+binary+" is = "+decimal);

        // Convert a number from decimal to binary
        // int decimal= 11;
        // long binary = decimalToBinary(decimal);
        // System.out.println("Binary Of "+decimal+" is = "+binary);
    }
}
