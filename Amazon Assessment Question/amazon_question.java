import java.util.*;

/* The question was:
Amazon Technical Academy (ATA) Provides in-demand, technical training it current Amazon employees to broaden their skill sets. ATA has admitted a group of n prospective trainees with varying skill levels. A placement examination will return a skill level that will be used to group the traniees into classes, where levels[i] represents the skill level of trainee i. all trainees within maxSpread, a specific range of one another. Determine the minimum number of classes that must be formed.

Example:
n = 5
levels = [1, 4, 7, 3, 4]
maxSpread = 2

The trainee in any class must within maxSpeed = 2 levels of each other. In this case, one optimal grouping is (1, 3), (4, 4), and(7). Another possible grouping is (1),(3,4,4),(7). There is no way to form than 3 classes. */

class amazon_question {
    public static int maxGroup(List<Integer> levels, int maxSpread){
        Collections.sort(levels);
        int count = 0;
        int i = 0;
        while(i<levels.size()){
            int j=i+1;
            while(j<levels.size() && Math.abs(levels.get(i)-levels.get(j))<=maxSpread)
                j++ ;

            count += 1;
            i=j;
        }
        
        return count;   
    }
    public static int maxGroupIUsed(List<Integer>  levels, int maxSpread){
        int count = 0;
        int[] visited = new int[levels.size()];

        for(int i = 0; i<levels.size(); i++){
            Stack<Integer> st = new Stack<>();
            st.push(levels.get(i));
            int flag = 0;
            for(int j = 1; j<levels.size(); j++){
                if(Math.abs(levels.get(i) - levels.get(j)) <= maxSpread
                    && Math.abs(st.peek() - levels.get(j))  <= maxSpread
                    &&  visited[j] == 0){
                        st.push(levels.get(j));
                        visited[j] = 1;
                        flag = 1;
                }
            }

            if(flag == 1){
                count += 1;
            } else{
                if(st.size() == 1){
                    int num = st.pop();
                    int idx = levels.indexOf(num);
                    if(visited[idx] == 0){
                        count+=1;
                    }
                }
            }
        }

        return count;
    }
    public static void main(String args[]) {
        // Inputs
        List<Integer> levels = new ArrayList<>();
        levels.add(1);
        levels.add(4);
        levels.add(7);
        levels.add(3);
        levels.add(4);
        int maxSpread = 2;

        // Solution - greedy method
        System.err.println(maxGroup(levels, maxSpread));
        // Soltuion - i used
        System.err.println(maxGroupIUsed(levels, maxSpread));
    }
}