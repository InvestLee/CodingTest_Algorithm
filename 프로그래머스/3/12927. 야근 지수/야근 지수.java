import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        
        int temp;
        while(n > 0){
            temp = pq.poll();
            if(temp == 0) break;
            pq.offer(temp-1);
            n--;
        }
        for(int w : pq){
            answer += w*w;
        }
        return answer;
    }
}