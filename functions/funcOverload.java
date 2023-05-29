public class funcOverload {
    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    public static float sum(float a, float b){
        return a+b;
    }
    public static float sum(int a, float b, char c){
        return a+b;
    }
    public static void main(String args[]){
        System.out.println(sum(2, 3));
        System.out.println(sum(2, 3, 4));
        System.out.println(sum(2.5f, 3.6f));
        System.out.println(sum(2, 3.6f, 'd'));
    }
}
