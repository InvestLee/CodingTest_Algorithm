import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int [] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        for (int i=0; i < a; i++){
            total += month[i];
        }
        total += b;
        String [] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        return day[(total%7)];
    }
}