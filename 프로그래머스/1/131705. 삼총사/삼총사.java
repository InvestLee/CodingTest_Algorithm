import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        Arrays.sort(number);
        
        int total;
        for(int mid = 1; mid < number.length-1; mid++){
            for(int start = 0; start < mid; start++){
                for(int end = number.length-1; end > mid; end--){
                    total = number[start]+number[mid]+number[end];
                    if(total == 0) answer++;
                }
            }
        }
        return answer;
    }
}