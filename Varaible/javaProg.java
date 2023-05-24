import java.util.*;  // To understand it go to line 75;

public class javaProg {
    public static void main(String args[]){
        // Output Methods
        // print function will not return any new line at the End.
        // System.out.print("Hello world from print()");  
        // System.out.print("Hello world from print()");

        // println function is used when we want to give a new linw at the end.
        // System.out.println("Hello World from println()");
        // System.out.println("Hello World from println()");

        // To add a new line in our print() we can use special character "\n".
        // System.out.print("Hello World form print() with \\n \n");
        // System.out.print("Hello World form print() with \\n \n");


        // Little Question to print a pattern
        // System.out.println("* * * *");
        // System.out.println("* * *");
        // System.out.println("* *");
        // System.out.println("*");


        // Varables
        // int a = 10;
        // int b = 20;
        // System.out.println(a);
        // System.out.println(b);


        // Data Types: in java we have 8 data types,
        // byte B = 8;  // 1
        // System.out.println(B);
        // short sh = 10;  // 2
        // System.out.println(sh);
        // char ch = 'a';  // 3
        // System.out.println(ch);
        // int x = 47;  // 4
        // System.out.println(x);
        // long l_x = 234;  // 4
        // System.out.println(l_x);
        // float ft = (float) 3.14;  // 6
        // System.out.println(ft);
        // double d_ft = 873.8465;  // 7
        // System.out.println(d_ft);
        // boolean var = true;  // 8
        // boolean var_2 = false;
        // System.out.println(var);
        // System.out.println(var_2);
        
    

        // Simple Question to sum the values of a and b
        // int a = 10;
        // int b = 7;
        // int sum = a+b;
        // System.out.println(sum);



        // various Input Methods:
        /* 
         1). next();  It is use to store string values, but it do not store white spaces
         2). nextLine();  It is use to store string values includeing white spaces
         3). nextInt();
         4). nextFloat();
         5). nextByte();
         6). nextDouble();
         7). nextLong();
         8). nextShort();
         9). nextBoolean();
         So to use above input method first we have to import java utilities: 
         > import java.util.* like this at the top of the code...

         After adding java utility we have to create a new class of Scanner to use methods:
         > Scanner scan = new Scanner(System.in);
         System.in is for the input
         */

        // Scanner scan = new Scanner(System.in);
        // String name = scan.nextLine();  // this is how we take input from the user;
        // String name2 = scan.next();
        // int val = scan.nextInt();
        // long d_val = scan.nextLong();
        // float fl = scan.nextFloat();
        // double fl_l = scan.nextDouble();
        // boolean var = scan.nextBoolean();
        // Byte B = scan.nextByte();
        // System.out.println(B);


        // Simple program to find the area of the circle by taking radius form the user;
        // Scanner scan = new Scanner(System.in);
        // float radius = scan.nextFloat();
        // float pi = 3.14f;  // we can change double to float by using 'f' in the last;

        // float area = pi*radius*radius;
        // System.out.println(area);
    }
}