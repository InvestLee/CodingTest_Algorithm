import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Queue<int[]> q = new LinkedList<>();
        int curAddServer = 0;
        int answer = 0;
        for(int i = 0; i < 24; i++){
            if(!q.isEmpty() && q.peek()[0]==i){
                curAddServer -= q.poll()[1];
            }
            int need = players[i] / m;
            if(curAddServer < need){
                int addServer = need - curAddServer;
                curAddServer += addServer;
                answer += addServer;
                q.add(new int[]{i+k, addServer});
            }
        }
        return answer;
    }
}