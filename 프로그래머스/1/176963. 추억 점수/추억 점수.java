import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            hashmap.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            for(int j = 0; j < photo[i].length; j++){
                answer[i] += hashmap.getOrDefault(photo[i][j],0);
            }
        }
        
        return answer;
    }
}