import java.util.*;

class Solution {
    public static ArrayList<int[]> arr = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        return arr.stream().toArray(int[][]::new);
    }
    
    public static void hanoi(int cnt, int start, int mid, int end){
        if(cnt == 0) return;
        hanoi(cnt - 1, start, end, mid);
        arr.add(new int[]{start,end});
        hanoi(cnt - 1, mid, start, end);
    }
}