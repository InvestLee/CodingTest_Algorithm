import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        HashMap<Integer, int[]> node = new HashMap<>();
        for(int[] e : edges){
            if(!node.containsKey(e[0])) node.put(e[0], new int[]{0,0});
            if(!node.containsKey(e[1])) node.put(e[1], new int[]{0,0});
            node.get(e[0])[0]++;
            node.get(e[1])[1]++;
        }
        
        for(int n : node.keySet()){
            if(node.get(n)[0] >= 2 && node.get(n)[1] == 0) {
                answer[0] = n;
            }
            else if(node.get(n)[0] == 0 && node.get(n)[1] >= 1) {
                answer[2]++;
            }
            else if(node.get(n)[0] >= 2 && node.get(n)[1] >= 2){
                answer[3]++;
            }
        }
        answer[1] = node.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}