import java.util.*;

public class Solution {
    public int solution(int n) {
        String[] n_arr = String.valueOf(n).split("");
        int answer = 0;
        for (String s : n_arr){
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}