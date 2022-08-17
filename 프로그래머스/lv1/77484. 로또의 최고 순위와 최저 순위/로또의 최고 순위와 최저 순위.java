import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count = 0;
        int win_count = 0;
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        for (int i=0; i < 6; i++){
            if(lottos[i] == 0){
                zero_count += 1;
            } else {
                if(list.contains(lottos[i])) win_count += 1;
            }
        }
        answer[0] = 7-(win_count+zero_count);
        if (answer[0] > 6) answer[0] = 6;
        answer[1] = 7-win_count;
        if (answer[1] > 6) answer[1] = 6;
        return answer;
    }
}