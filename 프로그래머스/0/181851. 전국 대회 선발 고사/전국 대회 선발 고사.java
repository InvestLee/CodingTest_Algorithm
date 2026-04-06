import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < rank.length; i++){
            if(!attendance[i]) rank[i] = 101;
            map.put(rank[i], i);
        }
        Arrays.sort(rank);
        return map.get(rank[0]) * 10000 + map.get(rank[1]) * 100 + map.get(rank[2]);
    }
}