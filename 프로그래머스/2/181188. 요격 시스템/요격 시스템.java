import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2)->{
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int end = 0;
        for(int[] t : targets){
            if(end <= t[0]){
                answer++;
                end = t[1];
            }
        }
        
        return answer;
    }
}