import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr).filter(i -> i % divisor == 0).toArray();
        Arrays.sort(result);
        if (result.length==0) result = new int[]{-1};
        return result;
    }
}