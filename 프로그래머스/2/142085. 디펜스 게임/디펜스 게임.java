import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);
        
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.offer(enemy[i]);
            if(n < 0){
                if(k > 0){
                    n += pq.poll();
                    k--;
                } else{
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}