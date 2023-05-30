public class javaProg {
    // Hollow Rectangular
    public static void hollowRectangular(int row,int cols){
        for(int i=0; i<row; i++){
            for(int j=0; j<cols; j++){
                if(i==0 || i==row-1 || j==0 || j==cols-1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // Mirror pattern of Right Triangular
    public static void MirrorRightTri(int row){
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row; j++){
                if(j>row-i){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // Inverted Rightangle Triangle
    public static void InvertedRightTri(int row){
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }


    // Floyed's Triangle
    public static void FloyedTri(int row){
        int num = 1;
        for(int i=0; i<row; i++){
            for(int j=0; j<=i; j++){
                System.out.print(num+++" ");
            }
            System.out.println();
        }
    }

    // 0-1 Triangle
    public static void _01Tiangle(int row){
        for(int i=0; i<row; i++){
            for(int j=0; j<=i; j++){
                if((i+j)%2 == 0){
                    System.out.print("1 ");
                } else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    // Butterfly
    public static void butterFly(int row){
        for(int i=0; i<row/2; i++){
            for(int j=0; j<row; j++){
                if(j<=i || j>=row-i-1){
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        int m=0;
        for(int i=0; i<row/2; i++){
            for(int j=0; j<(row/2)-i; j++){
                System.out.print("* ");
            }
            int k=0;
            while(k<m){
                System.out.print("  ");
                k++;
            }
            for(int j=0; j<(row/2)-i; j++){
                System.out.print("* ");
            } 
            System.out.println();
            m+=2;
        }


        // Method 2: Easy just convert the first pattern upside down
        for(int i=row/2; i>0; i--){
            for(int j=0; j<row; j++){
                if(j<i || j>row-i-1){
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // Solid Rhombus
    public static void solidRhombus(int row){
        for(int i=0; i<row; i++){
            for(int j=0; j<row-i-1; j++){
                System.out.print("  ");
            }
            for(int j=0; j<row; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Hollow Rhombus
    public static void hollowRhombus(int row){
        for(int i=0; i<row; i++){
            for(int j=0; j<row-i-1; j++){
                System.out.print("  ");
            }
            for(int j=0; j<row; j++){
                if(i==0 || i==row-1 || j==0 || j==row-1){
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


    // Diamond
    public static void diamond(int row){
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        // Inverse the above code by seting i=row til i>0
        for(int i=row; i>=0; i--){
            for(int j=1; j<=row-i; j++){
                System.out.print("  ");
            }
            for(int j=1; j<=(2*i)-1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 1, 2, 3 Triangle
    public static void triangle(int row){
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row-i; j++){
                System.out.print("  ");
            }
            for(int j=0; j<(2*i)-1; j++){
                if(j%2 == 0){
                    System.out.print(i+" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void triangleHard(int row){
        String k="1";
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row-i; j++){
                System.out.print("  ");
            }
            
            for(int j=i; j>=1; j--){
                System.out.print(j+" ");
            }
            for(int j=2; j<=i; j++){
                System.out.print(j+" ");
            }
            
            System.out.println();
        }
    }



    public static void main(String[] args) {
        // hollowRectangular(4, 5);
        // MirrorRightTri(4);
        // InvertedRightTri(5);
        // FloyedTri(5);
        // _01Tiangle(5);
        // butterFly(6);
        // solidRhombus(5);
        // hollowRhombus(5);
        // diamond(4);
        // triangleHard(5);
    }
}
