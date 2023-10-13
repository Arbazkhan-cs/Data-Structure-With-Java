import java.util.Stack;
public class practice{
    public static void pushAtBottom(Stack<Integer> st,int data){
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int temp = st.pop();
        pushAtBottom(st, data);
        st.push(temp);
    }
    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            st.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char ch = st.pop();
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void helper(Stack<Integer> st, int value){
        if(st.isEmpty()){
            st.push(value);
            return;
        }
        int temp = st.pop();
        helper(st, value);
        st.push(temp);
    }
    public static void reverseStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int temp = st.pop();
        reverseStack(st);
        helper(st, temp);
    }

    public static void stockSpan(int[] stock, int[] span){
        Stack<Integer> prevHigh = new Stack<>();
        span[0] = 1;
        prevHigh.push(0);

        for(int i = 1; i<stock.length; i++){
            int currPrice = stock[i];
            while(!prevHigh.isEmpty() && currPrice > stock[prevHigh.peek()]){
                prevHigh.pop();
            }
            if(prevHigh.isEmpty()){
                span[i] = i+1;
            } else{
                span[i] = i - prevHigh.peek();
            }
            prevHigh.push(i);
        }
    }

    public static int[] NextGreaterElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for(int i = arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            } else{
                res[i] = arr[st.peek()];
            }
            st.push(i);
        }

        return res;
    }


    public static boolean isValidParantesis(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            // openning
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            } else{
                if(st.isEmpty()){
                    return false;
                }
                if((st.peek() == '(' && ch == ')') || 
                (st.peek() == '[' && ch == ']') || 
                (st.peek() == '{' && ch == '}')){
                    st.pop();
                } else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isDuplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                s.push(ch);
            } else{
                if(s.peek() == '('){
                    return true;
                }
                else{
                    while(s.peek() != '('){
                        s.pop();
                    }
                    s.pop();
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);

        
        // pushAtBottom(st, 4);
        // System.out.println(st);

        // System.out.println(reverseString("Arbaz Khan"));
        
        // reverseStack(st);
        // System.out.println(st);


        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int[] span = new int[stocks.length];

        // stockSpan(stocks, span);
        // for(int i = 0; i< span.length; i++){
        //     System.out.print(span[i]+" ");
        // }


        // int arr[] = {6, 8, 0, 1, 3};
        // int res[] = NextGreaterElement(arr);
        // for(int i = 0; i<res.length; i++){
        //     System.out.print(res[i] + " ");
        // }


        // String s = "{({}[])}";
        // System.out.println(isValidParantesis(s));

        String str = "((a+b))";
        String str2 = "(a-b)";
        System.out.println(isDuplicateParenthesis(str));
        System.out.println(isDuplicateParenthesis(str2));
    }
}