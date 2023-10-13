import java.util.Stack;
public class practice2 {
    public static int MaximiumAreaRectangle(int[] arr){
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int low = i;
            int high = i;

            // Left side
            while(low>0 && arr[low-1] >= arr[i]){
                low--;
            }

            // Right side
            while(high < arr.length-1 && arr[high+1] >= arr[i]){
                high++;
            }

            int currArea = arr[i] * (high-low+1);
            res = Math.max(res, currArea);
        }
        return res;
    }
    public static int MaximiumAreaRectangleStack(int[] arr){
        int maxArea = 0;
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        // Next Smaller Right
        for(int i = arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i] = arr.length;
            } else{
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }

        // Next Smaller Left
        stack = new Stack<>();
        for(int i = 0; i< arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = -1;
            } else{
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }

        // Maximum Area
        for(int i = 0; i< arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
    public static void main(String args[]){
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(MaximiumAreaRectangle(arr));
        System.out.println(MaximiumAreaRectangleStack(arr));
    }
}
