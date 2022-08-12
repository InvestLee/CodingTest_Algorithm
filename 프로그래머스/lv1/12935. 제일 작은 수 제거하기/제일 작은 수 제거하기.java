import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        int min_value = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min_value).toArray();
    }
}