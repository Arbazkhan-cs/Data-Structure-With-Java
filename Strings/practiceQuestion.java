import java.util.Arrays;

/**
 * practiceQuestion
 */
public class practiceQuestion {
    public static int countLowerVowels(String str){
        int count = 0;
        for(int i = 0; i<str.length(); i++){
           if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                count++;
           } 
        }
        return count;
    }

    public static boolean isAnagrams(String str1, String str2){
        boolean isAnagrams = false;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()){
            char arr1[] = str1.toCharArray();
            char arr2[] = str2.toCharArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            isAnagrams = Arrays.equals(arr1, arr2);
        }
        return isAnagrams;
    }
    public static void main(String args[]){
        // 1). How many lower case vowels are in the string
        String str="arbaz khAn imran SAIF";
        System.out.println("Lower Case Vowels Are = "+countLowerVowels(str));

        // 2). check 2 string's are anagrams
        String str1 = "race";
        String str2 = "care";
        System.out.println("String Are Anagrams = "+isAnagrams(str1, str2));

    }   
}