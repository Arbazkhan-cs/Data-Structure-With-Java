import java.util.*;
public class dsa_question {
    public static double displacement(String str){
        int i=0, j=0;
        for(int k = 0; k<str.length(); k++){
            // North
            if(str.charAt(k) == 'N'){
                i++;
            } 
            // South
            else if(str.charAt(k) == 'S'){
                i--;
            } 
            // East
            else if(str.charAt(k) == 'E'){
                j++;
            } 
            // West
            else if(str.charAt(k) == 'W'){
                j--;
            } 
            // Invalid
            else{
                return 0;
            }
        }
        
        double displacement = Math.sqrt((i*i) + (j*j));
        return displacement;
    }

    public static String substring(String str, int si, int ei){
        String substr = "";
        for(int i = si; i<ei; i++){
            substr += str.charAt(i);
        }
        return substr;
    }


    public static String toUpper(String str){
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append(str.charAt(i));
                sb.append(Character.toUpperCase(str.charAt(++i)));

            } else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str){
        StringBuilder newstr = new StringBuilder("");
        for(int i = 0; i<str.length(); i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if(count>1){
                newstr.append(count.toString());
            }
        }
        return newstr.toString();
    }
    public static void main(String args[]){
        // 1). Displacement Question.
        // String str = "WNEENESENNN";
        // double result = displacement(str);
        // System.out.println("Displacement = "+result);

        // 2). Substring function
        // String str2 = "Hello World";
        // String substr = substring(str2, 0, 5);
        // String substrPredifined = str2.substring(0, 5);  // by java predeifined function
        // System.out.println("Sub String = "+substr);
        // System.out.println("Sub String From Prdifined function = "+substr);

        // 3). String Upper Case
        // String str2 = "hello, my name is arbaz khan";
        // System.out.println(toUpper(str2));

        // 4). String compression
        String str3 = "aaabbcccdd";
        System.out.println(compress(str3));
    }
}
