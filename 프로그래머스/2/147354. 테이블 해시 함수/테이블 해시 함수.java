import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            return o1[col-1]-o2[col-1];
        });
        
        int cal;
        for(int i = row_begin-1; i < row_end; i++){
            int temp = i+1;
            cal = Arrays.stream(data[i])
                .map(a -> a % temp)
                .sum();  
            answer = answer ^ cal;
        }
        return answer;
    }
}