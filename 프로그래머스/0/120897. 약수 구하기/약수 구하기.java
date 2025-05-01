import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++) if(n % i == 0) arr.add(i);
        int[] answer = new int[arr.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = arr.get(i);
        return answer;
    }
}