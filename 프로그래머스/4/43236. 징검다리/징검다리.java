import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        while(left <= right){
            int mid = (left + right) / 2;
            if(calCnt(distance, rocks, mid) <= n){
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    public static int calCnt(int distance, int[] rocks, int mid){
        int prev = 0;
        int result = 0;
        for(int i = 0; i < rocks.length; i++){
            if(rocks[i] - prev < mid){
                result++;
                continue;
            }
            prev = rocks[i];
        }
        if(distance - prev < mid) result++;
        return result;
    }
}