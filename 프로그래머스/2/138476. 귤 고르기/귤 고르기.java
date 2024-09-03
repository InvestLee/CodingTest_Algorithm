import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int m : map.values()){
            pq.offer(m);
        }
        
        int answer = 0;        
        int cnt = 0;
        while(!pq.isEmpty()){
            answer++;
            cnt += pq.poll();
            if(cnt >= k) break;
        }
        
        return answer;
    }
}