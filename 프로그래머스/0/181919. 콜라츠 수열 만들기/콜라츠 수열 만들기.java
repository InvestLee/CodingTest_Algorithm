import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(n));
        while(n != 1){
            if(n % 2 == 0) arr.add(n /= 2);
            else arr.add(n = 3 * n + 1);
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) answer[i] = arr.get(i);
        return answer;
    }
}