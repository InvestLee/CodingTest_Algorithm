class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 4; i <= n; i++){
            for(int j = 2; j <= Math.sqrt(i); j++) if(i % j == 0) {
                answer++;
                break;
            }
        }
        return answer;
    }
}