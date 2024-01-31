import java.util.*;

/* The question was:
Amazon Technical Academy (ATA) Provides in-demand, technical training it current Amazon employees to broaden their skill sets. ATA has admitted a group of n prospective trainees with varying skill levels. A placement examination will return a skill level that will be used to group the traniees into classes, where levels[i] represents the skill level of trainee i. all trainees within maxSpread, a specific range of one another. Determine the minimum number of classes that must be formed.

Example:
n = 5
levels = [1, 4, 7, 3, 4]
maxSpread = 2

The trainee in any class must within maxSpeed = 2 levels of each other. In this case, one optimal grouping is (1, 3), (4, 4), and(7). Another possible grouping is (1),(3,4,4),(7). There is no way to form than 3 classes. */

public class AmazonQuestion {
    public static void main(String args[]) {
        // Inputs
        List<Integer> levels = new ArrayList<>();
        levels.add(1);
        levels.add(4);
        levels.add(7);
        levels.add(3);
        levels.add(4);
        int maxDist = 2;

        // Solution
        int count = 0;
        boolean[] visited = new boolean[levels.size()];

        for (int i = 0; i < levels.size(); i++) {
            if (!visited[i]) {
                count++;
                int currentSkill = levels.get(i);
                visited[i] = true; // Mark current trainee as visited
                // Check for other trainees who can form a group with the current trainee
                for (int j = i + 1; j < levels.size(); j++) {
                    if (!visited[j] && Math.abs(currentSkill - levels.get(j)) <= maxDist) {
                        visited[j] = true; // Mark the trainee as visited
                    }
                }
            }
        }

        System.out.println(count);
    }
}

// My approach ==============================================================================
// import java.util.*;

// public class amazon_question {
//     public static void main(String args[]){
//         // Inputs =============================================
//         List<Integer> levels = new ArrayList<>();
//         levels.add(1);
//         levels.add(4);
//         levels.add(7);
//         levels.add(3);
//         levels.add(4);
//         int maxDist = 2;

//         // Solution ============================================
//         int count = 0;
//         int[] visited = new int[levels.size()];

//         for(int i = 0; i<levels.size(); i++){
//             Stack<Integer> st = new Stack<>();
//             st.push(levels.get(i));
//             int flag = 0;
//             for(int j = 1; j<levels.size(); j++){
//                 if(Math.abs(levels.get(i) - levels.get(j)) <= maxDist
//                     && Math.abs(st.peek() - levels.get(j))  <= maxDist
//                     &&  visited[j] == 0){
//                         st.push(levels.get(j));
//                         visited[j] = 1;
//                         flag = 1;
//                 }
//             }

//             if(flag == 1){
//                 count += 1;
//             } else{
//                 if(st.size() == 1){
//                     int num = st.pop();
//                     int idx = levels.indexOf(num);
//                     if(visited[idx] == 0){
//                         count+=1;
//                     }
//                 }
//             }
//         }

//         System.err.println(count);

//     }
// }

