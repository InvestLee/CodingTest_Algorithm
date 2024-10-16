import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int nowTime = 0;
        int cnt = 0;
        int idx = 0;
        int[] curJob;
        
        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= nowTime){
                pq.offer(jobs[idx++]);
            }
            
            if(!pq.isEmpty()){
                curJob = pq.poll();
                answer += curJob[1] + nowTime - curJob[0];
                nowTime += curJob[1];
                cnt++;
            } else {
                nowTime = jobs[idx][0];
            }
        }
        
        return answer/jobs.length;
    }
}