import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200000000;
        int mid;
        while(min < max){
            mid = (max + min) / 2;
            if(isPos(mid, stones, k)){
                min = mid+1;
            } else {
                max = mid;
            }
        }
        return min-1;
    }
    
    public static boolean isPos(int num, int[] stones, int k){
        int skip = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < num){
                skip++;
            } else {
                skip = 0;
            }
            if(skip == k) return false;
        }
        return true;
    }
}