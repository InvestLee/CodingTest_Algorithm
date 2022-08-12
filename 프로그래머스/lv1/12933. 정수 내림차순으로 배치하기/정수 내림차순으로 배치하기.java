import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] s_list = String.valueOf(n).split("");
        Arrays.sort(s_list,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s:s_list) sb.append(s);
        return Long.parseLong(sb.toString());
    }
}