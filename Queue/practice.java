import java.util.*;
import java.util.LinkedList;
public class practice{
    public static char firstNonRepeatingCharacter(String str){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        char res = ' ';

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a'] += 1;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }
            if(!q.isEmpty()){
                res = q.peek();
            } else{
                res = ' ';
            }
        }

        return res;
    }

    public static void interleave2halves(Queue<Integer> q){
        Queue<Integer> q2 = new LinkedList<>();
        int n = q.size() / 2;
        for(int i = 0; i<n; i++){
            int val = q.remove();
            q2.add(val);
        }
        while(!q2.isEmpty()){
            int val1 = q2.remove();
            int val2 = q.remove();
            q.add(val1);
            q.add(val2);
        }
    }

    public static void QueueReverse(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }
        int val = q.remove();
        QueueReverse(q);
        q.add(val);
        return;
    }
    public static void main(String[] args) {
        // String str = "aabccxb";
        // System.out.println(firstNonRepeatingCharacter(str));


        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        
        // interleave2halves(q);
        QueueReverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}