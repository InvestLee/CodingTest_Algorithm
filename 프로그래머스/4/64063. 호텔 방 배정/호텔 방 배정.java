import java.util.*;

class Solution {
    public static HashMap<Long, Long> map = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i = 0; i < room_number.length; i++){
            answer[i] = findRoom(room_number[i]);
        }
        return answer;
    }
    
    public static Long findRoom(long num){
        if(!map.containsKey(num)){
            map.put(num, num + 1);
            return num;
        }
        long result = findRoom(map.get(num));
        map.put(num, result);
        return result;
    }
}