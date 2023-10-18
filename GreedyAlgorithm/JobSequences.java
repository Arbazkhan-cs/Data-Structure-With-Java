import java.util.*;
public class JobSequences {
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int d, int p, int i){
            this.deadline = d;
            this.profit = p;
            this.id = i;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i=0 ;i <jobInfo.length;i++){
            jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i));
        }

        // descending according to the profit
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i<jobs.size(); i++){
            Job currJob = jobs.get(i);
            if(currJob.deadline > time){
                seq.add(currJob.id);
                time++;
            }
        }

        System.out.println("Max Job = "+ seq.size());
        for(int i = 0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();

    }
}
