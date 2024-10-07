class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        int quo, remain;
        if(s < n){
            answer = new int[]{-1};
        } else {
            answer = new int[n];
            quo = s / n;
            remain = s % n;
            
            for(int i = 0; i < n - remain; i++){
                answer[i] = quo;
            }
            for(int i = n - remain; i < n; i++){
                answer[i] = quo+1;
            }
        }
        return answer;
    }
}