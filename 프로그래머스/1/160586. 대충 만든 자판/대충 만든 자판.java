import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        char temp;
        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                temp = keymap[i].charAt(j);
                if(!map.containsKey(temp) || map.get(temp) > j+1){
                    map.put(temp, j+1);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                temp = targets[i].charAt(j);
                if(!map.containsKey(temp)){
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(temp);
            }
        }
        
        return answer;
    }
}