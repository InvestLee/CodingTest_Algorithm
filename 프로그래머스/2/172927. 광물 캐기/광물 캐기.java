import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int picksLen = picks[0] * 5 + picks[1] * 5 + picks[2] * 5;
        int mineralsLen = minerals.length;
        int len = Math.min(picksLen, mineralsLen);
        
        ArrayList<int[]> fatigue = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("diamond",25);
        map.put("iron",5);
        map.put("stone",1);
        
        int tempFatigue, diaCnt, cnt;
        for(int i = 0; i < len; i += 5){
            tempFatigue = 0;
            diaCnt = 0;
            cnt = 0;
            for(int j = i; j < i + 5; j++){
                if(j >= len) break;
                tempFatigue += map.get(minerals[j]);
                if(minerals[j].equals("diamond")){
                    diaCnt++;
                }
                cnt++;
            }
            fatigue.add(new int[]{tempFatigue, diaCnt, cnt});
        }
        Collections.sort(fatigue, (o1,o2)->(o2[0]-o1[0]));
        
        for(int i = 0; i < fatigue.size(); i++){
            if(picks[0] > 0){
                picks[0]--;
                answer += fatigue.get(i)[2];
            } else if(picks[1] > 0){
                picks[1]--;
                answer += (fatigue.get(i)[1] * 5 
                    + (fatigue.get(i)[2]-fatigue.get(i)[1]));
            } else if(picks[2] > 0){
                picks[2]--;
                answer += fatigue.get(i)[0];
            }
        }
        
        return answer;
    }
}