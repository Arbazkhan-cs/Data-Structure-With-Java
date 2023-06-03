public class string {
    public static void isPalindrome(String str){
        int i=0, j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                System.out.println("Not A Palindrome");
                return;
            }
            i++;
            j--;
        }
        System.out.println("Yes It Is Palindrome");
    }
    public static void main(String args[]){
        String str = "noon";
        isPalindrome(str);
    }
}
