import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        PriorityQueue<Integer> pq;
        for(int i = 0; i < commands.length; i++){
            pq = new PriorityQueue<>();
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++){
                pq.offer(array[j]);
            }
            for(int j = 0; j < commands[i][2]-1; j++){
                pq.poll();
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}