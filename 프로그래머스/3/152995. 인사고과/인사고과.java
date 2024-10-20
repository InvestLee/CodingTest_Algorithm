import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        Arrays.sort(scores, (o1,o2) -> {
            if(o1[0] == o2[0]) return o1[1]-o2[1];
            return o2[0]-o1[0];
        });
        
        int maxScore = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(scores[0][0]+scores[0][1]);
        for(int i = 1; i < scores.length; i++){
            if(scores[i-1][0] != scores[i][0] && maxScore < scores[i-1][1]){
                maxScore = scores[i-1][1];
            }
            if(maxScore <= scores[i][1]){
                arr.add(scores[i][0]+scores[i][1]);
            } else if(scores[i].equals(wanho)){
                return -1;
            }
        }
        
        arr.sort(Collections.reverseOrder());
        for(int i = 0; i < arr.size(); i++){
            if(wanho[0]+wanho[1] == arr.get(i)) return i+1;
        }
        return -1;
    }
}