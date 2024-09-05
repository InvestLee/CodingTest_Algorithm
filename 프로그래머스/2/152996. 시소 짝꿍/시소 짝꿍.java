import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();
        
        double a, b, c, d;
        for(int w : weights){
            a = w * 1.0;
            b = w * 2.0 / 3.0;
            c = w * 1.0 / 2.0;
            d = w * 3.0 / 4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put((w * 1.0), map.getOrDefault((w * 1.0),0)+1);
        }
        return answer;
    }
}