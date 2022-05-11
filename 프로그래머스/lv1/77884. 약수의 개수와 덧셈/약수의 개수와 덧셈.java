import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++){
            if (Math.sqrt(i)%1==0) result -= i;
            else result += i;
        }
        return result;
    }
}