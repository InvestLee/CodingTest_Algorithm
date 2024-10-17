class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = 1;
        long sum1 = 0;
        long sum2 = 0;
        for(int s : sequence){
            sum1 += s * n;
            n *= -1;
            sum2 += s * n;
            sum1 = Math.max(0, sum1);
            sum2 = Math.max(0, sum2);
            answer = Math.max(answer, Math.max(sum1, sum2));
        }
        
        return answer;
    }
}