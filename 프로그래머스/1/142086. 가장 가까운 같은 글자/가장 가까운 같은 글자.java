import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        char temp;
        for(int i = 0; i < s.length(); i++){
            temp = s.charAt(i);
            if(!map.containsKey(temp)){
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(temp);
            }
            map.put(temp, i);
        }
        return answer;
    }
}