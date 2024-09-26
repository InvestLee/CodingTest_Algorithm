import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int maxDiff = Arrays.stream(diffs).max().getAsInt();
        int minDiff = 1;
        
        int level; 
        long time;
        while(minDiff < maxDiff){
            level = (maxDiff + minDiff) / 2;
            time = calTime(diffs, times, level);
            if(time <= limit){
                maxDiff = level;
            } else {
                minDiff = level+1;
            }
        }
        return maxDiff;
    }
    
    public static long calTime(int[] diffs, int[] times, int level){
        long time = 0;
        for(int i = 0; i < diffs.length; i++){
            if(diffs[i] <= level){
                time += times[i];
            } else {
                time += (times[i-1] + times[i]) * (diffs[i] - level)
                    + times[i];
            }
        }
        
        return time;
    }
}